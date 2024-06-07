package org.personal.app.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalException extends RuntimeException
{
    private final String errorCode;
    private final HttpStatus httpStatus;
    public GlobalException(final String message, final String errorCode, final HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
