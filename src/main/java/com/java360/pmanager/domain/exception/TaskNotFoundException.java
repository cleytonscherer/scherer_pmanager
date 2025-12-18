package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class TaskNotFoundException extends RequestException {

    public TaskNotFoundException(String taskId) {
        super("TaskNotFound", "Tarefa não encontrada: " + taskId);
    }
}
