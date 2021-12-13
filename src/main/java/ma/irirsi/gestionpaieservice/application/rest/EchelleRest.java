package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;
import ma.irirsi.gestionpaieservice.infra.facade.EchelleInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/echelles")
public class EchelleRest {

    @Autowired
    EchelleInfra echelleInfra;

    @GetMapping("/")
    public List<EchelleEntity> findAll() {
        return echelleInfra.findAll();
    }

    @GetMapping("/ref/{ref}")
    public EchelleEntity findByRef(@PathVariable String ref) {
        return echelleInfra.findByRef(ref);
    }

    @GetMapping("/niveau/{niveau}")
    public EchelleEntity findByNiveau(@PathVariable Integer niveau) {
        return echelleInfra.findByNiveau(niveau);
    }

    @PostMapping("/")
    public EchelleEntity save(@RequestBody EchelleEntity echelleEntity) {
        return echelleInfra.save(echelleEntity);
    }

    @PutMapping("/")
    public EchelleEntity update(@RequestBody EchelleEntity echelleEntity) {
        return echelleInfra.update(echelleEntity);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return echelleInfra.deleteByRef(ref);
    }
}
