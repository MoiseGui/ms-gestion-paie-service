package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.EchelonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchelonDao extends JpaRepository<EchelonEntity, Long> {
}
