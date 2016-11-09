package br.com.materres.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("corretora")
public class Corretora extends PessoaJuridica{
     
    @OneToMany(mappedBy = "corretora", fetch = FetchType.LAZY)
    @ForeignKey(name = "CorretoraSeguro")
    private List<Seguro> seguros;

    public Corretora() {
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
    
    
}
