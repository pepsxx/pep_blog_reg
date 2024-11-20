package ru.pepsxx.pep_blog_reg.validator;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.entity.UserRole;

import java.util.Arrays;

@Component
public class UserDtoValidator implements Validator {

    @Override
    public boolean supports(@Nullable Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(@Nonnull Object target, @Nonnull Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.pass().length() < 6) {
            errors.rejectValue("pass", "", "Пароль должен быть больше 6 символов");
        } else if (!userDto.pass().equals(userDto.passwordRepeat())) {
            errors.rejectValue("pass", "", "Пароли не совпадают");
        }

        String userName = userDto.userRole().name().isEmpty()
                ? UserRole.ROLE_USER.name()
                : userDto.userRole().name();
        Arrays.stream(UserRole.values())
                .filter(r -> userName.equals(r.name()))
                .findFirst()
                .orElseGet(() -> {
                    errors.rejectValue("userRole", "", "Не существующая роль");
                    return null;
                });
    }
}
