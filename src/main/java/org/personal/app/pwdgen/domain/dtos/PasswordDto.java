package org.personal.app.pwdgen.domain.dtos;



public record PasswordDto(
        Long id,
        String name,
        String password,
        Boolean hasLowerCase,
        Boolean hasUpperCase,
        Boolean hasNumbers,
        Boolean hasSpecialChars,
        Integer length
){}
