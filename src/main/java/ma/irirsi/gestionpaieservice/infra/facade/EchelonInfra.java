package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;
import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;

import java.util.List;

public interface EchelonInfra extends AbstractInfra {
    public List<EchelonEntity> findAll();
    public List<Echelon> findAllEchelon();
    public EchelonEntity findById(Long id);
    public EchelonEntity findByRef(String ref);
    public EchelonEntity findByNiveau(Integer niveau);
    public EchelonEntity findByNiveauAndEchelleId(Integer niveau, Long echelleId);
    public EchelonEntity save(EchelonEntity echelon);
    public Echelon save(Echelon echelon);
    public EchelonEntity update(EchelonEntity echelon);
    public int deleteByRef(String ref);
}
