package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.Artists;

import java.util.Optional;

public interface ArtistsRepo extends JpaRepository<Artists,Long> {
    Optional<Artists> findByMovieName(String name);
}
