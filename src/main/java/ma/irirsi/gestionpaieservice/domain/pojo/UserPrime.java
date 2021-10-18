package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPrime {
    Long id;
    String userMatricule;

    Prime prime;

    Date dateDebut;
    Date dateFin;
    Boolean isActive;
}
