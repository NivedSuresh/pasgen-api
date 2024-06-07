package org.personal.app.pwdgen.domain.dtos;



public record PasswordDto(
        Long id,
        String password,
        Boolean hasLowerCase,
        Boolean hasUpperCase,
        Boolean hasNumbers,
        Boolean hasSpecialChars,
        Integer length
){}
