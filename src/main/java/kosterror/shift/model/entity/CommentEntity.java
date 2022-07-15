package kosterror.shift.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    private String id;

    @Column
    private String authorId;

    @Column
    private String postId;

    @Column
    private Date date;

    @Column
    String text;

    public CommentEntity() {
    }

    public CommentEntity(String id, String authorId, String postId, Date date, String text) {
        this.id = id;
        this.authorId = authorId;
        this.postId = postId;
        this.date = date;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getPostId() {
        return postId;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
