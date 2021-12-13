package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.core.Result;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcess;
import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcessInput;
import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/echelons")
public class EchelonRest {
    @Autowired
    EchelonCreateProcess echelonCreateProcess;

    @Autowired
    EchelonInfra infra;

    @GetMapping("/")
    public List<EchelonEntity> findAll(){
        return this.infra.findAll();
    }

    @GetMapping("/all")
    public List<Echelon> findAllEchelons(){
        return this.infra.findAllEchelon();
    }

    @GetMapping("/ref/{ref}")
    public EchelonEntity findByRef(@PathVariable String ref){
        return this.infra.findByRef(ref);
    }

    @GetMapping("/niveau/{niveau}")
    public EchelonEntity findByNiveau(@PathVariable Integer niveau){
        return this.infra.findByNiveau(niveau);
    }

    @GetMapping("niveau/{niveau}/echelle/{echelle}")
    public EchelonEntity findByNiveauAndEchelleId(@PathVariable Integer niveau, @PathVariable Long echelle){
        return this.infra.findByNiveauAndEchelleId(niveau, echelle);
    }

    @PostMapping("/")
    public Result save(@RequestBody Echelon echelon){
        return this.echelonCreateProcess.execute(new EchelonCreateProcessInput(echelon));
    }

//    @PostMapping("/")
//    public EchelonEntity save(@RequestBody EchelonEntity echelon){
//        return this.infra.save(echelon);
//    }


//    @PostMapping("/")
//    public Echelon save(@RequestBody Echelon echelon){
//        return this.infra.save(echelon);
//    }

    @PutMapping("/")
    public EchelonEntity update(@RequestBody EchelonEntity echelon){
        return this.infra.update(echelon);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref){
        return this.infra.deleteByRef(ref);
    }
}
