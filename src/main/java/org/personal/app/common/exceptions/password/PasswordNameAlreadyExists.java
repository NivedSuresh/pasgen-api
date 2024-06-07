package org.personal.app.common.exceptions.password;

import org.personal.app.common.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class PasswordNameAlreadyExists extends GlobalException {
    public PasswordNameAlreadyExists() {
        super("A password with the same name already exists for the user.", "PASSWORD_NAME_EXISTS", HttpStatus.NOT_ACCEPTABLE);
    }
}
