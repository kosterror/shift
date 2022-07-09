package kosterror.shift.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    private String firstName;

    private String secondName;

    private int age;

    private String login;

    private String password;
}
