package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.ReleasePlace;

import java.util.List;

public interface ReleasePlaceRepo extends JpaRepository<ReleasePlace,Long> {
    List<ReleasePlace> findByMovieName(String name);
}
