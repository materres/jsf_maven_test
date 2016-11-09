package br.com.materres.controllers;

import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Corretor;
import br.com.materres.model.entities.Corretora;
import br.com.materres.model.entities.PessoaJuridica;
import br.com.materres.model.entities.Endereco;
import br.com.materres.model.entities.Objeto;
import br.com.materres.model.entities.PessoaFisica;
import br.com.materres.model.entities.Seguro;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbSeguro")
@SessionScoped

public class MbSeguro implements Serializable{
    private static final long serialVersionUID = 1L;
    
}
