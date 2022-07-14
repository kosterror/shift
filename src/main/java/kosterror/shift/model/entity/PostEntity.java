package kosterror.shift.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String authorId;

    @Column
    private String title;

    @Column
    private String text;

}
