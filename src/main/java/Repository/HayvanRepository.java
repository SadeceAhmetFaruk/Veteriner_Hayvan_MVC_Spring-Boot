package Repository;

import Model.Hayvan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HayvanRepository extends JpaRepository<Hayvan,Long> {
    List<Hayvan> findByNameHayvan(String name);
}
