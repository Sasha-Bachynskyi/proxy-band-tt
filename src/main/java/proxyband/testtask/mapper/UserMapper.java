package proxyband.testtask.mapper;

import org.springframework.stereotype.Component;
import proxyband.testtask.dto.UserRequestDto;
import proxyband.testtask.dto.UserResponseDto;
import proxyband.testtask.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
