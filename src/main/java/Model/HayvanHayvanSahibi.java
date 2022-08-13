package Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/*amaç hibernate ile tabloları oluşturmak olduğundan,
* Column Table gibi notasyonlar oluşturmaktayım*/
@Data
@Table(name = "HayvanHayvanSahibi")
public class HayvanHayvanSahibi {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="agreement_id", referencedColumnName = "hayvan_id")
    private Hayvan hayvan;

    /*One to many olmalı ki bir  sahibine çok kaydedilebilsin */

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private HayvanSahibi hayvanSahibi;

    @Column(name="acceptance_date")
    private LocalDateTime acceptance_date;

}
