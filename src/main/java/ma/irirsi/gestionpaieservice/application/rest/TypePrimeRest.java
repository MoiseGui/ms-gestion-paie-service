package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.pojo.TypePrime;
import ma.irirsi.gestionpaieservice.infra.entity.TypePrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.TypePrimeInfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/gestion-paie/api/v1/typePrimes")
public class TypePrimeRest {
    @Autowired
    private TypePrimeInfa typePrimeInfa;

    @GetMapping("/")
    public List<TypePrimeEntity> findAll(){
        return this.typePrimeInfa.findAll();
    }

    @PostMapping("/")
    public TypePrimeEntity save(@RequestBody TypePrimeEntity typePrime){
        return this.typePrimeInfa.save(typePrime);
    }

    @PutMapping("/")
    public TypePrimeEntity update(@RequestBody TypePrimeEntity typePrime){
        return this.typePrimeInfa.update(typePrime);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id){
        return this.typePrimeInfa.deleteById(id);
    }
}
