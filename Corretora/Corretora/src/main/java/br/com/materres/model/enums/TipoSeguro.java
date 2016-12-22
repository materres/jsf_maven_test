package br.com.materres.model.enums;

public enum TipoSeguro {
    IMOVEL("Imóvel"),
    MOVEL("Móvel"),
    VIDA("Vida");
    
    private String label;

    private TipoSeguro(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
