package ma.irirsi.gestionpaieservice.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserPrimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String userMatricule;

    @ManyToOne
    PrimeEntity prime;

    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    Date dateFin;

    Boolean isActive;

    public UserPrimeEntity(String userMatricule, PrimeEntity prime, Date dateDebut, Date dateFin, Boolean isActive) {
        this.userMatricule = userMatricule;
        this.prime = prime;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isActive = isActive;
    }
}
