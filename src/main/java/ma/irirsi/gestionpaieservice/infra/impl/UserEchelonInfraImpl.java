package ma.irirsi.gestionpaieservice.infra.impl;

import ma.irirsi.gestionpaieservice.domain.pojo.UserEchelon;
import ma.irirsi.gestionpaieservice.infra.converter.EchelonConverter;
import ma.irirsi.gestionpaieservice.infra.converter.UserEchelonConverter;
import ma.irirsi.gestionpaieservice.infra.core.AbstractInfraImpl;
import ma.irirsi.gestionpaieservice.infra.dao.UserEchelonDao;
import ma.irirsi.gestionpaieservice.infra.entity.UserEchelonEntity;
import ma.irirsi.gestionpaieservice.infra.facade.UserEchelonInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class UserEchelonInfraImpl extends AbstractInfraImpl implements UserEchelonInfra {
    @Autowired
    UserEchelonDao dao;

    @Override
    public List<UserEchelon> findAll() {
        UserEchelonConverter.convertEchelon = true;
        return UserEchelonConverter.to(dao.findAll());
    }

    @Override
    public UserEchelon findById(Long id) {
        UserEchelonConverter.convertEchelon = true;
        return UserEchelonConverter.to(dao.findById(id).orElse(null));
    }

    @Override
    public UserEchelon save(UserEchelon userEchelon) {
        UserEchelonConverter.convertEchelon = true;
        UserEchelonEntity entity = UserEchelonConverter.toEntity(userEchelon);
        UserEchelonConverter.convertEchelon = true;
        return UserEchelonConverter.to(dao.save(entity));
    }

    @Override
    public UserEchelon update(UserEchelon userEchelon) {
        if (userEchelon.getId() == null) {
            return null;
        }

        if (findById(userEchelon.getId()) == null) {
            return null;
        }
        return save(userEchelon);
    }

    @Override
    public int delete(Long id) {
        dao.deleteById(id);
        return 1;
    }

    @Override
    public List<UserEchelon> findByUserMatricule(String userMatricule) {
        UserEchelonConverter.convertEchelon = true;
        EchelonConverter.convertEchelle = true;
        return UserEchelonConverter.to(dao.findByUserMatricule(userMatricule));
    }

    @Override
    public BigDecimal findUserCurrentEchelonMontant(String userMatricule) {
        List<UserEchelon> userEchelonList = findByUserMatricule(userMatricule);
        // find the first active echelon
        for (UserEchelon userEchelon : userEchelonList) {
            if (userEchelon.getIsActive()) {
                return userEchelon.getEchelon().getMontant().add(userEchelon.getEchelon().getEchelle().getMontant());
            }
        }
        return null;
    }

    @Override
    public UserEchelon findByUserMatriculeAndIsActive(String userMatricule, boolean isActive) {
        UserEchelonConverter.convertEchelon = true;
        return UserEchelonConverter.to(dao.findByUserMatriculeAndIsActive(userMatricule, isActive));
    }

    @Override
    public UserEchelon findByUserMatriculeAndEchelonRef(String userMatricule, String ref) {
        UserEchelonConverter.convertEchelon = true;
        return UserEchelonConverter.to(dao.findByUserMatriculeAndEchelonRef(userMatricule, ref));
    }

    @Override
    public UserEchelon activate(String userMatricule, String echelonRef) {
        UserEchelon userEchelon = findByUserMatriculeAndEchelonRef(userMatricule, echelonRef);

        if (userEchelon != null) {
            UserEchelon activeUserEchelon = findByUserMatriculeAndIsActive(userMatricule, true);

            if (activeUserEchelon != null) {
                activeUserEchelon.setIsActive(false);
                save(activeUserEchelon);
            }

            userEchelon.setIsActive(true);
            return save(userEchelon);
        }

        return null;
    }

    @Override
    public UserEchelon deactivate(String userMatricule, String echelonRef) {
        UserEchelon userEchelon = findByUserMatriculeAndEchelonRef(userMatricule, echelonRef);

        if (userEchelon != null) {
            userEchelon.setIsActive(false);
            return save(userEchelon);
        }

        return null;
    }
}
