package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.domain.pojo.TypePrime;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;

import java.util.List;

public interface TypePrimeInfa extends AbstractInfra {
    public TypePrimeEntity save(TypePrimeEntity typePrime);

    TypePrime save(TypePrime typePrime);

    public TypePrimeEntity update(TypePrimeEntity typePrime);

    int deleteById(Long id);

    TypePrime update(TypePrime typePrime);

    public List<TypePrimeEntity> findAll();

    List<TypePrime> findAllTypePrimes();

    public TypePrimeEntity findById(Long id);

    TypePrime findTypePrimeById(Long id);

    public TypePrimeEntity findByLibelle(String libelle);

    TypePrime findTypePrimeByLibelle(String libelle);
}
