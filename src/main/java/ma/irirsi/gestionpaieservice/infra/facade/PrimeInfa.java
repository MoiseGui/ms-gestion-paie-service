package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;

import java.util.List;

public interface PrimeInfa {
    public PrimeEntity save(PrimeEntity prime);
    public PrimeEntity update(PrimeEntity prime);
    public List<PrimeEntity> findAll();
    public PrimeEntity findById(Long id);
    public PrimeEntity findByRef(String ref);
}
