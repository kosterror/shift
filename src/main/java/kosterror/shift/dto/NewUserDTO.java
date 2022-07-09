package kosterror.shift.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}
