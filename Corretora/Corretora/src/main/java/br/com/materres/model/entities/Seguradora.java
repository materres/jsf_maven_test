package br.com.materres.model.entities;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("seguradora")
public class Seguradora extends PessoaJuridica{
    
    @OneToMany(mappedBy = "seguradora", fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguradoraSeguro")
    private List<Seguro> seguros;

    public Seguradora() {
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
}
