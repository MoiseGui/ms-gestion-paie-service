package ma.irirsi.gestionpaieservice.application.util;

import ma.irirsi.gestionpaieservice.domain.process.echelle.EchelleCreateProcess;
import ma.irirsi.gestionpaieservice.domain.process.echelle.EchelleCreateProcessImpl;
import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcess;
import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcessImpl;
import ma.irirsi.gestionpaieservice.domain.process.userEchelon.ActivateUserEchelonProcess;
import ma.irirsi.gestionpaieservice.domain.process.userEchelon.ActivateUserEchelonProcessImpl;
import ma.irirsi.gestionpaieservice.infra.facade.EchelleInfra;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;
import ma.irirsi.gestionpaieservice.infra.facade.UserEchelonInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public EchelonCreateProcess echelonCreateProcess(EchelonInfra echelonInfra, EchelleInfra echelleInfra) {
        return new EchelonCreateProcessImpl(echelonInfra, echelleInfra);
    }

    @Bean
    EchelleCreateProcess echelleCreateProcess(EchelonInfra echelonInfra, EchelleInfra echelleInfra) {
        return new EchelleCreateProcessImpl(echelonInfra, echelleInfra);
    }

    @Bean
    ActivateUserEchelonProcess activateUserEchelonProcess(UserEchelonInfra userEchelonInfra, EchelonInfra echelonInfra) {
        return new ActivateUserEchelonProcessImpl(userEchelonInfra, echelonInfra);
    }
}

