package br.com.materres.support;

import br.com.materres.model.enums.TipoSeguro;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BbTipoSeguros implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public TipoSeguro[] getTiposSeguro() {
        return TipoSeguro.values();
    }
}
