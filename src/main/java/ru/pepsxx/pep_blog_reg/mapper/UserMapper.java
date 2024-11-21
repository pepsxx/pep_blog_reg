package ru.pepsxx.pep_blog_reg.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserRoleDto;
import ru.pepsxx.pep_blog_reg.entity.Role;
import ru.pepsxx.pep_blog_reg.entity.User;
import ru.pepsxx.pep_blog_reg.entity.UserRole;
import ru.pepsxx.pep_blog_reg.util.HashCodeUtil;

import java.sql.Timestamp;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPass(HashCodeUtil.getSHA256Hash(userDto.pass()));
        user.setDataTimeRegistering(new Timestamp(System.currentTimeMillis()));
        Set<UserRole> roles = userDto.roles()==null || userDto.roles().isEmpty()
                ? Set.of(new UserRole(Role.ROLE_USER))
                : userDto.roles()
                .stream()
                .map(UserMapper::userRoleDtoToRole)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return user;
    }

    public UserDto userUserToUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                null,
                null,
                user.getDataTimeRegistering(),
                user.getRoles()
                        .stream()
                        .map(UserMapper::userRoleToUserRoleDto)
                        .collect(Collectors.toSet())
        );
    }

    public static UserRole userRoleDtoToRole(UserRoleDto userRoleDto) {
        return new UserRole(Role.valueOf(userRoleDto.name()));
    }

    public static UserRoleDto userRoleToUserRoleDto(UserRole userRole) {
        return new UserRoleDto(userRole.getName().name());
    }
}
