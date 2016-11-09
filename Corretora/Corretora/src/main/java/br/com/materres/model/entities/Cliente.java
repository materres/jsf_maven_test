package br.com.materres.model.entities;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends PessoaFisica {
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteObjetos")
    private List<Objeto> objetos;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteSeguro")
    private List<Seguro> seguros;

    public Cliente() {
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
    
}
