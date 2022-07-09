package kosterror.shift.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "id")
    private String uuid;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Temporal(TemporalType.DATE)
    @Column
    private Date birthdayDate;

    @Column
    private int age;

    @Temporal(TemporalType.DATE)
    @Column
    private Date registrationDate;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;

}
