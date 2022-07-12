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

        //создадим сущность для сохранение в БД
        UserEntity userEntity = UserConvert.NewDTOToEntity(newUserDTO);


        //сохраняем в БД
        UserEntity savedUserEntity = userRepository.save(userEntity);

        //возвращаем DTO (сущность без пароля)
        return UserConvert.EntityToDTO(savedUserEntity);
    }

    public UserDTO getUserById(Long userId) {
        //найдем в БД сущность по id
//        UserEntity userEntity = userRepository.findById(userId);
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()) {
            return UserConvert.EntityToDTO(userEntity.get());
        } else {
            return null;
        }
    }

    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();

        return UserConvert.ListEntityToListDTO(userEntities);
    }

}
