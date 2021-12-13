package ma.irirsi.gestionpaieservice.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
