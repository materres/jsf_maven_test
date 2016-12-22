package br.com.materres.support;

import br.com.materres.converters.ConverterNumber;
import br.com.materres.model.enums.SeletorConversao;

public class ValorPremio {
    private Double premioLiquido;
    private Double premioAdicional;
    private Double premioDesconto;
    private Double premioCusto;
    private Double premioIOF;
    private Double premioTotal;
    private Double percentual;
    private Double comissao;

    public ValorPremio() {
        this.comissao = 0.0;
        this.percentual = 10.0;
        this.premioAdicional = 0.0;
        this.premioCusto = 0.0;
        this.premioDesconto = 0.0;
        this.premioIOF = 0.0;
        this.premioLiquido = 0.0;
        this.premioTotal = 0.0;
    }
    
    public void setValorPremio(String pl, String pa, String pd, String pc, String pi, String pt) {
        
        this.premioLiquido = ConverterNumber.toDouble(SeletorConversao.NUMERO, pl);
        this.premioAdicional = ConverterNumber.toDouble(SeletorConversao.NUMERO, pa);
        this.premioDesconto = ConverterNumber.toDouble(SeletorConversao.NUMERO, pd);
        this.premioCusto = ConverterNumber.toDouble(SeletorConversao.NUMERO, pc);
        this.premioIOF = ConverterNumber.toDouble(SeletorConversao.NUMERO, pi);
        this.premioTotal = ConverterNumber.toDouble(SeletorConversao.NUMERO, pt);
    }

    public Double getPremioLiquido() {
        return premioLiquido;
    }

    public void setPremioLiquido(Double premioLiquido) {
        this.premioLiquido = premioLiquido;
    }

    public Double getPremioAdicional() {
        return premioAdicional;
    }

    public void setPremioAdicional(Double premioAdicional) {
        this.premioAdicional = premioAdicional;
    }

    public Double getPremioDesconto() {
        return premioDesconto;
    }

    public void setPremioDesconto(Double premioDesconto) {
        this.premioDesconto = premioDesconto;
    }

    public Double getPremioCusto() {
        return premioCusto;
    }

    public void setPremioCusto(Double premioCusto) {
        this.premioCusto = premioCusto;
    }

    public Double getPremioIOF() {
        return premioIOF;
    }

    public void setPremioIOF(Double premioIOF) {
        this.premioIOF = premioIOF;
    }

    public Double getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(Double premioTotal) {
        this.premioTotal = premioTotal;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    
}
