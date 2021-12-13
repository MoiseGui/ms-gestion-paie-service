package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.infra.converter.EchelleConverter;
import ma.irirsi.gestionpaieservice.infra.converter.EchelonConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.EchelonDao;
import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EchelonInfaImpl extends AbstractInfraImpl implements EchelonInfra {

    @Autowired
    EchelonDao dao;

    @Override
    public List<EchelonEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public List<Echelon> findAllEchelon() {
        EchelonConverter.convertEchelle = true;
        EchelleConverter.convertEchelon = false;
        return this.dao.findAll().stream().map(EchelonConverter::to).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public EchelonEntity findById(Long id) {
        if (id == null) {
            return null;
        }
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public EchelonEntity findByRef(String ref) {
        if (ref == null) {
            return null;
        }
        return this.dao.findByRef(ref);
    }

    @Override
    public EchelonEntity findByNiveau(Integer niveau) {
        if (niveau == null) {
            return null;
        }
        return this.dao.findByNiveau(niveau);
    }

    @Override
    public EchelonEntity findByNiveauAndEchelleId(Integer niveau, Long echelleId) {
        if (niveau == null || echelleId == null) {
            return null;
        }
        return this.dao.findByNiveauAndEchelleId(niveau, echelleId);
    }

    @Override
    public EchelonEntity save(EchelonEntity echelon) {
        if (echelon == null || findByRef(echelon.getRef()) != null) {
            return null;
        }
        return this.dao.save(echelon);
    }

    @Override
    public Echelon save(Echelon echelon) {
        EchelonConverter.convertEchelle = true;
        EchelleConverter.convertEchelon = false;

        if(echelon == null) return null;
        EchelonEntity echelonEntity = EchelonConverter.toEntity(echelon);
        if(echelonEntity == null) return null;
        EchelonEntity savedEchelonEntity = this.save(echelonEntity);
        return EchelonConverter.to(savedEchelonEntity);
    }

    @Override
    public EchelonEntity update(EchelonEntity echelon) {
        if (echelon != null && findByRef(echelon.getRef()) != null) {
            return this.dao.save(echelon);
        }
        return null;
    }

    @Override
    public int deleteByRef(String ref) {
        if (ref == null) return 0;
        EchelonEntity existingEchelon = findByRef(ref);

        if (existingEchelon != null) return 0;

        this.dao.deleteById(existingEchelon.getId());
        return 1;
    }
}
