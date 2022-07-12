package kosterror.shift.repository;

import kosterror.shift.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    ArrayList<PostEntity> findAllByAuthorId(Long id);
}
