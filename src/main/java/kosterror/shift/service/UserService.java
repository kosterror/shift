package kosterror.shift.service;


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

    public UserDTO create(NewUserDTO newUserDTO) {
        //TODO: здесь должна быть прооверка на уникальность login'a, корректность пароля и т.п.


        //создадим сущность для сохранение в БД
        UserEntity userEntity = UserConvert.NewDTOToEntity(newUserDTO);


        //сохраняем в БД
        UserEntity savedUserEntity = userRepository.save(userEntity);

        //возвращаем DTO (сущность без пароля)
        return UserConvert.EntityToDTO(savedUserEntity);
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

    public UserDTO getUserByLogin(String login) {
        //TODO: реализовать

        return null;
    }

}
