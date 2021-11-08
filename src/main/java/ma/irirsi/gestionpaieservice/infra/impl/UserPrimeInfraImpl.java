package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.infra.dao.UserPrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.UserPrimeInfra;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserPrimeInfraImpl implements UserPrimeInfra {
    @Autowired
    UserPrimeDao dao;

    @Override
    public UserPrimeEntity save(UserPrimeEntity userPrime) {
        return this.dao.save(userPrime);
    }

    @Override
    public UserPrimeEntity update(UserPrimeEntity userPrime) {
        return this.dao.save(userPrime);
    }

    @Override
    public UserPrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public List<UserPrimeEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public List<UserPrimeEntity> findByUserMatricule(String userMatricule) {
        return this.dao.findByUserMatricule(userMatricule);
    }
}
