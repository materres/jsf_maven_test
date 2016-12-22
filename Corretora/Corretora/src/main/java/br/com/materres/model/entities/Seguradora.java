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
@Table(name = "seguradora")
public class Seguradora implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idSeguradora", nullable=false)
    private Integer id;
    @Column(name="cnpj", nullable=false, length = 18)
    private String cnpj;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Column(name = "telefoneA", nullable = false, length = 15)
    private String telefoneA;
    @Column(name = "ramalA", length = 10)
    private String ramalA;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    
    @OneToMany(mappedBy = "seguradora", fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguradoraSeguro")
    private List<Seguro> seguros;

    public Seguradora() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneA() {
        return telefoneA;
    }

    public void setTelefoneA(String telefoneA) {
        this.telefoneA = telefoneA;
    }

    public String getRamalA() {
        return ramalA;
    }

    public void setRamalA(String ramalA) {
        this.ramalA = ramalA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Seguradora other = (Seguradora) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
