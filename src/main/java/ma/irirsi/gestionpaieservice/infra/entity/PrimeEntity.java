package ma.irirsi.gestionpaieservice.infra.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PrimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String ref;
    String libelle;
    BigDecimal montant;

    @ManyToOne
    TypePrimeEntity typePrime;

    @JsonIgnoreProperties("prime")
    @OneToMany(mappedBy = "prime")
    List<UserPrimeEntity> userPrimes;

}
