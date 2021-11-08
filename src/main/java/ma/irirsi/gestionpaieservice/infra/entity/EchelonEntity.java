package ma.irirsi.gestionpaieservice.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EchelonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String libelle;
    BigDecimal montant;
    @ManyToOne
    EchelleEntity echelleEntity;
}
