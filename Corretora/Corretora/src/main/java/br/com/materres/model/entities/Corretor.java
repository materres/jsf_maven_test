package br.com.materres.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue("corretor")
public class Corretor extends Funcionario{
    
    @Column(name = "usuario", nullable = false, unique = true, length = 20)
    private String usuario;
    @Column(name = "senha", nullable = false, unique = true, length = 80)
    private String senha;    
    @Column(name = "Permissao", length = 30)
    private String permissao;
    @Column(name = "bonus", nullable = false, length = 5)
    private String bonus;
    
    @OneToMany(mappedBy = "corretor", fetch = FetchType.LAZY)
    @ForeignKey(name = "CorretorSeguro")
    private List<Seguro> seguros;

    public Corretor() {
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

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
}