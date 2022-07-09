package kosterror.shift.dto;

import kosterror.shift.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    private String firstName;

    private String secondName;

    private Date birthdayDate;

    private int age;

    private Date registrationDate;

    private String login;

    private String password;

    private String email;

    public UserEntity convertToUserEntity() {
        return new UserEntity(
                UUID.randomUUID().toString(),
                firstName,
                secondName,
                birthdayDate,
                age,
                registrationDate,
                login,
                password,
                email
        );
    }
}
