package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.PrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface PrimeDao extends JpaRepository<PrimeEntity, Long> {
    public PrimeEntity findByRef(String ref);
}
