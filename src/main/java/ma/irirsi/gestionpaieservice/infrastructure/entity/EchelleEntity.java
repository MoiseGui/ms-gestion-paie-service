package ma.irirsi.gestionpaieservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EchelleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String libelle;
    BigDecimal montant;

    @OneToMany(mappedBy = "echelleEntity")
    List<EchelonEntity> echelonEntities;
}
