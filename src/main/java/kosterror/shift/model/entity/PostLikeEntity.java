package kosterror.shift.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "post_like")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostLikeEntity {
    @Id
    private String id;

    @Column
    private String authorId;

    @Column
    private String postId;

    @Column
    private Date date;
}
