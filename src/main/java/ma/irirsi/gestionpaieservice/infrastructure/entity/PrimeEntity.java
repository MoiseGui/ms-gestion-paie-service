package ma.irirsi.gestionpaieservice.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    public PrimeEntity(Long id, BigDecimal montant){
        this.id = id;
        this.montant = montant;
    }

    @ManyToOne
    TypePrimeEntity typePrimeEntity;

    @JsonIgnoreProperties("primeEntity")
    @OneToMany(mappedBy = "primeEntity")
    List<UserPrimeEntity> userPrimeEntities;
}
