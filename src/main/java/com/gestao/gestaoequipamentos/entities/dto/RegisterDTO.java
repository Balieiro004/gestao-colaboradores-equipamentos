package com.gestao.gestaoequipamentos.entities.dto;

import com.gestao.gestaoequipamentos.entities.Enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
