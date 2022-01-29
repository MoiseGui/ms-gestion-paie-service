package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPrimeDao extends JpaRepository<UserPrimeEntity, Long> {
    List<UserPrimeEntity> findByUserMatricule(String userMatricule);
    List<UserPrimeEntity> findByUserMatriculeAndIsActive(String userMatricule, boolean isActive);
}
