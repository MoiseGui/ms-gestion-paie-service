package ma.irirsi.gestionpaieservice.application.dto;

import java.util.List;

public class VirementDto {
    String id;
    String libelle;
    String date;
    String userMatricule;
    String montant;

    List<PrimeDto> primes;
}
