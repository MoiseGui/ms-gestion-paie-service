package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.EchelleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchelleDao extends JpaRepository<EchelleEntity, Long> {
}
