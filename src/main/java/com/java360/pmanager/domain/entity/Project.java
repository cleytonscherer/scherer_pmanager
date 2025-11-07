package com.java360.pmanager.domain.entity;

import com.java360.pmanager.domain.model.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private String  id;

    private String  name;

    private String  description;

    private LocalDate   initialDate;

    private LocalDate   finalDate;

    private ProjectStatus   status;
}
