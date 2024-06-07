package org.personal.app.pwdgen.domain.dtos;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PasswordRequest {

    @NotNull(message = "Provide a length")
    @Min(value = 4, message = "Password should be of minimum 4 characters")
    @Max(value = 20, message = "Maximum of 20 characters allowed")
    private Integer length;

    @NotNull(message = "Required information was not provided to the server.")
    private Boolean includeLowerCase,
                    includeUpperCase,
                    includeNumbers,
                    includeSpecialChars;


}
