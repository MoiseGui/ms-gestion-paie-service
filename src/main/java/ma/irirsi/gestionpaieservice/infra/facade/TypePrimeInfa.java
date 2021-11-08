package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;

import java.util.List;

public interface TypePrimeInfa {
    public TypePrimeEntity save(TypePrimeEntity typePrime);
    public TypePrimeEntity update(TypePrimeEntity typePrime);
    public List<TypePrimeEntity> findAll();
    public TypePrimeEntity findById(Long id);
    public TypePrimeEntity findByLibelle(String libelle);
}
