package ma.irirsi.gestionpaieservice.application.dto;

import java.util.List;

public class PrimeDto {
    String id;
    String libelle;
    String montant;

    TypePrimeDto typePrimeDto;

    List<UserPrimeDto> userPrimeDtoDtos;
}
