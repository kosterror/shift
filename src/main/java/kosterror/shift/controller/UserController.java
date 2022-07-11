package kosterror.shift.controller;

import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserDTO create(@RequestBody NewUserDTO newUserDTO) {
        return userService.create(newUserDTO);
    }

    @GetMapping("/get/{id}")
    public UserDTO getUserById(@PathVariable UUID id) {
        return userService.getUserById(id.toString());
    }

    @GetMapping("/getAll")
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

}
