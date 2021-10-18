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
public class Prime {
    Long id;
    String libelle;
    BigDecimal montant;

    TypePrime typePrime;

    List<UserPrime> userPrimes;
}
