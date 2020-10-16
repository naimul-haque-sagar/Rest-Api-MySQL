package pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.MovieInfoStore;

public interface MovieInfoStoreRepo extends JpaRepository<MovieInfoStore,Integer> {
    MovieInfoStore findByDirectorAndProducer(String director, String producer);

    MovieInfoStore findDistinctMovieInfoStoreByName(String name);

    MovieInfoStore findDistinctMovieInfoStoreByNameOrDirector(String name, String director);


}
