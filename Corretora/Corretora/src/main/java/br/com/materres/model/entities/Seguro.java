package br.com.materres.model.entities;

import br.com.materres.model.enums.TipoSeguro;
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
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Seguro")
public class Seguro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name="IdSeguro", nullable=false)
    private Integer id;
    @Column(name="numeroApolice", nullable=false, unique = true, length = 30)
    private String numeroApolice;
    @Column(name="numeroProposta", nullable=false, unique = true, length = 30)
    private String numeroProposta;
    @Enumerated(EnumType.STRING)
    @Column(name = "ramo", nullable = false, length = 30)
    private TipoSeguro ramo;
    
    
    @Column(name = "dataProposta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataProposta;
    @Column(name = "dataEmissao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "dataVigenciaInicial", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVigenciaInicial;
    @Column(name = "dataVigenciaFinal", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVigenciaFinal;
    @Column(name = "dataInclusao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    @Column(name = "dataAtualizacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;   
    
    @Column(name = "numeroParcelas", nullable = false)
    private Integer numeroParcelas;
    @Column(name = "prazoParcela", nullable = false)
    private Integer prazoParcela;
        
    @Column(name = "premioLiquido", nullable = false, length = 20)
    private String premioLiquido;
    @Column(name = "premioAdicional", nullable = false, length = 20)
    private String premioAdicional;
    @Column(name = "premioDesconto", nullable = false, length = 20)
    private String premioDesconto;
    @Column(name = "premioCusto", nullable = false, length = 20)
    private String premioCusto;
    @Column(name = "premioIOF", nullable = false, length = 20)
    private String premioIOF;
    @Column(name = "premioTotal", nullable = false, length = 20)
    private String premioTotal;
    
    @Column(name = "codigoInterno", nullable = false, length = 30)
    private String codigoInterno;
    
    @Column(name = "bonusClasse", nullable = false, length = 20)
    private String bonusClasse;
    @Column(name = "bonusPercentual", nullable = false, length = 20)
    private String bonusPercentual;
    
    @Column(name = "comissaoPercentual", nullable = false, length = 10)
    private String comissaoPercentual;
    @Column(name = "comissaoValor", nullable = false, length = 20)
    private String comissaoValor;

    /*    Relacionamentos   */
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteSeguro")
    @JoinColumn(name = "ClienteFK")
    private Cliente cliente;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguradoraSeguro")
    @JoinColumn(name = "SeguradoraFK")
    private Seguradora seguradora;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CorretorSeguro")
    @JoinColumn(name = "CorretorFK")
    private Corretor corretor;
    
    public Seguro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public String getNumeroProposta() {
        return numeroProposta;
    }

    public void setNumeroProposta(String numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    public TipoSeguro getRamo() {
        return ramo;
    }

    public void setRamo(TipoSeguro ramo) {
        this.ramo = ramo;
    }
    
    public Date getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(Date dataProposta) {
        this.dataProposta = dataProposta;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVigenciaInicial() {
        return dataVigenciaInicial;
    }

    public void setDataVigenciaInicial(Date dataVigenciaInicial) {
        this.dataVigenciaInicial = dataVigenciaInicial;
    }

    public Date getDataVigenciaFinal() {
        return dataVigenciaFinal;
    }

    public void setDataVigenciaFinal(Date dataVigenciaFinal) {
        this.dataVigenciaFinal = dataVigenciaFinal;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }    

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getPrazoParcela() {
        return prazoParcela;
    }
    
    public void setPrazoParcela(Integer prazoParcela) {
        this.prazoParcela = prazoParcela;
    }

    public String getPremioLiquido() {
        return premioLiquido;
    }

    public void setPremioLiquido(String premioLiquido) {
        this.premioLiquido = premioLiquido;
    }

    public String getPremioAdicional() {
        return premioAdicional;
    }

    public void setPremioAdicional(String premioAdicional) {
        this.premioAdicional = premioAdicional;
    }

    public String getPremioDesconto() {
        return premioDesconto;
    }

    public void setPremioDesconto(String premioDesconto) {
        this.premioDesconto = premioDesconto;
    }

    public String getPremioCusto() {
        return premioCusto;
    }

    public void setPremioCusto(String premioCusto) {
        this.premioCusto = premioCusto;
    }

    public String getPremioIOF() {
        return premioIOF;
    }

    public void setPremioIOF(String premioIOF) {
        this.premioIOF = premioIOF;
    }

    public String getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(String premioTotal) {
        this.premioTotal = premioTotal;
    }

    public String getBonusClasse() {
        return bonusClasse;
    }

    public void setBonusClasse(String bonusClasse) {
        this.bonusClasse = bonusClasse;
    }

    public String getBonusPercentual() {
        return bonusPercentual;
    }

    public void setBonusPercentual(String bonusPercentual) {
        this.bonusPercentual = bonusPercentual;
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

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Seguro other = (Seguro) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }      
    
}
