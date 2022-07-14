package kosterror.shift.controller;

import io.swagger.v3.oas.annotations.Operation;
import kosterror.shift.exeption.UserAlreadyExists;
import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @Operation(description = "Создать нового пользователя с уникальным id")
    public ResponseEntity create(@RequestBody NewUserDTO newUserDTO) {
        try {
            return ResponseEntity.ok(userService.create(newUserDTO));
        } catch (UserAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/userId={userId}")
    @Operation(description = "Получить пользователя по id")
    public UserDTO getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/get/login={login}")
    public UserDTO getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/getAll")
    @Operation(description = "Получение всех зарегистрированных пользователей")
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

}
