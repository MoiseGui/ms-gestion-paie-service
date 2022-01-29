package ma.irirsi.gestionpaieservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEchelon {
    Long id;

    String userMatricule;
    Echelon echelon;

    Date dateDebut;
    Date dateFin;

    Boolean isActive;
}
