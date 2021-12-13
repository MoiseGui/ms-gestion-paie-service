package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;

import java.util.List;

public interface PrimeInfra extends AbstractInfra {
    public PrimeEntity save(PrimeEntity prime);
    public Prime save(Prime prime);

    PrimeEntity update(PrimeEntity prime);

    int deleteById(Long id);

    int deleteByRef(String ref);

    public List<PrimeEntity> findAll();

    List<Prime> findAllPrimes();

    public PrimeEntity findById(Long id);

    Prime findPrimeById(Long id);

    public PrimeEntity findByRef(String ref);

    Prime findPrimeByRef(String ref);
}
