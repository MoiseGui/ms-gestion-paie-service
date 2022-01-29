package ma.irirsi.gestionpaieservice.infra.facade;

import ma.irirsi.gestionpaieservice.domain.pojo.UserEchelon;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfra;

import java.math.BigDecimal;
import java.util.List;

public interface UserEchelonInfra extends AbstractInfra {
    List<UserEchelon> findAll();

    UserEchelon findById(Long id);

    UserEchelon save(UserEchelon userEchelon);

    UserEchelon update(UserEchelon userEchelon);

    int delete(Long id);

    List<UserEchelon> findByUserMatricule(String userMatricule);

    BigDecimal findUserCurrentEchelonMontant(String userMatricule);

    UserEchelon findByUserMatriculeAndIsActive(String userMatricule, boolean isActive);

    UserEchelon findByUserMatriculeAndEchelonRef(String userMatricule, String ref);

    UserEchelon activate(String userMatricule, String echelonRef);

    UserEchelon deactivate(String userMatricule, String echelonRef);
}