package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.model.MovieInfoStore;
import pack.repo.MovieInfoStoreRepo;

@Service
@AllArgsConstructor
public class MovieInfoStoreService {
    private final MovieInfoStoreRepo movieInfoStoreRepo;

    public void postEntity(MovieInfoStore movieInfoStore) {
        movieInfoStoreRepo.save(movieInfoStore);
    }

    public MovieInfoStore findByDirectorAndProducer(String director, String producer) {
        return movieInfoStoreRepo.findByDirectorAndProducer(director,producer);
    }

    public MovieInfoStore findDistinctByName(String name) {
        return movieInfoStoreRepo.findDistinctMovieInfoStoreByName(name);
    }

    public MovieInfoStore findDistinctByNameOrDirector(String name, String director) {
        return movieInfoStoreRepo.findDistinctMovieInfoStoreByNameOrDirector(name,director);
    }
}
