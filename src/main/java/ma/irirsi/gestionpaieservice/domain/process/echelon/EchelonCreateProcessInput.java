package ma.irirsi.gestionpaieservice.domain.process.echelon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.irirsi.gestionpaieservice.domain.core.AbstractProcessInput;
import ma.irirsi.gestionpaieservice.domain.pojo.Echelon;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchelonCreateProcessInput extends AbstractProcessInput {
    private Echelon echelon;
}
