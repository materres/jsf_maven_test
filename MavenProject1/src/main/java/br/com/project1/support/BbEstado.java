package br.com.project1.support;

import br.com.project1.model.dao.HibernateDAO;
import br.com.project1.model.dao.InterfaceDAO;
import br.com.project1.model.entities.Estado;
import br.com.project1.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbestado")
@RequestScoped

public class BbEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEnteties();
    }
    
}
