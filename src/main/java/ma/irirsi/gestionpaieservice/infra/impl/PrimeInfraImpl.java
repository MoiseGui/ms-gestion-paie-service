package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.infra.converter.PrimeConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.PrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.PrimeInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrimeInfraImpl extends AbstractInfraImpl implements PrimeInfra {
    @Autowired
    private PrimeDao dao;

    @Autowired
    private PrimeConverter converter;

    @Override
    public PrimeEntity save(PrimeEntity prime) {
        if (prime != null && findByRef(prime.getRef()) == null) {
            return this.dao.save(prime);
        }
        return null;
    }

    @Override
    public Prime save(Prime prime){
        if (prime == null) {
            return null;
        }
        PrimeEntity primeEntity = this.converter.toItem(prime);
        primeEntity = save(primeEntity);
        return converter.to(primeEntity);
    }

    @Override
    public PrimeEntity update(PrimeEntity prime) {
        if (prime == null || findByRef(prime.getRef()) == null) {
            return null;
        }
        return this.dao.save(prime);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) == null) {
            return 0;
        }
        this.dao.deleteById(id);
        return 1;
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        PrimeEntity existingPrime = findByRef(ref);
        if (existingPrime == null) {
            return 0;
        }
        return deleteById(existingPrime.getId());
    }

    @Override
    public List<PrimeEntity> findAll(){return this.dao.findAll();}

    @Override
    public List<Prime> findAllPrimes(){
        List<PrimeEntity> primeEntities = this.dao.findAll();
        return converter.to(primeEntities);
    }

    @Override
    public PrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public Prime findPrimeById(Long id) {
        PrimeEntity primeEntity = findById(id);
        return converter.to(primeEntity);
    }

    @Override
    public PrimeEntity findByRef(String ref) {
        return this.dao.findByRef(ref);
    }

    @Override
    public Prime findPrimeByRef(String ref) {
        PrimeEntity primeEntity = findByRef(ref);
        return converter.to(primeEntity);
    }

    public void setDao(PrimeDao dao) {
        this.dao = dao;
    }
}
