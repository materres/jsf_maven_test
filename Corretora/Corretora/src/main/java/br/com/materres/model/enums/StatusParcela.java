package br.com.materres.model.enums;

public enum StatusParcela {
    PAGA("Paga"),
    EM_ABERTO("Em Aberto");
    
    private String label;

    private StatusParcela(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
