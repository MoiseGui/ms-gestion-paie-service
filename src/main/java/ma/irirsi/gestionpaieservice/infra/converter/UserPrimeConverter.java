package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.domain.pojo.UserPrime;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring")
@Component
public class UserPrimeConverter implements Converter<UserPrime, UserPrimeEntity> {
//    @Autowired
//    PrimeConverter primeConverter;

    @Override
    public UserPrime to(UserPrimeEntity userPrimeEntity) {
        if (userPrimeEntity == null) {
            return null;
        }
        UserPrime userPrime = new UserPrime();
        userPrime.setId(userPrimeEntity.getId());
        userPrime.setUserMatricule(userPrimeEntity.getUserMatricule());
        userPrime.setDateDebut(userPrimeEntity.getDateDebut());
        userPrime.setDateFin(userPrimeEntity.getDateFin());
        userPrime.setIsActive(userPrimeEntity.getIsActive());
        if(userPrimeEntity.getPrime() != null) {
            Prime prime = new Prime();
            BeanUtils.copyProperties(userPrimeEntity.getPrime(), prime);
            userPrime.setPrime(prime);
        }
        return userPrime;
    }

    @Override
    public UserPrimeEntity toItem(UserPrime item) {
        if (item == null) {
            return null;
        }
        UserPrimeEntity userPrimeEntity = new UserPrimeEntity();
        userPrimeEntity.setId(item.getId());
        userPrimeEntity.setUserMatricule(item.getUserMatricule());
        userPrimeEntity.setDateDebut(item.getDateDebut());
        userPrimeEntity.setDateFin(item.getDateFin());
        userPrimeEntity.setIsActive(item.getIsActive());
        if(item.getPrime() != null) {
            PrimeEntity primeEntity = new PrimeEntity();
            BeanUtils.copyProperties(item.getPrime(), primeEntity);
            userPrimeEntity.setPrime(primeEntity);
        }
        return userPrimeEntity;
    }
}
