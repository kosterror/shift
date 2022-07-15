package kosterror.shift.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String login;

    private String password;

    public void removeSpaces() {
        String regex = "\\s";
        String replacement = "";

        login = login.replaceAll(regex, replacement);
        password = password.replaceAll(regex, replacement);
    }
}
