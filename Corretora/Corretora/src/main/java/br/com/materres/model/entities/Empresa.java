package br.com.materres.model.entities;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("empresa")
public class Empresa extends PessoaJuridica {
    
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EmpresaSeguro")
    private List<Seguro> seguros;
    
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EmpresaObjetos")
    private List<Objeto> objetos;

    public Empresa() {
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
