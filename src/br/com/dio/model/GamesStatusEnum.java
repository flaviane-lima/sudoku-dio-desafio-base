package br.com.dio.model;

public enum GamesStatusEnum {
    NOW_STARTED("não iniciado"),
    INCOMPLETE("incompleto"),
    COMPLETE("completo");

    private String label;

    GamesStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
