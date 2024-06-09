package org.personal.app.pwdgen.web.exceptions;

import org.personal.app.common.exceptions.GlobalException;
import org.personal.app.common.utils.ErrorCode;
import org.springframework.http.HttpStatus;

public class InvalidPasswordRequest extends GlobalException {

    public InvalidPasswordRequest(String message, String errorCode) {
        super(message, errorCode, HttpStatus.BAD_REQUEST);
    }
}
