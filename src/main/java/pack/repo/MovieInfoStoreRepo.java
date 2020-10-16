package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.MovieInfoStore;

import java.util.List;

public interface MovieInfoStoreRepo extends JpaRepository<MovieInfoStore,Integer> {
    MovieInfoStore findByDirectorAndProducer(String director, String producer);

    MovieInfoStore findDistinctMovieInfoStoreByName(String name);

    MovieInfoStore findDistinctMovieInfoStoreByNameOrDirector(String name, String director);

    MovieInfoStore findByNameIgnoreCase(String name);

    MovieInfoStore findByNameAndDirectorAllIgnoreCase(String name, String director);

    List<MovieInfoStore> findByDirectorOrderByName(String director);

    List<MovieInfoStore> findByDirectorOrderByNameDesc(String director);

    MovieInfoStore findTopByName(String name);
}
