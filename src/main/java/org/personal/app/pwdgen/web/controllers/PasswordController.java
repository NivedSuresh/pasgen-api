package org.personal.app.pwdgen.web.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.personal.app.common.models.PagedDto;
import org.personal.app.pwdgen.domain.PasswordService;
import org.personal.app.pwdgen.domain.dtos.Password;
import org.personal.app.pwdgen.domain.dtos.PasswordDto;
import org.personal.app.pwdgen.domain.dtos.PasswordRequest;
import org.personal.app.pwdgen.domain.dtos.SavePassword;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class PasswordController {

    private final PasswordService passwordService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Password generateNewPassword(@RequestBody @Valid final PasswordRequest passwordRequest)
    {
        final String pas = this.passwordService.generatePassword(passwordRequest);
        return new Password(pas);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    PasswordDto savePassword(@RequestBody @Valid final SavePassword saveRequest,
                      @RequestHeader("x-auth-user-id") final Long ucid)
    {
        return this.passwordService.savePassword(saveRequest, ucid);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    PagedDto<PasswordDto> getPasswords(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                                       @RequestParam(value = "count", defaultValue = "10", required = false) Integer count,
                                       @RequestHeader("x-auth-user-id") final Long ucid)
    {
        return this.passwordService.getPagedPasswords(page, count, ucid);
    }

}
