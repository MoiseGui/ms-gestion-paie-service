package ma.irirsi.gestionpaieservice.infra.dao;

import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface TypePrimeDao extends JpaRepository<TypePrimeEntity, Long> {
    public TypePrimeEntity findByLibelle(String libelle);
}
