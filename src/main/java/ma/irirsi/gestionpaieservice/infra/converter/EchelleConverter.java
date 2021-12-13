package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.Echelle;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;
import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;

import java.util.ArrayList;
import java.util.List;

public class EchelleConverter {
    public static boolean convertEchelon;

    public static Echelle to(EchelleEntity echelleEntity) {
        if (echelleEntity == null) {
            return null;
        }
        Echelle echelle = new Echelle();
        echelle.setId(echelleEntity.getId());
        echelle.setRef(echelleEntity.getRef());
        echelle.setLibelle(echelleEntity.getLibelle());
        echelle.setNiveau(echelleEntity.getNiveau());
        echelle.setMontant(echelleEntity.getMontant());

        if (echelleEntity.getEchelons() != null && convertEchelon) {
            List<Echelon> echelonList = new ArrayList<>();
            echelleEntity.getEchelons().forEach(echelonEntity -> {
                echelonList.add(EchelonConverter.to(echelonEntity));
            });
            echelle.setEchelons(echelonList);
        }

        return echelle;
    }

    public static EchelleEntity toItem(Echelle item) {
        if (item == null) {
            return null;
        }
        EchelleEntity echelleEntity = new EchelleEntity();
        echelleEntity.setId(item.getId());
        echelleEntity.setRef(item.getRef());
        echelleEntity.setLibelle(item.getLibelle());
        echelleEntity.setNiveau(item.getNiveau());
        echelleEntity.setMontant(item.getMontant());

        if (item.getEchelons() != null && convertEchelon) {
            List<EchelonEntity> echelonEntityList = new ArrayList<>();
            item.getEchelons().forEach(echelon -> {
                echelonEntityList.add(EchelonConverter.toEntity(echelon));
            });
            echelleEntity.setEchelons(echelonEntityList);
        }

        return echelleEntity;
    }
}
