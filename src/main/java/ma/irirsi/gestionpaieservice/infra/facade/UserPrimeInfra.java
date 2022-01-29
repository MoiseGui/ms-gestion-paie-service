package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.domain.pojo.UserPrime;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;

import java.math.BigDecimal;
import java.util.List;

public interface UserPrimeInfra extends AbstractInfra {
    public UserPrimeEntity save(UserPrimeEntity userPrime);

    UserPrime save(UserPrime userPrime);

    UserPrimeEntity update(UserPrimeEntity userPrime);

    int deleteById(Long id);

    public UserPrimeEntity findById(Long id);

    UserPrime findUserPrimeById(Long id);

    public List<UserPrimeEntity> findAll();

    List<UserPrime> findAllUserPrimes();

    public BigDecimal findUserCurrentPrimesMontant(String userMatricule);

    public List<UserPrimeEntity> findByUserMatricule(String userMatricule);
    public List<UserPrimeEntity> findByUserMatriculeAndIsActive(String userMatricule, boolean isActive);

    List<UserPrime> findUserPrimeByUserMatricule(String userMatricule);
}
