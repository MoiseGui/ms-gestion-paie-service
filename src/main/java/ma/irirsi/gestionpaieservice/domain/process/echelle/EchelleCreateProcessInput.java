package ma.irirsi.gestionpaieservice.domain.process.echelle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.irirsi.gestionpaieservice.domain.core.AbstractProcessInput;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelle;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchelleCreateProcessInput extends AbstractProcessInput {
    private Echelle echelle;
}
