package kosterror.shift.controller;

import io.swagger.v3.oas.annotations.Operation;
import kosterror.shift.exeption.UserAlreadyExistsException;
import kosterror.shift.exeption.UserNotFoundException;
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
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/userId={userId}")
    @Operation(description = "Получить пользователя по id")
    public ResponseEntity getUserById(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/login={login}")
    @Operation(description = "Получить пользователя по логину. Если пользователь с заданным логином не найден, то придет исключение")
    public ResponseEntity getUserByLogin(@PathVariable String login) {
        try {
            return ResponseEntity.ok(userService.getUserByLogin(login));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    @Operation(description = "Получение всех зарегистрированных пользователей")
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

}
