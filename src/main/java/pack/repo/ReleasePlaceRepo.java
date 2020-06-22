package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.ReleasePlace;

import java.util.Optional;

public interface ReleasePlaceRepo extends JpaRepository<ReleasePlace,Long> {
    Optional<ReleasePlace> findByMovieName(String name);
}
