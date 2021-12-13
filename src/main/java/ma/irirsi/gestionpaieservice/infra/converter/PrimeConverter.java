package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.domain.pojo.TypePrime;
import ma.irirsi.gestionpaieservice.domain.pojo.UserPrime;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Mapper(componentModel = "spring")
@Component
public class PrimeConverter implements Converter<Prime, PrimeEntity>{

    @Override
    public Prime to(PrimeEntity primeEntity) {
        if (primeEntity == null) {
            return null;
        }
        Prime prime = new Prime();
        prime.setId(primeEntity.getId());
        prime.setRef(primeEntity.getRef());
        prime.setLibelle(primeEntity.getLibelle());
        prime.setMontant(primeEntity.getMontant());

        if (primeEntity.getTypePrime() != null) {
            TypePrime typePrime = new TypePrime();
            BeanUtils.copyProperties(primeEntity.getTypePrime(), typePrime);
            prime.setTypePrime(typePrime);
        }

        if (primeEntity.getUserPrimes() != null) {
            List<UserPrime> userPrimes = new ArrayList<>();
            primeEntity.getUserPrimes().forEach(up -> {
                UserPrime userPrime = new UserPrime();
                BeanUtils.copyProperties(up, userPrime);
                userPrimes.add(userPrime);
            });
            prime.setUserPrimes(userPrimes);
        }

        return prime;
    }

    @Override
    public PrimeEntity toItem(Prime item) {
        if (item == null) {
            return null;
        }
        PrimeEntity primeEntity = new PrimeEntity();
        primeEntity.setId(item.getId());
        primeEntity.setRef(item.getRef());
        primeEntity.setLibelle(item.getLibelle());
        primeEntity.setMontant(item.getMontant());

        if (item.getTypePrime() != null) {
            TypePrimeEntity typePrimeEntity = new TypePrimeEntity();
            BeanUtils.copyProperties(item.getTypePrime(), typePrimeEntity);
            primeEntity.setTypePrime(typePrimeEntity);
        }

        if (item.getUserPrimes() != null) {
            List<UserPrimeEntity> userPrimeEntities = new ArrayList<>();
            item.getUserPrimes().forEach(up -> {
                UserPrimeEntity userPrimeEntity = new UserPrimeEntity();
                BeanUtils.copyProperties(up, userPrimeEntity);
                userPrimeEntities.add(userPrimeEntity);
            });
            primeEntity.setUserPrimes(userPrimeEntities);
        }

        return primeEntity;
    }
}
