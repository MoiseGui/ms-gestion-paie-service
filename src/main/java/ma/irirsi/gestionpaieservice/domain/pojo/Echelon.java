package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Echelon {
    Long id;
    String ref;
    String libelle;
    Integer niveau;
    BigDecimal montant;
    Echelle echelle;
}
