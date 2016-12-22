package br.com.materres.controllers;

import br.com.materres.converters.ConverterNumber;
import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Cliente;
import br.com.materres.model.entities.Imovel;
import br.com.materres.model.entities.Item;
import br.com.materres.model.entities.Movel;
import br.com.materres.model.entities.Parcela;
import br.com.materres.model.entities.Seguradora;
import br.com.materres.model.entities.Seguro;
import br.com.materres.support.ApoliceAzul;
import br.com.materres.support.PDFManager;
import br.com.materres.support.ValorPremio;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

@ManagedBean
@SessionScoped
public class MbSeguro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente = new Cliente();
    private Seguradora seguradora = new Seguradora();
    private Seguro seguro = new Seguro();
    private Imovel imovel = new Imovel();
    private Movel movel = new Movel();
    
    private PDFManager manager = new PDFManager();
    private ValorPremio premio = new ValorPremio();
    
    private String filepath = "C:/apolice/apolice_tmp.pdf";
    
    private List<Parcela> parcelas;
    private List<Seguro> seguros;

    public MbSeguro() {
    }
    
    public String extrairConteudo() {
        String texto = null;
        manager.setFilePath(filepath);
        
        try {
             texto = manager.ToText();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Problema na abertura do arquivo", ""));
        }
        
        if (seguradora.getNome().contains("AZUL")) {
            trataAzul(texto);
        } else {
            return "/restrict/seguro/adiciona_auto.htm";
        }
        premio.setValorPremio(seguro.getPremioLiquido(), seguro.getPremioAdicional(),
                seguro.getPremioDesconto(), seguro.getPremioCusto(), seguro.getPremioIOF(),
                seguro.getPremioTotal());
        
        return "/restrict/seguro/adiciona.htm";
    }
    
    public void trataAzul(String texto) {
        limpaTudo();
        ApoliceAzul apolice = new ApoliceAzul();
        DetachedCriteria criteria = DetachedCriteria.forClass(Seguro.class);

        Seguro s = apolice.getInfosSeguro(texto);
        criteria.add(Restrictions.eq("seguro.numeroApolice", s.getNumeroApolice()));
        seguro = seguroDAO().getEntityByDetachedCriteria(criteria);
        if (seguro == null) {
            seguro = s;
            cliente = apolice.getInfosCliente(texto);
            parcelas = apolice.getInfosParcela(texto);
        } else {
            cliente = seguro.getCliente();
            criteria = DetachedCriteria.forClass(Parcela.class);
            criteria.add(Restrictions.eq("parcela.seguro", seguro.getId()));
            parcelas = parcelaDAO().getListByDetachedCriteria(criteria);
        }
    }
    
    public void calculaComissao() {
        int numeroParcelas = parcelas.size();
        Double parcelaLiquido = premio.getPremioLiquido()/numeroParcelas;
        Double comissaoPorParcela = parcelaLiquido * premio.getPercentual();
        
        
        premio.setComissao(premio.getPremioLiquido() * premio.getPercentual());
        
        Iterator<Parcela> it = parcelas.iterator();
        while (it.hasNext()) {
            Parcela n = it.next();
            
            n.setComissaoPercentual(seguro.getComissaoPercentual());
            n.setComissaoValor(ConverterNumber.toString(comissaoPorParcela));
            n.setValorLiquido(ConverterNumber.toString(parcelaLiquido));
        }
    }
    
    public void limpaTudo() {
        seguro = new Seguro();
        cliente = new Cliente();
        premio = new ValorPremio();
        imovel = new Imovel();
        movel = new Movel();
    }
    
    public void adicionaSeguro() {
        if ((seguro.getId() == null) || (seguro.getId() == 0)) {
            insereSeguro();
        } else {
            atualizaSeguro();
        }
    }
    
    public void insereSeguro() {
        Date data = new Date();
        seguro.setDataInclusao(data);
        seguro.setDataAtualizacao(data);
        
        seguroDAO().save(seguro);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Gravação efetuada com sucesso", ""));
    }
    
    public void atualizaSeguro() {
        seguro.setDataAtualizacao(new Date());
        seguroDAO().update(seguro);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Atualização efetuada com sucesso", ""));
    }
    
    /* Interfaces DAO */
    
    private InterfaceDAO<Seguro> seguroDAO() {
        InterfaceDAO<Seguro> seguroDAO = new HibernateDAO<Seguro>(Seguro.class,
                FacesContextUtil.getRequestSession());
        return seguroDAO;
    }
    
    private InterfaceDAO<Cliente> clienteDAO() {
        InterfaceDAO<Cliente> clienteDAO = new HibernateDAO<Cliente>(Cliente.class,
                FacesContextUtil.getRequestSession());
        return clienteDAO;
    }
    
    private InterfaceDAO<Parcela> parcelaDAO() {
        InterfaceDAO<Parcela> parcelaDAO = new HibernateDAO<Parcela>(Parcela.class,
                FacesContextUtil.getRequestSession());
        return parcelaDAO;
    }
    
    private InterfaceDAO<Seguradora> seguradoraDAO() {
        InterfaceDAO<Seguradora> seguradoraDAO = new HibernateDAO<Seguradora>(Seguradora.class,
                FacesContextUtil.getRequestSession());
        return seguradoraDAO;
    }
    
    /* Getters and Setters */

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ValorPremio getPremio() {
        return premio;
    }

    public void setPremio(ValorPremio premio) {
        this.premio = premio;
    }
    
    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public List<Seguro> getSeguros() {
        seguros = seguroDAO().getEnteties();
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

}
