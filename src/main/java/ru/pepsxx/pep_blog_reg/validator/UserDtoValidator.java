package ru.pepsxx.pep_blog_reg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pepsxx.pep_blog_reg.dto.userDto;

@Component
public class UserDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return userDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        userDto userDto = (userDto) target;
        if (userDto.pass().length()<6) {
            errors.rejectValue("pass", "", "Пароль должен быть больше 6 символов");
        }
    }
}
