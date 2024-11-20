package ru.pepsxx.pep_blog_reg.mapper;

import org.springframework.stereotype.Component;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserRoleDto;
import ru.pepsxx.pep_blog_reg.entity.User;
import ru.pepsxx.pep_blog_reg.entity.UserRole;

import java.sql.Timestamp;

@Component
public class UserMapper {

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPass(userDto.pass());
        user.setDataTimeRegistering(new Timestamp(System.currentTimeMillis()));

        UserRole userRole = userDto.userRole().name().isEmpty()
                ? UserRole.ROLE_USER
                : UserRole.valueOf(userDto.userRole().name());

        user.setUserRole(userRole);
        return user;
    }

    public UserDto userUserToUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                null,
                new UserRoleDto(user.getUserRole().name())
        );
    }
}
