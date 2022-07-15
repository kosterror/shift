package kosterror.shift.repository;

import kosterror.shift.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByLogin(String login);

    boolean existsByLogin(String login);

}
