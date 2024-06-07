package org.personal.app.pwdgen.web.advice;


import org.personal.app.common.exceptions.GlobalException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class PasswordExceptionHandler
{

    @ExceptionHandler(GlobalException.class)
    ProblemDetail handleGlobal(GlobalException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getHttpStatus(), ex.getMessage());
        problemDetail.setTitle(ex.getErrorCode());
        return problemDetail;
    }

}
