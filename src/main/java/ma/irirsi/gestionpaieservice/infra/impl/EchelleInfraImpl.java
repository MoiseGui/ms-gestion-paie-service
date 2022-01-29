package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.Echelle;
import ma.irirsi.gestionpaieservice.infra.converter.EchelleConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.EchelleDao;
import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;
import ma.irirsi.gestionpaieservice.infra.facade.EchelleInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EchelleInfraImpl extends AbstractInfraImpl implements EchelleInfra {

    @Autowired
    EchelleDao dao;

    @Override
    public List<EchelleEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public EchelleEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public EchelleEntity findByRef(String ref) {
        if (ref == null) {
            return null;
        }
        return this.dao.findByRef(ref);
    }

    @Override
    public EchelleEntity save(EchelleEntity echelle) {
        if (echelle != null && findByRef(echelle.getRef()) == null) {
            return this.dao.save(echelle);
        }
        return null;
    }

    @Override
    public Echelle save(Echelle echelle) {
        return EchelleConverter.to(save(EchelleConverter.toItem(echelle)));
    }

    @Override
    public EchelleEntity update(EchelleEntity echelle) {
        if (echelle != null && findById(echelle.getId()) != null) {
            return this.dao.save(echelle);
        }
        return null;
    }

    @Override
    public int deleteByRef(String ref) {
        EchelleEntity echelle = findByRef(ref);
        if (echelle != null) {
            this.dao.delete(echelle);
            return 1;
        }
        return 0;
    }

    @Override
    public EchelleEntity findByNiveau(Integer niveau) {
        if (niveau == null) {
            return null;
        }
        return this.dao.findByNiveau(niveau);
    }

    @Override
    public Echelle findByEchelleNiveau(Integer niveau) {
        EchelleConverter.convertEchelon = true;
        return EchelleConverter.to(findByNiveau(niveau));
    }
}
