package br.com.materres.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "pessoaJuridica")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPJ")
public class PessoaJuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idPJ", nullable=false)
    private Integer id;
    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Column(name = "telefoneA", nullable = false, length = 14 )
    private String telefoneA;
    @Column(name = "telefoneB", length = 14)
    private String telefoneB;
    @Column(name = "ramalA", length = 10)
    private String ramalA;
    @Column(name = "ramalB", length = 10)
    private String ramalB;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "logradouro", length = 45)
    private String logradouro;
    @Column(name = "bairro", length = 45)
    private String bairro;
    @Column (name = "numero", length = 6)
    private String numero;
    @Column(name = "complemento", length = 45)
    private String complemento;
    @Column(name = "cep", length = 15)
    private String cep;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadePJ")
    @JoinColumn(name = "cidade")
    private Cidade cidade;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoPJ")
    @JoinColumn(name = "estado")
    private Estado estado;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisPJ")
    @JoinColumn(name = "pais")
    private Pais pais;

    public PessoaJuridica() {
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

    public String getTelefoneB() {
        return telefoneB;
    }

    public void setTelefoneB(String telefoneB) {
        this.telefoneB = telefoneB;
    }

    public String getRamalA() {
        return ramalA;
    }

    public void setRamalA(String ramalA) {
        this.ramalA = ramalA;
    }

    public String getRamalB() {
        return ramalB;
    }

    public void setRamalB(String ramalB) {
        this.ramalB = ramalB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
