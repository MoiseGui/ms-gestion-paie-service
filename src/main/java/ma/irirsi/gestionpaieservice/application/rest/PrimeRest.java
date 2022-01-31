package ma.irirsi.gestionpaieservice.application.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.irirsi.gestionpaieservice.domain.pojo.Prime;
import ma.irirsi.gestionpaieservice.infra.entity.PrimeEntity;
import ma.irirsi.gestionpaieservice.infra.facade.PrimeInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-paie/api/v1/primes")
@Api("Via ce endpoint, vous povez gérer l'ensemble des primes")
public class PrimeRest {
    @Autowired
    private PrimeInfra primeInfra;

    @GetMapping("/")
    @ApiOperation("Via ce endpoint, vous povez récupérer la liste des primes")
    public List<PrimeEntity> findAll(){
        return this.primeInfra.findAll();
    }

    @PostMapping("/")
    @ApiOperation("Via ce endpoint, vous povez ajouter une prime")
    public PrimeEntity save(@RequestBody PrimeEntity prime){
        return this.primeInfra.save(prime);
    }

    @PutMapping("/")
    @ApiOperation("Via ce endpoint, vous povez modifier une prime")
    public PrimeEntity update(@RequestBody PrimeEntity prime){
        return this.primeInfra.update(prime);
    }

    @GetMapping("/ref/{ref}")
    @ApiOperation("Via ce endpoint, vous povez récupérer une prime par sa référence")
    public PrimeEntity findByRef(@PathVariable String ref){
        return this.primeInfra.findByRef(ref);
    }

    @GetMapping("/reference/{ref}")
    @ApiOperation("Via ce endpoint, vous povez récupérer une prime par sa référence")
    public PrimeEntity findByReference(@PathVariable String ref){
        return this.primeInfra.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @ApiOperation("Via ce endpoint, vous povez supprimer une prime")
    public int delete(@PathVariable String ref){
        return this.primeInfra.deleteByRef(ref);
    }
}
