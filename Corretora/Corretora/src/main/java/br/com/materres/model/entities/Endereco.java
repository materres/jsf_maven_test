package br.com.materres.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "endereco")

public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idEndereco", nullable = false)
    private Integer id;
    @Column(name = "logradouro", nullable = false, length = 45)
    private String logradouro;
    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;
    @Column (name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "complemento", length = 45)
    private String complemento;
    @Column(name = "cep", nullable = false, length = 15)
    private String cep;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "PFEndereco")
    @JoinColumn(name = "cliente", insertable = false, updatable = false)
    private Cliente cliente;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "PJEndereco")
    @JoinColumn(name = "empresa", insertable = false, updatable = false)
    private Empresa empresa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeEndereco")
    @JoinColumn(name = "cidade")
    private Cidade cidade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereco")
    @JoinColumn(name = "idEstado")
    private Estado estado;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisEndereco")
    @JoinColumn(name = "idPais")
    private Pais pais;

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
