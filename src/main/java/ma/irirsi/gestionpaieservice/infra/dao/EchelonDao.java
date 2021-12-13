package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchelonDao extends JpaRepository<EchelonEntity, Long> {
    public EchelonEntity findByRef(String ref);
    public EchelonEntity findByNiveau(Integer niveau);
    public EchelonEntity findByNiveauAndEchelleId(Integer niveau, Long echelleId);
}
