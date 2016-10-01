package br.com.project1.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity 
@Table (name="pessoa")

public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable=false)
    private Integer idPessoa;
    @Column(name="Nome", nullable=false, length=80)
    private String nome;
    @Column(name="Telefone", nullable=false, length=14) // (xx)99999-9999
    private String telefone;
    @Column(name="Email", nullable=false, length=80)
    private String email;
    @Column(name="CPF", nullable=false, length=14)
    private String cpf;
    @Column(name="DataDeNascimento", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name="DataDoCadastro", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
}
