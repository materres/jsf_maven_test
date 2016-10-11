package br.com.project1.support;

import br.com.project1.model.dao.HibernateDAO;
import br.com.project1.model.dao.InterfaceDAO;
import br.com.project1.model.entities.TipoEndereco;
import br.com.project1.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbTipoEndereco")
@RequestScoped

public class BbTipoEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<TipoEndereco> getTipoEnderecos(){
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, FacesContextUtil.getRequestSession());
        return tipoEnderecoDAO.getEnteties();
    }
    
}
