package ma.irirsi.gestionpaieservice.domain.service.core.facade;

import ma.irirsi.gestionpaieservice.infrastructure.entity.PrimeEntity;

import java.util.List;

public interface PrimeService {
    public PrimeEntity save(PrimeEntity prime);
    public PrimeEntity update(PrimeEntity prime);
    public List<PrimeEntity> findAll();
    public PrimeEntity findById(Long id);
    public PrimeEntity findByRef(String ref);
}
