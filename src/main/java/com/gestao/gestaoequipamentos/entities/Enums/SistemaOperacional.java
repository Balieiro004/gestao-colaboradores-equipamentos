package com.gestao.gestaoequipamentos.entities.Enums;

public enum SistemaOperacional {
    UBUNTUPAG(1),
    UBUNTUCOMPASS(2),
    UBUNTUIFOOD(3),
    WINDOWSPAG(4),
    WINDOWSCOMPASS(5),
    SEQUOIA(6);

    private int code;

    private SistemaOperacional(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SistemaOperacional valueOf(int code) {
        for(SistemaOperacional value: SistemaOperacional.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid System code");
    }
}
