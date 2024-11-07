package ru.pepsxx.pep_blog_reg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pepsxx.pep_blog_reg.dto.UserDto;

@Component
public class UserDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.pass().length()<6) {
            errors.rejectValue("pass", "", "Пароль должен быть больше 6 символов");
        }
    }
}
