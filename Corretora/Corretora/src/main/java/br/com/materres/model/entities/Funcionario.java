package br.com.materres.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoFuncionario")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idFuncionario", nullable=false)
    private Integer id;
    @Column(name="cpf", nullable=false, length = 14)
    private String cpf;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Column(name = "telefoneA", nullable = false, length = 14)
    private String telefoneA;
    @Column(name = "telefoneB", length = 14)
    private String telefoneB;
    @Column(name = "ramalA", length = 10)
    private String ramalA;
    @Column(name = "ramalB", length = 10)
    private String ramalB;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "logradouro", length = 45)
    private String logradouro;
    @Column(name = "bairro", length = 45)
    private String bairro;
    @Column (name = "numero", length = 6)
    private String complemento;
    @Column(name = "cep",  length = 15)
    private String cep;
    @Column(name = "cidade",  length = 30)
    private String cidade;
    @Column(name = "estado",  length = 30)
    private String estado;
    @Column(name = "dataInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "salario", nullable = false, length = 25)
    private String salario;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "CorretoraFunc")
    @JoinColumn(name = "corretora")
    private Corretora corretora;
    
    public Funcionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getCidade() {
        return cidade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
