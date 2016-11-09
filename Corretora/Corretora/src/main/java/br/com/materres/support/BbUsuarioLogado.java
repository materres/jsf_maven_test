package br.com.materres.support;

import br.com.materres.model.entities.Corretor;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean (name = "bbusuariologado")
@SessionScoped

public class BbUsuarioLogado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public String getUsuarioLogado() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            Authentication auth = context.getAuthentication();
            if (auth instanceof Authentication) {
                return auth.getName();
            }
        }
        return "Nulo";
    }
    
    public Corretor procuraCorretor(){
        String usuario = getUsuarioLogado();
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from PessoaFisica pf where pf.usuario like ?");
        query.setString(0, usuario);
        return (Corretor) query.uniqueResult();
    }   
}
