package Repository;

import Model.HayvanHayvanSahibi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HayvanHayvanSahibiRepository extends JpaRepository<HayvanHayvanSahibi,Long> {
}
