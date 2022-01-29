package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.domain.core.Result;
import ma.irirsi.gestionpaieservice.domain.pojo.UserEchelon;
import ma.irirsi.gestionpaieservice.domain.process.userEchelon.ActivateUserEchelonProcess;
import ma.irirsi.gestionpaieservice.domain.process.userEchelon.ActivateUserEchelonProcessInput;
import ma.irirsi.gestionpaieservice.infra.facade.UserEchelonInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userEchelons")
public class UserEchelonRest {
    @Autowired
    private UserEchelonInfra infra;

    @Autowired
    private ActivateUserEchelonProcess activateUserEchelonProcess;


    @GetMapping("/")
    public List<UserEchelon> findAll() {
        return infra.findAll();
    }

    @GetMapping("/user/currentMontant/{userMatricule}")
    public BigDecimal findUserCurrentEchelonMontant(@PathVariable String userMatricule) {
        return infra.findUserCurrentEchelonMontant(userMatricule);
    }

    @GetMapping("/active/user/{userMatricule}")
    public String findActiveEchelonForUser(@PathVariable String userMatricule) {
        UserEchelon userEchelon = infra.findByUserMatriculeAndIsActive(userMatricule, true);
        if(userEchelon != null) {
            return userEchelon.getEchelon().getRef();
        }
        return null;
    }

    @PostMapping("/")
    public UserEchelon save(@RequestBody UserEchelon userEchelon) {
        return infra.save(userEchelon);
    }

    @PutMapping("/activate/user/{userMatricule}/echelon/{echelonRef}")
    public Result activate(@PathVariable String userMatricule, @PathVariable String echelonRef) {
        return activateUserEchelonProcess.execute(new ActivateUserEchelonProcessInput(userMatricule, echelonRef));
    }

    @PutMapping("/desactivate/user/{userMatricule}/echelon/{echelonRef}")
    public UserEchelon desactivate(@PathVariable String userMatricule, @PathVariable String echelonRef) {
        return infra.deactivate(userMatricule, echelonRef);
    }
}
