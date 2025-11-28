package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrascructure.exception.RequestException;

public class MemberNotFoundException extends RequestException {

    public MemberNotFoundException(String memberId) {
        super("MemberNotFound", "Membro não encontrado: " + memberId);
    }
}
