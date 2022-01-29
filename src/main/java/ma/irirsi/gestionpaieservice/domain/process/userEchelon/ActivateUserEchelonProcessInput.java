package ma.irirsi.gestionpaieservice.domain.process.userEchelon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.irirsi.gestionpaieservice.domain.core.AbstractProcessInput;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivateUserEchelonProcessInput extends AbstractProcessInput {
    private String userMatricule;
    private String echelonRef;
}
