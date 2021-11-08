package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;

import java.util.List;

public interface UserPrimeInfra {
    public UserPrimeEntity save(UserPrimeEntity userPrime);
    public UserPrimeEntity update(UserPrimeEntity userPrime);
    public UserPrimeEntity findById(Long id);
    public List<UserPrimeEntity> findAll();
    public List<UserPrimeEntity> findByUserMatricule(String userMatricule);
}
