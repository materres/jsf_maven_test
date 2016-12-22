package br.com.materres.support;

import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Seguradora;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbSeguradora")
@RequestScoped

public class BbSeguradora implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<Seguradora> getSeguradoras() {
        InterfaceDAO<Seguradora> seguradoraDAO = new HibernateDAO<Seguradora>(Seguradora.class, 
                FacesContextUtil.getRequestSession());
        return seguradoraDAO.getEnteties();
    }
}
