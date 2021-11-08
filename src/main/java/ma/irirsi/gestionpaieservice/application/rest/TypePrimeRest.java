package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.service.core.facade.TypePrimeService;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/typePrimes")
public class TypePrimeRest {
    @Autowired
    private TypePrimeService service;

    @GetMapping("/")
    public List<TypePrimeEntity> findAll(){
        return this.service.findAll();
    }

    @PostMapping("/")
    public TypePrimeEntity save(@RequestBody TypePrimeEntity typePrime){
        return this.service.save(typePrime);
    }

    @PutMapping("/")
    public TypePrimeEntity update(@RequestBody TypePrimeEntity typePrime){
        return this.service.update(typePrime);
    }
}
