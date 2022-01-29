package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Echelon {
    Long id;
    String ref;
    String libelle;
    Integer niveau;
    BigDecimal montant;
    Echelle echelle;

    List<UserEchelon> userEchelons;
}
