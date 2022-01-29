package ma.irirsi.gestionpaieservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class EchelonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String ref;
    String libelle;
    Integer niveau;
    BigDecimal montant;
    @ManyToOne
    EchelleEntity echelle;

    @JsonIgnoreProperties("echelon")
    @OneToMany(mappedBy = "echelon")
    List<UserEchelonEntity> userEchelons;
}
