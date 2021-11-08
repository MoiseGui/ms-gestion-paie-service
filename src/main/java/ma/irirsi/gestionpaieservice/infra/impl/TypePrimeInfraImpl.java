package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.infra.dao.TypePrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.TypePrimeInfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypePrimeInfraImpl implements TypePrimeInfa {
    @Autowired
    private TypePrimeDao dao;

    @Override
    public TypePrimeEntity save(TypePrimeEntity typePrime) {
        return this.dao.save(typePrime);
    }

    @Override
    public TypePrimeEntity update(TypePrimeEntity typePrime) {
        return this.dao.save(typePrime);
    }

    @Override
    public List<TypePrimeEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public TypePrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public TypePrimeEntity findByLibelle(String libelle) {
        return this.dao.findByLibelle(libelle);
    }

    public void setDao(TypePrimeDao dao) {
        this.dao = dao;
    }
}
