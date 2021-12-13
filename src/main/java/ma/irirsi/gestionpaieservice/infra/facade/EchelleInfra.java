package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;
import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;

import java.util.List;

public interface EchelleInfra extends AbstractInfra {
    public List<EchelleEntity> findAll();
    public EchelleEntity findById(Long id);
    public EchelleEntity findByRef(String ref);
    public EchelleEntity findByNiveau(Integer niveau);
    public EchelleEntity save(EchelleEntity echelleEntity);
    public EchelleEntity update(EchelleEntity echelle);
    public int deleteByRef(String ref);
}
