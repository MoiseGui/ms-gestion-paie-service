package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.domain.pojo.TypePrime;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Mapper(componentModel = "spring")
@Component
public class TypePrimeConverter implements Converter<TypePrime, TypePrimeEntity> {
    @Override
    public TypePrime to(TypePrimeEntity typePrimeEntity) {
        if (typePrimeEntity == null) {
            return null;
        }
        TypePrime typePrime = new TypePrime();
        typePrime.setId(typePrimeEntity.getId());
        typePrime.setLibelle(typePrimeEntity.getLibelle());
        if (typePrimeEntity.getPrimes() != null) {
            List<Prime> primes = new ArrayList<>();
            typePrimeEntity.getPrimes().forEach(p -> {
                Prime prime = new Prime();
                BeanUtils.copyProperties(p, prime);
                primes.add(prime);
            });
            typePrime.setPrimes(primes);
        }

        return typePrime;
    }

    @Override
    public TypePrimeEntity toItem(TypePrime item) {
        return null;
    }
}
