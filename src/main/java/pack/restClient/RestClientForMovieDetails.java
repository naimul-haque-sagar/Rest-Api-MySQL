package pack.restClient;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pack.dto.MovieDetailsDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("restClient/consume")
@AllArgsConstructor
public class RestClientForMovieDetails {
    private final RestTemplate restTemplate;

    @GetMapping("getMovieDetails1")
    public ResponseEntity<List<Object>> getAllMovieDetails1(){
        String url="http://localhost:8080/api/movieDetails/getMovieDetails";
        Object[] objects=restTemplate.getForObject(url,Object[].class);
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(objects));
    }

    @GetMapping("getMovieDetails2")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails2(){
        String url="http://localhost:8080/api/movieDetails/getMovieDetails";
        MovieDetailsDto[] objects=restTemplate.getForObject(url,MovieDetailsDto[].class);
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(objects));
    }

    @GetMapping("getMovieDetails3")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails3(){
        String url="http://localhost:8080/api/movieDetails/getMovieDetails";
        ResponseEntity<MovieDetailsDto[]> movieDetails=restTemplate.getForEntity(url,MovieDetailsDto[].class);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movieDetails.getBody() != null? Arrays.asList(movieDetails.getBody()):Collections.emptyList());
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsById(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsById";
        MovieDetailsDto movieDetailsDto=restTemplate
                .getForObject(url+"/{id}",MovieDetailsDto.class,Long.toString(id));
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByid/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByid(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsById";
        ResponseEntity<MovieDetailsDto> movieDetailsDto=restTemplate
                .getForEntity(url+"/{id}",MovieDetailsDto.class,Long.toString(id));
        return movieDetailsDto;
    }
}
