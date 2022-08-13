package Repository;

import Model.Hayvan;
import Model.HayvanSahibi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HayvanSahibiRepository extends JpaRepository<HayvanSahibi,Long> {
    HayvanSahibi findByNameHayvanSahibi(String name);
}
