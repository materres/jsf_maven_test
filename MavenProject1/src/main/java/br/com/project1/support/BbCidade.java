package br.com.project1.support;

import br.com.project1.model.dao.HibernateDAO;
import br.com.project1.model.dao.InterfaceDAO;
import br.com.project1.model.entities.Cidade;
import br.com.project1.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbCidade")
@RequestScoped

public class BbCidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEnteties();
    }
}
