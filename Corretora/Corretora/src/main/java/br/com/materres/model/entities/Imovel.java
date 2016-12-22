package br.com.materres.model.entities;

import br.com.materres.model.enums.TipoImovel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "idImovel")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoImovel", nullable = false, length = 20)
    private TipoImovel tipoImovel;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguroItem")
    @JoinColumn(name = "seguroFK")
    private Seguro seguro;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteItem")
    @JoinColumn(name = "clienteFK")
    private Cliente cliente;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imovel other = (Imovel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
