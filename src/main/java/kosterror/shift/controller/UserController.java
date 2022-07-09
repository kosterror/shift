package kosterror.shift.controller;

import kosterror.shift.dto.NewUserDTO;
import kosterror.shift.dto.UserDTO;
import kosterror.shift.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody NewUserDTO newUserDTO) {
        return userService.create(newUserDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable UUID id) {
        return userService.getUserById(id.toString());
    }

}
