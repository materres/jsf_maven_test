package br.com.materres.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "cidade")

public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idCidade", nullable=false, unique = true)
    private Integer id;
    @Column(name = "nome", length = 50)
    private String nome;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado")
    @ForeignKey(name = "EstadoCidade")
    private Estado estado;
    
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadePF")
    private List<PessoaFisica> pfs;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadePJ")
    private List<PessoaJuridica> pjs;
    
    public Cidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<PessoaFisica> getPfs() {
        return pfs;
    }

    public void setPfs(List<PessoaFisica> pfs) {
        this.pfs = pfs;
    }

    public List<PessoaJuridica> getPjs() {
        return pjs;
    }

    public void setPjs(List<PessoaJuridica> pjs) {
        this.pjs = pjs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
