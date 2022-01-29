package ma.irirsi.gestionpaieservice.domain.process.userEchelon;

import ma.irirsi.gestionpaieservice.domain.core.AbstractProcessImpl;
import ma.irirsi.gestionpaieservice.domain.core.Result;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.domain.pojo.UserEchelon;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;
import ma.irirsi.gestionpaieservice.infra.facade.UserEchelonInfra;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivateUserEchelonProcessImpl extends AbstractProcessImpl<ActivateUserEchelonProcessInput> implements ActivateUserEchelonProcess {
    UserEchelonInfra userEchelonInfra;
    EchelonInfra echelonInfra;

    public ActivateUserEchelonProcessImpl(UserEchelonInfra userEchelonInfra, EchelonInfra echelonInfra) {
        this.userEchelonInfra = userEchelonInfra;
        this.echelonInfra = echelonInfra;
    }

    @Override
    public void validate(ActivateUserEchelonProcessInput abstractProcessInput, Result result) {
        if(abstractProcessInput.getUserMatricule() == null) {
            result.addErrorMessage(userEchelonInfra.getMessage("activateUserEchelonProcess.userMatricule.required"));
        }

        if(abstractProcessInput.getEchelonRef() == null) {
            result.addErrorMessage(userEchelonInfra.getMessage("activateUserEchelonProcess.echelonRef.required"));
        }

        if(abstractProcessInput.getUserMatricule() != null && abstractProcessInput.getEchelonRef() != null) {
           if(echelonInfra.findEchelonByRef(abstractProcessInput.getEchelonRef()) == null) {
               result.addErrorMessage(userEchelonInfra.getMessage("activateUserEchelonProcess.echelon.notFound"));
           }
            UserEchelon curentUserEchelon = userEchelonInfra.findByUserMatriculeAndEchelonRef(abstractProcessInput.getUserMatricule(), abstractProcessInput.getEchelonRef());
           if(curentUserEchelon == null) {
               result.addErrorMessage(userEchelonInfra.getMessage("activateUserEchelonProcess.userEchelon.notFound"));
           }
           else if(curentUserEchelon.getIsActive()) {
               result.addErrorMessage(userEchelonInfra.getMessage("activateUserEchelonProcess.userEchelon.alreadyActive"));
           }
        }
    }

    @Override
    public void run(ActivateUserEchelonProcessInput abstractProcessInput, Result result) {
        // check if there is an active userEchelon for the user
        UserEchelon activeUserEchelon = userEchelonInfra.findByUserMatriculeAndIsActive(abstractProcessInput.getUserMatricule(), true);

        if(activeUserEchelon != null) {
            activeUserEchelon.setIsActive(false);
            userEchelonInfra.save(activeUserEchelon);
        }

        UserEchelon curentUserEchelon = userEchelonInfra.findByUserMatriculeAndEchelonRef(abstractProcessInput.getUserMatricule(), abstractProcessInput.getEchelonRef());
        curentUserEchelon.setIsActive(true);
        userEchelonInfra.save(curentUserEchelon);
    }
}
