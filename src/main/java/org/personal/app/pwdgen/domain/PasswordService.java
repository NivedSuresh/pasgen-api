package org.personal.app.pwdgen.domain;

import lombok.RequiredArgsConstructor;
import org.personal.app.common.exceptions.password.PasswordNameAlreadyExists;
import org.personal.app.common.models.PagedDto;
import org.personal.app.pwdgen.domain.dtos.PasswordDto;
import org.personal.app.pwdgen.domain.dtos.PasswordRequest;
import org.personal.app.pwdgen.domain.dtos.SavePassword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordRepo passwordRepo;
    private final ModelMapper modelMapper;


    public String generatePassword(PasswordRequest request)
    {
        final StringBuilder sb = new StringBuilder();
        final List<Integer> indexes = new LinkedList<>();

        for(int i=0 ; i<request.getLength() ; i++){
            indexes.add(i);
            sb.append(" ");
        }

        Collections.shuffle(indexes);

        while (!indexes.isEmpty())
        {
            if(request.getIncludeLowerCase()) sb.setCharAt(indexes.removeFirst(), MetaData.getRandomLowerCase());
            if(indexes.isEmpty()) break;
            if(request.getIncludeUpperCase()) sb.setCharAt(indexes.removeFirst(), MetaData.getRandomUpperCase());
            if(indexes.isEmpty()) break;
            if(request.getIncludeNumbers()) sb.setCharAt(indexes.removeFirst(), MetaData.getRandomNumber());
            if(indexes.isEmpty()) break;
            if(request.getIncludeSpecialChars()) sb.setCharAt(indexes.removeFirst(), MetaData.getRandomSpecialChar());
            if(indexes.isEmpty()) break;
        }

        return sb.toString();

    }

    public void savePassword(final SavePassword saveRequest, final Long ucid)
    {

        boolean exists = this.passwordRepo.existsByUcidAndName(ucid, saveRequest.name());
        if(exists) throw new PasswordNameAlreadyExists();

        boolean hasSpecialChars = false;
        for(char c : saveRequest.password().toCharArray()){
            if(MetaData.specialChars.contains(c)){
                hasSpecialChars = true;
                break;
            }
        }

        boolean hasLowerCase = false;
        for(char c : saveRequest.password().toCharArray()){
            if(MetaData.lowerCaseLetters.contains(c)){
                hasLowerCase = true;
                break;
            }
        }

        boolean hasUppercase = false;
        for(char c : saveRequest.password().toCharArray()){
            if(MetaData.upperCaseLetters.contains(c)){
                hasUppercase = true;
                break;
            }
        }

        boolean hasNumbers = false;
        for(char c : saveRequest.password().toCharArray()){
            if(MetaData.numbers.contains(c)){
                hasNumbers = true;
                break;
            }
        }

        PasswordEntity password = PasswordEntity.builder()
                .name(saveRequest.name())
                .password(saveRequest.password())
                .hasLowerCase(hasLowerCase)
                .hasUpperCase(hasUppercase)
                .hasNumbers(hasNumbers)
                .hasSpecialChars(hasSpecialChars)
                .length(saveRequest.password().length())
                .ucid(ucid)
                .build();

        this.passwordRepo.save(password);
    }

    public PagedDto<PasswordDto> getPagedPasswords(final Integer page,
                                                   final Integer count,
                                                   final Long ucid) {
        PageRequest pageRequest = PageRequest.of(page - 1, count);
        Page<PasswordEntity> passwordEntities = this.passwordRepo.findAllByUcid(ucid, pageRequest);
        List<PasswordDto> passwordDtos = passwordEntities.stream().map(modelMapper::toDto).toList();
        return new PagedDto<>(
                passwordDtos,
                passwordEntities.hasNext(),
                passwordEntities.hasPrevious(),
                passwordEntities.getTotalPages()
        );
    }


}
