package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.UserPrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPrimeDao extends JpaRepository<UserPrimeEntity, Long> {
    List<UserPrimeEntity> findByUserMatricule(String userMatricule);
}
