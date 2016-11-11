package br.com.materres.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="pais")

public class Pais implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idPais", nullable=false, unique = true)
    private Integer id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "sigla", length = 5)
    private String sigla;
    
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisEstado")
    private List<Estado> estados;
    
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisPF")
    private List<PessoaFisica> pfs;

    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisPJ")
    private List<PessoaJuridica> pjs;
    
    public Pais() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
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
        int hash = 3;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Pais other = (Pais) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
