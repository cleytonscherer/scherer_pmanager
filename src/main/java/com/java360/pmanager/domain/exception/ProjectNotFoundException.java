package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class ProjectNotFoundException extends RequestException {

    public ProjectNotFoundException(String projectId) {
        super("ProjectNotFound", "Projeto não encontrado: " + projectId);
    }
}
