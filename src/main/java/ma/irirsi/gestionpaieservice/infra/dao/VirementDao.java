package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.VirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementDao extends JpaRepository<VirementEntity, Long> {
}
