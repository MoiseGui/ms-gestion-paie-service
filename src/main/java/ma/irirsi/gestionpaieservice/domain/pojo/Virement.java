package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Virement {
    Long id;
    String libelle;
    Date date;
    String userMatricule;
    BigDecimal montant;

    List<Prime> primes;
}
