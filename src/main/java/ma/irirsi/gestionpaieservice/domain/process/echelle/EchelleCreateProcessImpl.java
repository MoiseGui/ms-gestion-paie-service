package ma.irirsi.gestionpaieservice.domain.process.echelle;

import ma.irirsi.gestionpaieservice.domain.core.AbstractProcessImpl;
import ma.irirsi.gestionpaieservice.domain.core.Result;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelle;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;
import ma.irirsi.gestionpaieservice.infra.facade.EchelleInfra;
import ma.irirsi.gestionpaieservice.infra.facade.EchelonInfra;

import java.math.BigDecimal;
import java.util.Comparator;

public class EchelleCreateProcessImpl extends AbstractProcessImpl<EchelleCreateProcessInput> implements EchelleCreateProcess {
    EchelonInfra echelonInfra;
    EchelleInfra echelleInfra;

    public EchelleCreateProcessImpl(EchelonInfra echelonInfra, EchelleInfra echelleInfra) {
        this.echelonInfra = echelonInfra;
        this.echelleInfra = echelleInfra;
    }

    @Override
    public void validate(EchelleCreateProcessInput abstractProcessInput, Result result) {
        Echelle echelle = abstractProcessInput.getEchelle();

        if (echelle == null) {
            result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.echelle.null"));
        } else {
            if (echelle.getId() != null) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.id.not.null"));
            }

            if (echelle.getRef() == null) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.ref.required"));
            } else {
                if (echelleInfra.findByRef(echelle.getRef()) != null) {
                    result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.ref.already.exists"));
                }
            }

            if (echelle.getLibelle() == null) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.libelle.required"));
            }

            if (echelle.getNiveau() == null) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.niveau.required"));
            } else {
                if (echelle.getNiveau() < 1) {
                    result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.niveau.invalid"));
                } else {
                    if (echelleInfra.findByNiveau(echelle.getNiveau()) != null) {
                        result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.niveau.already.exists"));
                    } else {
                        if (echelle.getMontant() != null) {
                            Echelle previousEchelle = echelleInfra.findByEchelleNiveau(echelle.getNiveau() - 1);
                            if (previousEchelle != null && previousEchelle.getMontant() != null) {
                                if (echelle.getMontant().compareTo(previousEchelle.getMontant()) <= 0) {
                                    result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.montant.shoud.be.greater.than.previous"));
                                } else {
                                    // compute montant of previous echelle + monant of its last echelon
                                    Echelon lastEchelon = getLastEchelon(previousEchelle);
                                    if (lastEchelon != null && lastEchelon.getMontant() != null) {
                                        if (lastEchelon.getMontant().add(previousEchelle.getMontant()).compareTo(echelle.getMontant()) >= 0) {
                                            result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.montant.shoud.be.greater.than.previous.echelon"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (echelle.getMontant() == null) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.montant.required"));
            } else if (echelle.getMontant().compareTo(BigDecimal.ZERO) < 0) {
                result.addErrorMessage(echelleInfra.getMessage("echelle.create.error.montant.invalid"));
            }
        }


    }

    @Override
    public void run(EchelleCreateProcessInput abstractProcessInput, Result result) {
        Echelle echelle = echelleInfra.save(abstractProcessInput.getEchelle());
        result.setOutput(echelle);
        result.addInfoMessage(echelleInfra.getMessage("echelle.create.success"));
    }

    Echelon getLastEchelon(Echelle echelle) {
        if (echelle.getEchelons() == null || echelle.getEchelons().isEmpty()) {
            return null;
        }
        echelle.getEchelons().sort(Comparator.comparing(Echelon::getNiveau));
        return echelle.getEchelons().get(echelle.getEchelons().size() - 1);
    }
}
