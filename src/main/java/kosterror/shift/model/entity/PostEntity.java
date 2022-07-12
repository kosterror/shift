package kosterror.shift.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Long authorId;

    @Column
    private String title;

    @Column
    private String text;

    public PostEntity() {
    }

    public PostEntity(Long authorId, String title, String text) {
        this.authorId = authorId;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
