package br.com.materres.controllers;

import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Seguradora;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MbSeguradora implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Seguradora seguradora = new Seguradora();  
    private List<Seguradora> seguradoras;
    
    public MbSeguradora() {
    }
    
    public InterfaceDAO<Seguradora> seguradoraDAO() {
        InterfaceDAO<Seguradora> seguradoraDAO = new HibernateDAO<Seguradora>(Seguradora.class,
                FacesContextUtil.getRequestSession());
        return seguradoraDAO;
    }
    
    public void limpaSeguradora() {
        System.out.println("LIMPOU O OBJETO ATUAL");
        seguradora = new Seguradora();
    }
    
    public String editaSeguradora() {
        return "/restrict/seguradora/gerencia_seguradora.htm";
    }
    
    public void adicionaSeguradora(){
        if ((seguradora.getId() == null) || (seguradora.getId() == 0)) {
            seguradoraDAO().save(seguradora);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Gravação efetuada com sucesso", ""));
        } else {
            seguradoraDAO().update(seguradora);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Atualização efetuada com sucesso", ""));
        }
        limpaSeguradora();
    }
    
    public void deletaSeguradora() {
        seguradoraDAO().remove(seguradora);
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Remoção efetuada com sucesso", ""));
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public List<Seguradora> getSeguradoras() {
        seguradoras = seguradoraDAO().getEnteties();
        return seguradoras;
    }

    public void setSeguradoras(List<Seguradora> seguradoras) {
        this.seguradoras = seguradoras;
    }
}
