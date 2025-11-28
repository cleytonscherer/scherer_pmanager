package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class DuplicateMemberException extends RequestException {

    public DuplicateMemberException(String email) {
        super("MemberDuplicate", "Já existe um membro com o e-mail: " + email);
    }
}
