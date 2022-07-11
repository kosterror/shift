package kosterror.shift.repository;

import kosterror.shift.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PostRepository extends JpaRepository<PostEntity, String> {
    ArrayList<PostEntity> findAllByAuthorId(String id);
}
