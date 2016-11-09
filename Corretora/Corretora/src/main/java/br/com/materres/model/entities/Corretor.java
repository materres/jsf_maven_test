package br.com.materres.model.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("corretor")
public class Corretor extends PessoaFisica{
    
    @Column(name = "dataInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "usuario", nullable = false, unique = true, length = 20)
    private String usuario;
    @Column(name = "senha", nullable = false, unique = true, length = 80)
    private String senha;    
    @Column(name = "Permissao", length = 30)
    private String permissao;
    @Column(name = "salario", nullable = false)
    private float salario;
    @Column(name = "bonus", nullable = false)
    private float bonus;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "CorretorCorretora")
    @JoinColumn(name = "cnpj")
    private Corretora corretora;
    
    @OneToMany(mappedBy = "corretor", fetch = FetchType.LAZY)
    @ForeignKey(name = "CorretorSeguro")
    private List<Seguro> seguros;

    public Corretor() {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

}