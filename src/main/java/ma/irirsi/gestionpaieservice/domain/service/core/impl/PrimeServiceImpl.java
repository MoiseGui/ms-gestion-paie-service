package ma.irirsi.gestionpaieservice.domain.service.core.impl;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.PrimeService;
import ma.irirsi.gestionpaieservice.infrastructure.dao.PrimeDao;
import ma.irirsi.gestionpaieservice.infrastructure.entity.PrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimeServiceImpl implements PrimeService {
    @Autowired
    private PrimeDao dao;

    @Override
    public PrimeEntity save(PrimeEntity prime) {
        return this.dao.save(prime);
    }

    @Override
    public PrimeEntity update(PrimeEntity prime) {
        System.out.println("La PRIME "+prime.toString());
        if(prime == null || findById(prime.getId()) == null) return null;
        return this.dao.save(prime);
    }

    @Override
    public List<PrimeEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public PrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public PrimeEntity findByRef(String ref) {
        return this.dao.findByRef(ref);
    }

    public void setDao(PrimeDao dao) {
        this.dao = dao;
    }
}
