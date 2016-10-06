package br.com.project1.support;

import br.com.project1.model.dao.HibernateDAO;
import br.com.project1.model.dao.InterfaceDAO;
import br.com.project1.model.entities.TipoLogradouro;
import br.com.project1.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbTipoLogradouro")
@RequestScoped

public class BbTipoLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<TipoLogradouro> getTipoLogradouros(){
        InterfaceDAO<TipoLogradouro> tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
        return tipoLogradouroDAO.getEnteties();
    }
}
