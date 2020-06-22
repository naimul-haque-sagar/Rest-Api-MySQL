package pack.controller.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.MovieDetailsDto;
import pack.dto.MovieDetails_Dto;
import pack.exception.AppException;
import pack.model.Artists;
import pack.model.ReleasePlace;
import pack.repo.ArtistsRepo;
import pack.repo.ReleasePlaceRepo;
import pack.service.MovieDetailsService;

import java.util.List;

@RestController
@RequestMapping("api/movieDetails")
@AllArgsConstructor
public class EndPointForMovieDetails {
    private final MovieDetailsService movieDetailsService;

    private final ArtistsRepo artistsRepo;

    private final ReleasePlaceRepo releasePlaceRepo;

    @PostMapping("postMovieDetails")
    public ResponseEntity saveMovieDetails(@RequestBody MovieDetails_Dto movieDetails_dto){
        Artists artists=artistsRepo.findByMovieName(movieDetails_dto.getMovieName())
                .orElseThrow(()->new AppException("No artists found"));
        List<ReleasePlace> releasePlaceList=releasePlaceRepo.findAll();

        MovieDetailsDto movieDetailsDto=new MovieDetailsDto();
        movieDetailsDto.setMovieName(movieDetails_dto.getMovieName());
        movieDetailsDto.setRatings(movieDetails_dto.getRatings());
        movieDetailsDto.setArtists(artists);
        movieDetailsDto.setReleasePlaceList(releasePlaceList);

        movieDetailsService.saveMovieDetails(movieDetailsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getMovieDetails")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.getAllMovieDetails());
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.findById(id));
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public MovieDetailsDto findByName(@PathVariable String name){
        return movieDetailsService.findByName(name);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public ResponseEntity updateMovieDetails(@RequestBody MovieDetails_Dto movieDetails_Dto, @PathVariable Long id){
        movieDetailsService.updateMovieDetails(movieDetails_Dto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public ResponseEntity deleteMovieDetails(@PathVariable Long id){
        movieDetailsService.deleteMovieDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
