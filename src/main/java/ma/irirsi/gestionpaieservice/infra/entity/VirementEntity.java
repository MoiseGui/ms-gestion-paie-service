package ma.irirsi.gestionpaieservice.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VirementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String libelle;
    Date date;
    String userMatricule;
    BigDecimal montant;

    @OneToMany
    List<PrimeEntity> primes;
}
