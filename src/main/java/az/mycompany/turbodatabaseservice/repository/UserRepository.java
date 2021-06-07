package az.mycompany.turbodatabaseservice.repository;

import az.mycompany.turbodatabaseservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    boolean existsByEmail(String email);

    boolean existsByUserName(String username);

    boolean existsByPin(String finCode);

    UserEntity findByUserName(String username);

    boolean existsByPhone(String phone);


}
