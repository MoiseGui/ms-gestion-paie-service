package ma.irirsi.gestionpaieservice.domain.service.core.impl;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.TypePrimeService;
import ma.irirsi.gestionpaieservice.infrastructure.dao.TypePrimeDao;
import ma.irirsi.gestionpaieservice.infrastructure.entity.TypePrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePrimeServiceImpl implements TypePrimeService {
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
