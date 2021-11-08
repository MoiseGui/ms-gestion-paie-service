package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface PrimeDao extends JpaRepository<PrimeEntity, Long> {
    public PrimeEntity findByRef(String ref);
}
