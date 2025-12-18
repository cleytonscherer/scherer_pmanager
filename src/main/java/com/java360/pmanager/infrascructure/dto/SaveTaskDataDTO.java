package com.java360.pmanager.infrascructure.dto;

import com.java360.pmanager.domain.model.TaskStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveTaskDataDTO {
    @NotNull(message = "Título deve ser informado")
    @Size(min = 1, max = 100, message = "Título deve ter um tamanho máximo de 100 caracteres")
    private final String  title;

    @NotNull(message = "Descrição deve ser informada")
    @Size(min = 1, max = 200, message = "Descrição deve ter um tamanho máximo de 200 caracteres")
    private final String  description;

    @NotNull(message = "Número de Dias deve ser informado")
    @Positive(message = "Número de Dias deve ser um valor positivo")
    private final Integer numberOfDays;

    private final String status;

    private final String projectId;

    private final String memberId;
}
