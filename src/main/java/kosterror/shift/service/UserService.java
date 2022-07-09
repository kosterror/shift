package kosterror.shift.service;


import kosterror.shift.dto.NewUserDTO;
import kosterror.shift.dto.UserDTO;
import kosterror.shift.entity.UserEntity;
import kosterror.shift.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(NewUserDTO newUserDTO){

        //создадим сущность, которую сохраним в БД
        UserEntity userEntity = new UserEntity(
                UUID.randomUUID().toString(),
                newUserDTO.getFirstName(),
                newUserDTO.getSecondName(),
                newUserDTO.getBirthdayDate(),
                newUserDTO.getAge(),
                newUserDTO.getRegistrationDate(),
                newUserDTO.getLogin(),
                newUserDTO.getEmail(),
                newUserDTO.getPassword()
        );

        UserEntity savedUserEntity = userRepository.save(userEntity);   //сохранили сущность в БД

        //вернем информацию о этой сущности, без пароля (думаю, что так правильнее)
        return new UserDTO(
                savedUserEntity.getUuid(),
                savedUserEntity.getFirstName(),
                savedUserEntity.getSecondName(),
                savedUserEntity.getBirthdayDate(),
                savedUserEntity.getAge(),
                savedUserEntity.getRegistrationDate(),
                savedUserEntity.getLogin(),
                savedUserEntity.getEmail()
        );
    }

}
