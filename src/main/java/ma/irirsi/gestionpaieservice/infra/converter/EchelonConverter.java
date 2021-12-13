package ma.irirsi.gestionpaieservice.infra.converter;

import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.infra.entity.EchelleEntity;
import ma.irirsi.gestionpaieservice.infra.entity.EchelonEntity;

public class EchelonConverter{
    public static boolean convertEchelle;

    public static Echelon to(EchelonEntity echelonEntity) {
        if (echelonEntity == null) return null;

        Echelon echelon = new Echelon();
        echelon.setId(echelonEntity.getId());
        echelon.setRef(echelonEntity.getRef());
        echelon.setLibelle(echelonEntity.getLibelle());
        echelon.setNiveau(echelonEntity.getNiveau());
        echelon.setMontant(echelonEntity.getMontant());
        if(convertEchelle && echelonEntity.getEchelle() != null) {
            echelon.setEchelle(EchelleConverter.to(echelonEntity.getEchelle()));
        }
        return echelon;
    }

    public static Echelon toWithoutEchelle(EchelonEntity echelonEntity) {
        if (echelonEntity == null) return null;

        Echelon echelon = new Echelon();
        echelon.setId(echelonEntity.getId());
        echelon.setRef(echelonEntity.getRef());
        echelon.setLibelle(echelonEntity.getLibelle());
        echelon.setNiveau(echelonEntity.getNiveau());
        echelon.setMontant(echelonEntity.getMontant());
        return echelon;
    }

    public static EchelonEntity toEntity(Echelon echelon) {
        if (echelon == null) return null;

        EchelonEntity echelonEntity = new EchelonEntity();
        echelonEntity.setId(echelon.getId());
        echelonEntity.setRef(echelon.getRef());
        echelonEntity.setLibelle(echelon.getLibelle());
        echelonEntity.setNiveau(echelon.getNiveau());
        echelonEntity.setMontant(echelon.getMontant());
        if(echelon.getEchelle() != null){
            if(convertEchelle) {
                echelonEntity.setEchelle(EchelleConverter.toItem(echelon.getEchelle()));
            }
            else{
                EchelleEntity echelle = new EchelleEntity();
                echelle.setId(echelon.getEchelle().getId());
                echelonEntity.setEchelle(echelle);
            }
        }

        return echelonEntity;
    }

    public static EchelonEntity toEntityOnlyWithEchelleId(Echelon echelon) {
        if (echelon == null) return null;

        EchelonEntity echelonEntity = new EchelonEntity();
        echelonEntity.setId(echelon.getId());
        echelonEntity.setRef(echelon.getRef());
        echelonEntity.setLibelle(echelon.getLibelle());
        echelonEntity.setNiveau(echelon.getNiveau());
        echelonEntity.setMontant(echelon.getMontant());
        if(echelon.getEchelle() != null) {
            EchelleEntity echelle = new EchelleEntity();
            echelle.setId(echelon.getEchelle().getId());
            echelonEntity.setEchelle(echelle);
        }
        return echelonEntity;
    }
}
