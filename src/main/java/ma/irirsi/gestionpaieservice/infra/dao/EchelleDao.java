package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchelleDao extends JpaRepository<EchelleEntity, Long> {
    public EchelleEntity findByRef(String ref);
    public EchelleEntity findByNiveau(Integer niveau);
}
