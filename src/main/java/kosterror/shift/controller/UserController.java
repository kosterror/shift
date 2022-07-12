package kosterror.shift.controller;

import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserDTO create(@RequestBody NewUserDTO newUserDTO) {
        return userService.create(newUserDTO);
    }

    @GetMapping("/get/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getAll")
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

}
