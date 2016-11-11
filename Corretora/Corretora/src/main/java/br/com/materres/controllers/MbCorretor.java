package br.com.materres.controllers;

import br.com.materres.converters.ConverterSHA1;
import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Cidade;
import br.com.materres.model.entities.Corretor;
import br.com.materres.model.entities.Estado;
import br.com.materres.model.entities.Pais;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "mbCorretor")
@SessionScoped

public class MbCorretor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Corretor corretor = new Corretor();
    private Pais pais = new Pais();
    private Estado estado = new Estado();
    private Cidade cidade = new Cidade();
    
    private String senha;
    
    private List<Corretor> corretores;
    private List<Estado> listaEstados;
    private List<Cidade> listaCidades;
    
    public MbCorretor() {
    }

    private InterfaceDAO<Corretor> corretorDAO() {
        InterfaceDAO<Corretor> corretorDAO = new HibernateDAO<Corretor>(Corretor.class, FacesContextUtil.getRequestSession());
        return corretorDAO;
    }
    
    public void onPaisChange () {
        setListaEstados(getEstados());
    }
    
    public void onEstadoChange () {
        setListaCidades(getCidades());
    }
    
    public List<Pais> getPaises(){
        InterfaceDAO<Pais> paisDAO = new HibernateDAO<Pais>(Pais.class, 
                FacesContextUtil.getRequestSession());
        return paisDAO.getEnteties();
    }
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, 
                FacesContextUtil.getRequestSession());
        DetachedCriteria criteria = DetachedCriteria.forClass(Estado.class);
        if (pais.getId() != null) {
            criteria.add(Restrictions.eq("pais.id",pais.getId()));
            criteria.addOrder(Order.asc("nome"));
            return estadoDAO.getListByDetachedCriteria(criteria);
        }
       return null;
    }

    public List<Cidade> getCidades(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, 
                FacesContextUtil.getRequestSession());
        DetachedCriteria criteria = DetachedCriteria.forClass(Cidade.class);
        if (estado.getId() != null) {
            criteria.add(Restrictions.eq("estado.id",estado.getId()));
            criteria.addOrder(Order.asc("nome"));
            return cidadeDAO.getListByDetachedCriteria(criteria);
        }
        return null;
    }
    
    public void limpaTudo() {
        corretor = new Corretor();
//        editaCorretor();
    }
    
    public String editaCorretor() {
        return "/restrict/corretor/adiciona_corretor.htm?faces-redirect=true";
    }
    
    public void adicionaCorretor() {
        if ((corretor.getId() == null) || (corretor.getId() == 0)) {
            corretor.setPais(pais);
            corretor.setEstado(estado);
            corretor.setCidade(cidade);
            insereCorretor(corretor);
        } else {
            atualizaCorretor(corretor);
        }
    }
    
    private Boolean testaSenha() {
        
        System.out.println("Senha 1: " + corretor.getSenha() + "Senha 2: " + senha);
        
        if (senha.equals(corretor.getSenha())) {
            corretor.setSenha(ConverterSHA1.cifra(senha));
            return true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Senhas não conferem.", ""));
        }
        return false;
    }
    
    private void insereCorretor(Corretor corretor) {
        Date date = new Date();
        
        if (testaSenha()) {
//            corretor.setDataInicio(date);
            corretorDAO().save(corretor);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação ocorreu com sucesso.", ""));
            limpaTudo();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: gravação NÃO ocorreu!", ""));
        }
    }
    
    private void atualizaCorretor(Corretor corretor) {
        corretorDAO().update(corretor);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação ocorreu com sucesso.", ""));
    }
    
    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public List<Corretor> getCorretores() {
        corretores = corretorDAO().getEnteties();
        return corretores;
    }

    public void setCorretores(List<Corretor> corretores) {
        this.corretores = corretores;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }
    
}
