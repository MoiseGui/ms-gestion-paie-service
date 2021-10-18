package ma.irirsi.gestionpaieservice.domain.service.core.facade;

import ma.irirsi.gestionpaieservice.infrastructure.entity.TypePrimeEntity;

import java.util.List;

public interface TypePrimeService {
    public TypePrimeEntity save(TypePrimeEntity typePrime);
    public TypePrimeEntity update(TypePrimeEntity typePrime);
    public List<TypePrimeEntity> findAll();
    public TypePrimeEntity findById(Long id);
    public TypePrimeEntity findByLibelle(String libelle);
}
