package br.com.project1.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="TipoLogradouro")

public class TipoLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdTipoLogradouro")
    private Integer idTipoLogradouro;
    @Column(name="Descricao", length=40)
    private String descricao;
    
    @OneToMany
    @ForeignKey(name="TipoLogradouroEndereco")
    private List<Endereco> enderecos;

    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        return true;
    }
    
    
    
}
