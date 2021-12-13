package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Echelle {
    Long id;
    String ref;
    String libelle;
    Integer niveau;
    BigDecimal montant;
    List<Echelon> echelons;
}
