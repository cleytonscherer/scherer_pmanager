package com.java360.pmanager.infrascructure.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class SaveProjectDataDTO {

    @NotNull(message = "Nome do Projeto deve ser informado")
    @Size(min = 1, max = 100, message = "Tamanho máximo do Nome: 100 caracteres")
    private final String  name;

    @NotNull(message = "Descrição do Projeto deve ser informada")
    @Size(min = 1, max = 150, message = "Tamanho máximo da Descrição: 100 caracteres")
    private final String  description;

    @NotNull(message = "Data inicial deve ser informada")
    private final LocalDate initialDate;

    @NotNull(message = "Data final deve ser informada")
    private final LocalDate finalDate;

    private final String  status;

    private final Set<String> memberIds;

    @AssertTrue(message = "Data final anterior a data inicial")
    @SuppressWarnings("unused")
    private boolean isInitialDateBeforeFinalDate() {
        return initialDate.isBefore(finalDate);
    }

}
