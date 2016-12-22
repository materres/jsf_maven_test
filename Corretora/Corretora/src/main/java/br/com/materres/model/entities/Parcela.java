package br.com.materres.model.entities;

import br.com.materres.model.enums.FormaPagamento;
import br.com.materres.model.enums.StatusParcela;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "parcela")
public class Parcela implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "idParcela")
    private Integer id;
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "valor", nullable = false, length = 20)
    private String valor;
    @Column(name = "valorLiquido", nullable = false, length = 20)
    private String valorLiquido;
    @Enumerated(EnumType.STRING)
    @Column(name = "formaPagamento", nullable = true)
    private FormaPagamento formaPagamento;
    @Column(name = "comissaoPercentual", nullable = true, length = 5)
    private String comissaoPercentual;
    @Column(name = "comissaoValor", nullable = true, length = 20)
    private String comissaoValor;
    @Column(name="dataVencimento", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;
    @Column(name="dataQuitacao", nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataQuitacao;
    @Enumerated(EnumType.STRING)
    @Column(name="statusParcela", nullable=true)
    private StatusParcela statusParcela;    
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguroParcela")
    @JoinColumn(name = "SeguroFK")
    private Seguro seguro;

    public Parcela() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(String valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
    
    public String getComissaoPercentual() {
        return comissaoPercentual;
    }

    public void setComissaoPercentual(String comissaoPercentual) {
        this.comissaoPercentual = comissaoPercentual;
    }
    
    public String getComissaoValor() {
        return comissaoValor;
    }

    public void setComissaoValor(String comissaoValor) {
        this.comissaoValor = comissaoValor;
    }
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public StatusParcela getStatusParcela() {
        return statusParcela;
    }

    public void setStatusParcela(StatusParcela statusParcela) {
        this.statusParcela = statusParcela;
    }
    
    
    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Parcela other = (Parcela) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
