package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.UserPrimeInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userPrimes")
public class UserPrimeRest {
    @Autowired
    private UserPrimeInfra userPrimeInfra;

    @GetMapping("/")
    public List<UserPrimeEntity> findAll() {
        return this.userPrimeInfra.findAll();
    }

    @GetMapping("/user/currentMontant/{userMatricule}")
    public BigDecimal findUserCurrentPrimesMontant(@PathVariable String userMatricule) {
        return userPrimeInfra.findUserCurrentPrimesMontant(userMatricule);
    }

    @GetMapping("active/user/{userMatricule}")
    public List<String> findActivePrimesForUser(@PathVariable String userMatricule) {
        List<String> activePrimes = new ArrayList<>();
        for (UserPrimeEntity userPrimeEntity : this.userPrimeInfra.findByUserMatriculeAndIsActive(userMatricule, true)) {
            activePrimes.add(userPrimeEntity.getPrime().getRef());
        }

        return activePrimes;
    }

    @PostMapping("/")
    public UserPrimeEntity save(@RequestBody UserPrimeEntity userPrime) {
        return this.userPrimeInfra.save(userPrime);
    }

    @PutMapping("/")
    public UserPrimeEntity update(@RequestBody UserPrimeEntity userPrime) {
        return this.userPrimeInfra.update(userPrime);
    }

    @GetMapping("/userMatricule/{userMatricule}")
    public List<UserPrimeEntity> findByUserMatricule(@PathVariable String userMatricule) {
        return this.userPrimeInfra.findByUserMatricule(userMatricule);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        this.userPrimeInfra.deleteById(id);
    }
}
