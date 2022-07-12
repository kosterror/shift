package kosterror.shift.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_like")
public class PostLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long authorId;

    @Column
    private Long postId;

    @Column
    private Date likeDate;

    public PostLikeEntity() {
    }

    public PostLikeEntity(Long authorId, Long postId, Date likeDate) {
        this.authorId = authorId;
        this.postId = postId;
        this.likeDate = likeDate;
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

    public Date getLikeDate() {
        return likeDate;
    }
}
