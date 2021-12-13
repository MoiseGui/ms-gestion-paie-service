package ma.irirsi.gestionpaieservice.application.util;

import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcess;
import ma.irirsi.gestionpaieservice.domain.process.echelon.EchelonCreateProcessImpl;
import ma.irirsi.gestionpaieservice.infra.facade.EchelleInfra;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public EchelonCreateProcess echelonCreateProcess(EchelonInfra echelonInfra, EchelleInfra echelleInfra) {
        return new EchelonCreateProcessImpl(echelonInfra, echelleInfra);
    }
}

