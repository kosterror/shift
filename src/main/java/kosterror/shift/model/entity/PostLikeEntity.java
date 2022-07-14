package kosterror.shift.model.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "post_like")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PostLikeEntity that = (PostLikeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    //был warning, после добавления этого исчез
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
