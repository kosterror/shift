package kosterror.shift.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column
    private int age;

    @Column
    private String login;

    @Column
    private String password;

}
