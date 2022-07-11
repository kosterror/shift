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
                userEntity.getUuid(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAge()
        );
    }

    public static ArrayList<UserDTO> ListEntityToListDTO(ArrayList<UserEntity> userEntities) {
        ArrayList<UserDTO> usersDTO = new ArrayList<UserDTO>();

        for (int i = 0; i < userEntities.size(); i++) {
            usersDTO.add(UserConvert.EntityToDTO(userEntities.get(i)));
        }

        return usersDTO;
    }
}
