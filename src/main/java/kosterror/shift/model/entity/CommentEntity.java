package kosterror.shift.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long authorId;

    @Column
    private Long postId;

    @Column
    private Date date;

    @Column
    String text;

    public CommentEntity() {
    }

    public CommentEntity(Long authorId, Long postId, Date date, String text) {
        this.authorId = authorId;
        this.postId = postId;
        this.date = date;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getPostId() {
        return postId;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
