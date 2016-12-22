package br.com.materres.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="idCliente")
    private Integer id;
    @Column(name="cpf", unique = true, length = 14)
    private String cpf;
    @Column(name="cnpj", unique = true, length = 18)
    private String cnpj;
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
    @Column(name = "logradouro", length = 45)
    private String logradouro;
    @Column(name = "bairro", length = 45)
    private String bairro;
    @Column(name = "complemento", length = 45)
    private String complemento;
    @Column(name = "cep",  length = 15)
    private String cep;
    @Column(name = "cidade",  length = 20)
    private String cidade;
    @Column(name = "estado",  length = 30)
    private String estado;
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "cnh",  length = 10)
    private String cnh;
    @Column(name = "categoriaCNH",  length = 10)
    private String categoriaCNH;
    @Column(name = "validadeCNH")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validadeCNH;
    @Column(name = "primeiraCNH")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date primeiraCNH;
    @Column(name = "rg",  length = 10)
    private String rg;
    @Column(name = "emissorRG",  length = 10)
    private String emissorRG;
    @Column(name = "dataEmissaoRG")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissaoRG;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteItens")
    private List<Item> itens;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteSeguro")
    private List<Seguro> seguros;

    public Cliente() {
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

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCnh() {
        return cnh;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }
    
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getValidadeCNH() {
        return validadeCNH;
    }

    public void setValidadeCNH(Date validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public Date getPrimeiraCNH() {
        return primeiraCNH;
    }

    public void setPrimeiraCNH(Date primeiraCNH) {
        this.primeiraCNH = primeiraCNH;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmissorRG() {
        return emissorRG;
    }

    public void setEmissorRG(String emissorRG) {
        this.emissorRG = emissorRG;
    }

    public Date getDataEmissaoRG() {
        return dataEmissaoRG;
    }

    public void setDataEmissaoRG(Date dataEmissaoRG) {
        this.dataEmissaoRG = dataEmissaoRG;
    }
    
    
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
