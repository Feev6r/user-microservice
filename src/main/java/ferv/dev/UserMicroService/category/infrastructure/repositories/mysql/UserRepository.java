package ferv.dev.UserMicroService.category.infrastructure.repositories.mysql;

import ferv.dev.UserMicroService.category.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

}
