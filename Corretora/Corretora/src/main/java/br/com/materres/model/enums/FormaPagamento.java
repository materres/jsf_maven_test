package br.com.materres.model.enums;

public enum FormaPagamento {
    A_VISTA("A vista"),
    BOLETO("Boleto"),
    DEBITO_AUTOMATICO("Débito Automático"),
    FICHA_COMPENSACAO("Ficha de Compensação");
    
    private String label;
    
    private FormaPagamento(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
}
