package proxyband.testtask.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proxyband.testtask.dto.UserRequestDto;
import proxyband.testtask.dto.UserResponseDto;
import proxyband.testtask.mapper.RequestDtoMapper;
import proxyband.testtask.mapper.ResponseDtoMapper;
import proxyband.testtask.model.User;
import proxyband.testtask.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;
    private final RequestDtoMapper<UserRequestDto, User> requestDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> responseDtoMapper,
                          RequestDtoMapper<UserRequestDto, User> requestDtoMapper) {
        this.userService = userService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponseDto add(@RequestBody UserRequestDto userRequestDto) {
        return responseDtoMapper.mapToDto(userService.add(
                requestDtoMapper.mapToModel(userRequestDto)));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        int usersCountBeforeDeleting = userService.getAll().size();
        userService.delete(id);
        int usersCountAfterDeleting = userService.getAll().size();
        return usersCountBeforeDeleting != usersCountAfterDeleting ?
                "This user was deleted" : "There is no user in DB by such id " + id;
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable String id,
                                  @RequestBody UserRequestDto userRequestDto) {
        User user = requestDtoMapper.mapToModel(userRequestDto);
        user.setId(id);
        return responseDtoMapper.mapToDto(userService.update(user));
    }
}
