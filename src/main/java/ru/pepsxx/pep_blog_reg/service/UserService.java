package ru.pepsxx.pep_blog_reg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.entity.User;
import ru.pepsxx.pep_blog_reg.mapper.UserMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserDto getUser(UserDto userDto) {
        log.info(userDto.toString());
        User user = userMapper.userDtoToUser(userDto);
        log.info(user.toString());
        userDto = userMapper.userUserToUserDto(user);
        log.info(userDto.toString());
        return userDto;
    }
}
