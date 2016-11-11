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
@Table(name = "estado")
        
public class Estado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idEstado", nullable=false, unique = true)
    private Integer id;
    @Column(name = "nome", length = 75, nullable = false)
    private String nome;
    @Column(name = "uf", length = 5, nullable = false)
    private String uf;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "PaisEstado")
    @JoinColumn(name = "idPais")
    private Pais pais;
    
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoCidade")
    private List<Cidade> cidades;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoPF")
    private List<PessoaFisica> pfs;
    
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoPJ")
    private List<PessoaJuridica> pjs;
    
    public Estado() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
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
        final Estado other = (Estado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
