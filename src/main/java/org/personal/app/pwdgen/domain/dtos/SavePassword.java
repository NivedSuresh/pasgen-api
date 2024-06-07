package org.personal.app.pwdgen.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record SavePassword(

        @Size(min = 4, max = 20, message = "Password should be of size 4-20 characters")
        String password,

        @NotEmpty(message = "Please provide a valid name for the password to be saved")
        String name


) {}
