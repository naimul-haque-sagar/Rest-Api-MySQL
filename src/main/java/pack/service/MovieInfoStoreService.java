package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.model.MovieInfoStore;
import pack.repo.MovieInfoStoreRepo;

import java.util.List;

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

    public MovieInfoStore findByIgnoreCase(String name) {
        return movieInfoStoreRepo.findByNameIgnoreCase(name);
    }

    public MovieInfoStore findByAllIgnoreCase(String name, String director) {
        return movieInfoStoreRepo.findByNameAndDirectorAllIgnoreCase(name,director);
    }

    public List<MovieInfoStore> findByDirectorOrderByName(String director) {
        return movieInfoStoreRepo.findByDirectorOrderByName(director);
    }

    public List<MovieInfoStore> findByDirectorOrderByNameDesc(String director) {
        return movieInfoStoreRepo.findByDirectorOrderByNameDesc(director);
    }

    public MovieInfoStore findTop(String name) {
        return movieInfoStoreRepo.findTopByName(name);
    }
}
