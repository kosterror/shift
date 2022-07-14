package kosterror.shift.service;


import kosterror.shift.exeption.UserAlreadyExistsException;
import kosterror.shift.exeption.UserNotFoundException;
import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.model.entity.UserEntity;
import kosterror.shift.repository.UserRepository;
import kosterror.shift.util.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //TODO: как идея: кидать ошибки здесь, обрабатывать в контроллере, на post запросы отвечать response entity

    public UserDTO create(NewUserDTO newUserDTO) throws UserAlreadyExistsException {
        //TODO: проверка на уникальность логина есть, но нет проверки на корректность пароля
        if (!userRepository.existsByLogin(newUserDTO.getLogin())) {
            UserEntity savedUserEntity = userRepository.save(UserConvert.NewDTOToEntity(newUserDTO));

            return UserConvert.EntityToDTO(savedUserEntity);
        } else {
            throw new UserAlreadyExistsException("User with this login already exists. Please choose another login");
        }
    }

    public UserDTO getUserById(String userId) {
        //найдем в БД сущность по id
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        return userEntity.map(UserConvert::EntityToDTO).orElse(null);
    }

    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();

        return UserConvert.ListEntityToListDTO(userEntities);
    }

    public UserDTO getUserByLogin(String login) throws UserNotFoundException {
        //TODO: реализовать
        if (userRepository.existsByLogin(login)) {
            return UserConvert.EntityToDTO(userRepository.findUserEntityByLogin(login));
        } else {
            throw new UserNotFoundException("User with this login does not exists");
        }
    }

}
