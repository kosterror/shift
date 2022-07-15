package kosterror.shift.service;


import kosterror.shift.exeption.UserAlreadyExistsException;
import kosterror.shift.exeption.UserNotFoundException;
import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.model.entity.UserEntity;
import kosterror.shift.repository.UserRepository;
import kosterror.shift.util.UserConvert;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(NewUserDTO newUserDTO) throws UserAlreadyExistsException {
        newUserDTO.removeSpaces();

        if (!userRepository.existsByLogin(newUserDTO.getLogin())) {
            UserEntity savedUserEntity = userRepository.save(UserConvert.NewDTOToEntity(newUserDTO));

            return UserConvert.EntityToDTO(savedUserEntity);
        }

        throw new UserAlreadyExistsException("User with this login already exists. Please choose another login");

    }

    public UserDTO getUserById(String userId) throws UserNotFoundException {

        if (userRepository.existsById(userId)) {
            Optional<UserEntity> userEntity = userRepository.findById(userId);

            return userEntity.map(UserConvert::EntityToDTO).orElse(null);
        }

        throw new UserNotFoundException("User with this ID does not exists");


    }

    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();

        return UserConvert.ListEntityToListDTO(userEntities);
    }

    public UserDTO getUserByLogin(String login) throws UserNotFoundException {
        if (userRepository.existsByLogin(login)) {
            return UserConvert.EntityToDTO(userRepository.findUserEntityByLogin(login));
        }

        throw new UserNotFoundException("User with this login does not exists");
    }

}
