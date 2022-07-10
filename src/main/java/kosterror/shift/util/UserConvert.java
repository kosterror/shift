package kosterror.shift.util;

import kosterror.shift.dto.NewUserDTO;
import kosterror.shift.dto.UserDTO;
import kosterror.shift.entity.UserEntity;

import java.util.UUID;

public class UserConvert {
    public static UserEntity NewDTOToEntity(NewUserDTO newUserDTO) {
        return new UserEntity(
                UUID.randomUUID().toString(),
                newUserDTO.getFirstName(),
                newUserDTO.getSecondName(),
                newUserDTO.getAge(),
                newUserDTO.getLogin(),
                newUserDTO.getPassword()
        );
    }

    public static UserDTO EntityToDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getUuid(),
                userEntity.getFirstName(),
                userEntity.getSecondName(),
                userEntity.getAge()
        );
    }
}
