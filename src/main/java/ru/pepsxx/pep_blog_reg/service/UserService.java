package ru.pepsxx.pep_blog_reg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.entity.User;
import ru.pepsxx.pep_blog_reg.exception.UserAlreadyExists;
import ru.pepsxx.pep_blog_reg.mapper.UserMapper;
import ru.pepsxx.pep_blog_reg.repository.UserRepository;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto registerUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);

        userRepository.findFirstByEmail(user.getEmail())
                .ifPresent(u -> {
//                    throw new UserAlreadyExists("Пользователь c email: %s уже существует".formatted(u.getEmail()));
                            throw new UserAlreadyExists(new UserDtoException(
                                    "User Already Exists",
                                    Map.of(
                                            "User Already Exists",
                                            "Пользователь c email: %s уже существует".formatted(u.getEmail())
                                    )
                            )
                            );
                        }
                );

        return userMapper.userUserToUserDto(userRepository.save(user));
    }
}
