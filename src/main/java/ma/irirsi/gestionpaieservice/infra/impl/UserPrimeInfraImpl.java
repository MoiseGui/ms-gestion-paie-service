package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.UserPrime;
import ma.irirsi.gestionpaieservice.infra.converter.UserPrimeConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.UserPrimeDao;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.UserPrimeInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPrimeInfraImpl extends AbstractInfraImpl implements UserPrimeInfra {
    @Autowired
    UserPrimeDao dao;

    @Autowired
    UserPrimeConverter converter;

    @Override
    public UserPrimeEntity save(UserPrimeEntity userPrime) {
        return this.dao.save(userPrime);
    }

    @Override
    public UserPrime save(UserPrime userPrime) {
        UserPrimeEntity userPrimeEntity = converter.toItem(userPrime);
        System.out.println("userPrimeEntity before = " + userPrimeEntity);
        userPrimeEntity = this.save(userPrimeEntity);
        System.out.println("userPrimeEntity = " + userPrimeEntity);
        return converter.to(userPrimeEntity);
    }

    @Override
    public UserPrimeEntity update(UserPrimeEntity userPrime) {
        if (userPrime == null || this.findById(userPrime.getId()) == null) {
            return null;
        }
        System.out.println("userPrime = " + userPrime);
        return this.save(userPrime);
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
    public UserPrimeEntity findById(Long id) {
        return this.dao.findById(id).orElse(null);
    }

    @Override
    public UserPrime findUserPrimeById(Long id){
        return converter.to(this.findById(id));
    }

    @Override
    public List<UserPrimeEntity> findAll() {
        return this.dao.findAll();
    }

    @Override
    public List<UserPrime> findAllUserPrimes(){
        return converter.to(this.findAll());
    }


    @Override
    public List<UserPrimeEntity> findByUserMatricule(String userMatricule) {
        return this.dao.findByUserMatricule(userMatricule);
    }

    @Override
    public List<UserPrime> findUserPrimeByUserMatricule(String userMatricule){
        return converter.to(this.findByUserMatricule(userMatricule));
    }

}
