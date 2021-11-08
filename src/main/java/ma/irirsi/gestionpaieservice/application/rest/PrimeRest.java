package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.PrimeService;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/primes")
public class PrimeRest {
    @Autowired
    private PrimeService service;

    @GetMapping("/")
    public List<PrimeEntity> findAll(){
        return this.service.findAll();
    }

    @PostMapping("/")
    public PrimeEntity save(@RequestBody PrimeEntity prime){
        return this.service.save(prime);
    }

    @PutMapping("/")
    public PrimeEntity update(@RequestBody PrimeEntity prime){
        return this.service.update(prime);
    }

    @GetMapping("/ref/{ref}")
    public PrimeEntity findByRef(@PathVariable String ref){
        return this.service.findByRef(ref);
    }
}
