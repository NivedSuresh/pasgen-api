package org.personal.app.pwdgen.domain;

import org.personal.app.pwdgen.domain.dtos.PasswordDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper
{
    PasswordDto toDto(PasswordEntity entity){
        return new PasswordDto(
                entity.getId(),
                entity.getName(),
                entity.getPassword(),
                entity.getHasLowerCase(),
                entity.getHasUpperCase(),
                entity.getHasNumbers(),
                entity.getHasSpecialChars(),
                entity.getLength()
        );
    }
}
