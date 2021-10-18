package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.VirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementDao extends JpaRepository<VirementEntity, Long> {
}
