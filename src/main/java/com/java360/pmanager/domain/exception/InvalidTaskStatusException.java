package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class InvalidTaskStatusException extends RequestException {

    public InvalidTaskStatusException(String statusStr) {
        super("InvalidTaskStatus", "Status da Tarefa inválida: " + statusStr);
    }
}
