package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.UserPrimeService;
import ma.irirsi.gestionpaieservice.infra.entity.UserPrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userPrimes")
public class UserPrimeRest {
    @Autowired
    private UserPrimeService service;

    @GetMapping("/")
    public List<UserPrimeEntity> findAll(){
        return this.service.findAll();
    }

    @PostMapping("/")
    public UserPrimeEntity save(@RequestBody UserPrimeEntity userPrime){
        return this.service.save(userPrime);
    }

    @PutMapping("/")
    public UserPrimeEntity update(@RequestBody UserPrimeEntity userPrime){
        return this.service.update(userPrime);
    }

    @GetMapping("/userMatricule/{userMatricule}")
    public List<UserPrimeEntity> findByUserMatricule(@PathVariable String userMatricule){
        return this.service.findByUserMatricule(userMatricule);
    }
}
