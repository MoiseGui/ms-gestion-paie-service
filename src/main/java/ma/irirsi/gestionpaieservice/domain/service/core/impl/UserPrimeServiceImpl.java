package ma.irirsi.gestionpaieservice.domain.service.core.impl;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.UserPrimeService;
import ma.irirsi.gestionpaieservice.infra.dao.UserPrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPrimeServiceImpl implements UserPrimeService {
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
