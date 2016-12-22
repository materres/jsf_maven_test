package br.com.materres.controllers;

import br.com.materres.converters.ConverterSHA1;
import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Corretor;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbCorretor")
@SessionScoped

public class MbCorretor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Corretor corretor = new Corretor();
    private List<Corretor> corretores;
    private String senha;
    
    public MbCorretor() {
    }

    private InterfaceDAO<Corretor> corretorDAO() {
        InterfaceDAO<Corretor> corretorDAO = new HibernateDAO<Corretor>(Corretor.class, FacesContextUtil.getRequestSession());
        return corretorDAO;
    }
    
    public void limpaTudo() {
        corretor = new Corretor();
//        editaCorretor();
    }
    
    public String editaCorretor() {
        return "/restrict/corretor/adiciona.htm?faces-redirect=true";
    }
    
    public void adicionaCorretor() {
        if ((corretor.getId() == null) || (corretor.getId() == 0)) {
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
    
}
