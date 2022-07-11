package kosterror.shift.service;


import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.model.entity.UserEntity;
import kosterror.shift.repository.UserRepository;
import kosterror.shift.util.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

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

    public UserDTO getUserById(String id) {
        //найдем в БД сущность по id, если такой нет, то кинем исключение
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        return UserConvert.EntityToDTO(userEntity);
    }

    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();

        return UserConvert.ListEntityToListDTO(userEntities);
    }

}
