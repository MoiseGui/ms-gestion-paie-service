package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.UserEchelonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEchelonDao extends JpaRepository<UserEchelonEntity, Long> {
    List<UserEchelonEntity> findByUserMatricule(String userMatricule);

    UserEchelonEntity findByUserMatriculeAndIsActive(String userMatricule, boolean isActive);

    UserEchelonEntity findByUserMatriculeAndEchelonRef(String userMatricule, String ref);
}
