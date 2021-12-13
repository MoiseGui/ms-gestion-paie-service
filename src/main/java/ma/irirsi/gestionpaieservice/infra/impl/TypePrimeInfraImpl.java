package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.TypePrime;
import ma.irirsi.gestionpaieservice.infra.converter.TypePrimeConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.TypePrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.TypePrimeInfa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypePrimeInfraImpl extends AbstractInfraImpl implements TypePrimeInfa {
    @Autowired
    private TypePrimeDao dao;

    @Autowired
    TypePrimeConverter converter;

    @Override
    public TypePrimeEntity save(TypePrimeEntity typePrime) {
        return this.dao.save(typePrime);
    }

    @Override
    public TypePrime save(TypePrime typePrime) {
        TypePrimeEntity typePrimeEntity = new TypePrimeEntity();
        BeanUtils.copyProperties(typePrime, typePrimeEntity);
        typePrimeEntity = save(typePrimeEntity);
        BeanUtils.copyProperties(typePrimeEntity, typePrime);
        return typePrime;
    }

    @Override
    public TypePrimeEntity update(TypePrimeEntity typePrime) {
        if (typePrime == null || findById(typePrime.getId()) == null) {
            return null;
        }
        return this.dao.save(typePrime);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) == null) {
            return 0;
        }
        this.dao.deleteById(id);
        return 1;
    }

    @Override
    public TypePrime update(TypePrime typePrime) {
        return save(typePrime);
    }

    @Override
    public List<TypePrimeEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public List<TypePrime> findAllTypePrimes() {
        return converter.to(findAll());
    }

    @Override
    public TypePrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public TypePrime findTypePrimeById(Long id){
        TypePrimeEntity typePrimeEntity = findById(id);
        TypePrime typePrime = new TypePrime();
        BeanUtils.copyProperties(typePrimeEntity, typePrime);
        return typePrime;
    }

    @Override
    public TypePrimeEntity findByLibelle(String libelle) {
        return this.dao.findByLibelle(libelle);
    }

    @Override
    public TypePrime findTypePrimeByLibelle(String libelle){
        TypePrimeEntity typePrimeEntity = findByLibelle(libelle);
        TypePrime typePrime = new TypePrime();
        BeanUtils.copyProperties(typePrimeEntity, typePrime);
        return typePrime;
    }

    public void setDao(TypePrimeDao dao) {
        this.dao = dao;
    }
}
