package pack.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.MovieDetailsDto;
import pack.model.MovieDetails;
import pack.service.MovieDetailsService;

import java.util.List;

@RestController
@RequestMapping("api/movieDetails")
@AllArgsConstructor
public class EndPointForMovieDetails {
    private final MovieDetailsService movieDetailsService;

    @GetMapping
    public List<MovieDetailsDto> getAllMovieDetails(){
        return movieDetailsService.getAllMovieDetails();
    }

    @PostMapping
    public ResponseEntity saveMovieDetails(@RequestBody MovieDetailsDto movieDetailsDto){
        movieDetailsService.saveMovieDetails(movieDetailsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public MovieDetailsDto findById(@PathVariable Long id){
        return movieDetailsService.findById(id);
    }

    @GetMapping("{name}")
    public MovieDetailsDto findByName(@PathVariable String name){
        return movieDetailsService.findByName(name);
    }

    @PutMapping("{id}")
    public ResponseEntity updateMovieDetails(@RequestBody MovieDetailsDto movieDetailsDto, @PathVariable Long id){
        movieDetailsService.updateMovieDetails(movieDetailsDto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteMovieDetails(@PathVariable Long id){
        movieDetailsService.deleteMovieDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
