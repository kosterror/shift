package kosterror.shift.repository;

import kosterror.shift.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, String> {
}
