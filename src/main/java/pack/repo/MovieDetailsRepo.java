package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.MovieDetails;

import java.util.Optional;

public interface MovieDetailsRepo extends JpaRepository<MovieDetails,Long> {

    Optional<MovieDetails> findByMovieName(String name);
}
