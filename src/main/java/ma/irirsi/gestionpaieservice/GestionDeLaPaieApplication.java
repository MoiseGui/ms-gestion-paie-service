package ma.irirsi.gestionpaieservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.PrimeInfra;
import ma.irirsi.gestionpaieservice.infra.facade.TypePrimeInfa;
import ma.irirsi.gestionpaieservice.infra.facade.UserPrimeInfra;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class GestionDeLaPaieApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeLaPaieApplication.class, args);
    }

    // ordre
    // 1. charger et sauv les types de primes
    // 2. charger les primes affecter les types et sauv
    // 3. créer les userPrimes en affectant user1, user2, user3 et sauv
    // 4. charger les echelons et sauv
    // 5. charger les echelles affecter les echelons et sauv
    // 6. créer les userEchelons en affectant user1, user2, user3 et sauv

//    @Bean
//    CommandLineRunner runner(PrimeInfra primeInfra, TypePrimeInfa typePrimeInfa, UserPrimeInfra userPrimeInfra) {
//        return args -> {
//            // read json and write to db
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<TypePrimeEntity>> typePrimeRef = new TypeReference<List<TypePrimeEntity>>() {
//            };
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//            try {
//                List<TypePrimeEntity> typePrimeEntities = mapper.readValue(inputStream, typePrimeRef);
//                TypePrimeEntity typePrime = typePrimeInfa.save(typePrimeEntities.get(0));
//                System.out.println("typeprime saved!");
//
//                TypeReference<List<PrimeEntity>> primesRef = new TypeReference<List<PrimeEntity>>() {
//                };
//                inputStream = TypeReference.class.getResourceAsStream("/json/primes.json");
//                List<PrimeEntity> primeEntities = mapper.readValue(inputStream, primesRef);
//                primeEntities.forEach(primeEntity -> primeEntity.setTypePrime(typePrime));
//                primeEntities = primeEntities.stream().map(primeInfra::save).collect(Collectors.toList());
//                System.out.println("primes saved!");
//
//                // user primes for user1
//                UserPrimeEntity userPrimeEntity1 = new UserPrimeEntity("user1",
//                        primeEntities.get(0), new Date(), new Date(), true);
//                userPrimeInfra.save(userPrimeEntity1);
//                UserPrimeEntity userPrimeEntity2 = new UserPrimeEntity("user1",
//                        primeEntities.get(1), new Date(), new Date(), true);
//                userPrimeInfra.save(userPrimeEntity2);
//
//                // user primes for user2
//                UserPrimeEntity userPrimeEntity3 = new UserPrimeEntity("user2",
//                        primeEntities.get(1), new Date(), new Date(), true);
//                userPrimeInfra.save(userPrimeEntity3);
//
//                // user primes for user3
//                UserPrimeEntity userPrimeEntity4 = new UserPrimeEntity("user3",
//                        primeEntities.get(2), new Date(), new Date(), true);
//                userPrimeInfra.save(userPrimeEntity4);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };
//    }
}
