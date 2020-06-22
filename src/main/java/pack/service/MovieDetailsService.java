package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.dto.MovieDetailsDto;
import pack.dto.MovieDetails_Dto;
import pack.exception.AppException;
import pack.mapper.MovieDetailsMapper;
import pack.model.MovieDetails;
import pack.repo.MovieDetailsRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieDetailsService {
    private final MovieDetailsRepo movieDetailsRepo;

    private final MovieDetailsMapper movieDetailsMapper;

    public List<MovieDetailsDto> getAllMovieDetails() {
        return movieDetailsRepo.findAll().stream()
                .map(movieDetailsMapper::toDto).collect(Collectors.toList());
    }

    public void saveMovieDetails(MovieDetailsDto movieDetailsDto) {
        movieDetailsRepo.save(movieDetailsMapper.toModel(movieDetailsDto));
    }

    public MovieDetailsDto findById(Long id) {
        return movieDetailsMapper.toDto(movieDetailsRepo.findById(id)
        .orElseThrow(()->new AppException("Error occurred finding movie details by id")));
    }

    public MovieDetailsDto findByName(String name) {
        return movieDetailsMapper.toDto(movieDetailsRepo.findByMovieName(name)
        .orElseThrow(()->new AppException("Error occurred finding movie details by name")));
    }

    public void updateMovieDetails(MovieDetails_Dto movieDetails_Dto, Long id) {
        MovieDetails response=movieDetailsRepo.findById(id).orElseThrow(()->new AppException("Didn't find any movie details"));
        response.setRatings(movieDetails_Dto.getRatings());
        response.setLastUpdated(java.time.Instant.now());

        movieDetailsRepo.save(response);
    }

    public void deleteMovieDetails(Long id) {
        movieDetailsRepo.deleteById(id);
    }
}
