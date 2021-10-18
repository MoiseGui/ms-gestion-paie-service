package ma.irirsi.gestionpaieservice.infrastructure.dao;

import ma.irirsi.gestionpaieservice.infrastructure.entity.TypePrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface TypePrimeDao extends JpaRepository<TypePrimeEntity, Long> {
    public TypePrimeEntity findByLibelle(String libelle);
}
