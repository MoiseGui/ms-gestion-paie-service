package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.UserEchelon;
import ma.irirsi.gestionpaieservice.infra.entity.UserEchelonEntity;

import java.util.ArrayList;
import java.util.List;

public class UserEchelonConverter {

    private UserEchelonConverter() {
    }

    public static boolean convertEchelon;

    public static UserEchelon to(UserEchelonEntity userEchelonEntity){
        if(userEchelonEntity == null){
            return null;
        }

        UserEchelon userEchelon = new UserEchelon();
        userEchelon.setId(userEchelonEntity.getId());
        userEchelon.setUserMatricule(userEchelonEntity.getUserMatricule());
        userEchelon.setDateDebut(userEchelonEntity.getDateDebut());
        userEchelon.setDateFin(userEchelonEntity.getDateFin());
        userEchelon.setIsActive(userEchelonEntity.getIsActive());

        if (convertEchelon) {
            userEchelon.setEchelon(EchelonConverter.to(userEchelonEntity.getEchelon()));
        }

        return userEchelon;
    }

    public static UserEchelonEntity toEntity(UserEchelon userEchelon){
        if(userEchelon == null){
            return null;
        }

        UserEchelonEntity userEchelonEntity = new UserEchelonEntity();
        userEchelonEntity.setId(userEchelon.getId());
        userEchelonEntity.setUserMatricule(userEchelon.getUserMatricule());
        userEchelonEntity.setDateDebut(userEchelon.getDateDebut());
        userEchelonEntity.setDateFin(userEchelon.getDateFin());
        userEchelonEntity.setIsActive(userEchelon.getIsActive());

        if (convertEchelon) {
            userEchelonEntity.setEchelon(EchelonConverter.toEntity(userEchelon.getEchelon()));
        }

        return userEchelonEntity;
    }

    public static List<UserEchelon> to(List<UserEchelonEntity> userEchelonEntities){
        List<UserEchelon> userEchelonList = new ArrayList<>();
        for(UserEchelonEntity userEchelonEntity : userEchelonEntities){
            userEchelonList.add(to(userEchelonEntity));
        }
        return userEchelonList;
    }

    public static List<UserEchelonEntity> toEntity(List<UserEchelon> userEchelonList){
        List<UserEchelonEntity> userEchelonEntities = new ArrayList<>();
        for(UserEchelon userEchelon : userEchelonList){
            userEchelonEntities.add(toEntity(userEchelon));
        }
        return userEchelonEntities;
    }
}
