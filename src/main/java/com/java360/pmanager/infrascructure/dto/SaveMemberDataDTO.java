package com.java360.pmanager.infrascructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveMemberDataDTO {

    @NotNull(message = "Nome do Membro deve ser informado")
    @Size(min = 1, max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private final String  name;

    @NotNull(message = "e-mail do Membro deve ser informado")
    @Email(message = "Endereço de e-mail inválido")
    private final String  email;
}
