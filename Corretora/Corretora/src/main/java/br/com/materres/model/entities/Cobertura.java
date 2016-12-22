package br.com.materres.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "cobertura")
public class Cobertura implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "idCobertura")
    private Integer id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "impSegurada", nullable = false)
    private Integer impSegurada;
    @Column(name = "premio", nullable = false)
    private float premio;
    @Column(name = "valorFranquia", nullable = false)
    private float valorFranquia;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "ItemCobertura")
    @JoinColumn(name = "item")
    private Item item;
    
    public Cobertura() {
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

    public Integer getImpSegurada() {
        return impSegurada;
    }

    public void setImpSegurada(Integer impSegurada) {
        this.impSegurada = impSegurada;
    }

    public float getPremio() {
        return premio;
    }

    public void setPremio(float premio) {
        this.premio = premio;
    }

    public float getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(float valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cobertura other = (Cobertura) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
