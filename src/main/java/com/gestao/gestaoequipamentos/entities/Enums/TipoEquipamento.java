package com.gestao.gestaoequipamentos.entities.Enums;

public enum TipoEquipamento {
    NOTEBOOK(1),
    MACBOOK(2),
    MONITOR(3),
    TECLADO(4),
    MOUSE(5),
    HEADSET(6),
    SUPORTE(7),
    ADAPTADOR(8),
    CELULAR(9);

    private int code;

    TipoEquipamento(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoEquipamento valueOf(int code) {
        for(TipoEquipamento value: TipoEquipamento.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid type code");
    }
}
