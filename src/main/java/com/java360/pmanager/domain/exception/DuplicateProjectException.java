package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class DuplicateProjectException extends RequestException {

    public DuplicateProjectException(String name) {
        super("ProjectDuplicate", "Já existe um Projeto com o nome: " + name);
    }
}
