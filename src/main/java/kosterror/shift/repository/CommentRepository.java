package kosterror.shift.repository;

import kosterror.shift.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
    ArrayList<CommentEntity> getAllByPostId(String id);

    void removeById(String id);

    void removeAllByPostId(String postId);
}
