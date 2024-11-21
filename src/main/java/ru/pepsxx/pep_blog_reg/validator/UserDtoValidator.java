package ru.pepsxx.pep_blog_reg.validator;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserRoleDto;
import ru.pepsxx.pep_blog_reg.entity.Role;

import java.util.Arrays;
import java.util.Objects;

@Component
public class UserDtoValidator implements Validator {

    @Override
    public boolean supports(@Nullable Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(@Nonnull Object target, @Nonnull Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.pass()== null || userDto.pass().length() < 6) {
            errors.rejectValue("pass", "", "Пароль должен быть больше 6 символов");
        } else if (!userDto.pass().equals(userDto.passwordRepeat())) {
            errors.rejectValue("pass", "", "Пароли не совпадают");
        }

        if (userDto.roles() != null) {
            userDto.roles()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(UserRoleDto::name)
                    .filter(name -> Arrays.stream(Role.values())
                            .map(Enum::name)
                            .noneMatch(s -> s.equals(name)))
                    .reduce((a, b) -> a + ", " + b)
                    .ifPresent(s -> errors.rejectValue("roles", "", "Не существующая роль(и): %s".formatted(s)));
        }
    }
}
