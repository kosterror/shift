package kosterror.shift.util;

import kosterror.shift.model.dto.NewUserDTO;
import kosterror.shift.model.dto.UserDTO;
import kosterror.shift.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.UUID;

public class UserConvert {
    public static UserEntity NewDTOToEntity(NewUserDTO newUserDTO) {
        return new UserEntity(
                UUID.randomUUID().toString(),
                newUserDTO.getFirstName(),
                newUserDTO.getLastName(),
                newUserDTO.getAge(),
                newUserDTO.getLogin(),
                newUserDTO.getPassword()
        );
    }

    public static UserDTO EntityToDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAge()
        );
    }

    public static ArrayList<UserDTO> ListEntityToListDTO(ArrayList<UserEntity> userEntities) {
        ArrayList<UserDTO> usersDTO = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            usersDTO.add(UserConvert.EntityToDTO(userEntity));
        }

        return usersDTO;
    }
}
