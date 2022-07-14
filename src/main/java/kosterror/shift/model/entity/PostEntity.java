package kosterror.shift.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
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

    public PostEntity() {
    }

    public PostEntity(String id, String authorId, String title, String text) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
