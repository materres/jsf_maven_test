package br.com.materres.model.enums;

public enum TipoImovel {
    APARTAMENTO("Apartamento"),
    CASA("Casa"),
    COMERCIAL("Comercial"),
    FABRICA("Fábrica"),
    FAZENDA("Fazenda"),
    LOJA("Loja"),
    SITIO("Sítio");
    
    private String label;

    private TipoImovel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
