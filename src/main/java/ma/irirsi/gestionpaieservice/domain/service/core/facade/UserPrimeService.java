package ma.irirsi.gestionpaieservice.domain.service.core.facade;

import ma.irirsi.gestionpaieservice.infrastructure.entity.UserPrimeEntity;

import java.util.List;

public interface UserPrimeService {
    public UserPrimeEntity save(UserPrimeEntity userPrime);
    public UserPrimeEntity update(UserPrimeEntity userPrime);
    public UserPrimeEntity findById(Long id);
    public List<UserPrimeEntity> findAll();
    public List<UserPrimeEntity> findByUserMatricule(String userMatricule);
}
