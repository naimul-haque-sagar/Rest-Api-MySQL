package pack.controller.restConsumer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pack.dto.MovieDetailsDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("restapi/consumer")
@AllArgsConstructor
public class RestApiConsumer {
    private final RestTemplate restTemplate;

    String POST_MOVIE_DETAILS="http://localhost:8080/api/movieDetails/postMovieDetails";
    String GET_MOVIE_DETAILS="http://localhost:8080/api/movieDetails/getMovieDetails";
    String GET_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/getMovieDetailsById";
    String GET_MOVIE_DETAILS_BY_NAME="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
    String UPDATE_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/updateMovieDetailsById";
    String DELETE_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/deleteMovieDetailsById";

    @PostMapping("postMovieDetails1")
    public ResponseEntity postMovieDetails1(@RequestBody MovieDetailsDto movieDetailsDto){
        restTemplate.postForObject(POST_MOVIE_DETAILS,movieDetailsDto,MovieDetailsDto.class);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("postMovieDetails2")
    public ResponseEntity postMovieDetails2(@RequestBody MovieDetailsDto movieDetailsDto){
        return restTemplate.postForEntity(POST_MOVIE_DETAILS,movieDetailsDto,MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails1")
    public ResponseEntity<List<Object>> getAllMovieDetails1(){
        Object[] objects=restTemplate.getForObject(GET_MOVIE_DETAILS,Object[].class);
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(objects));
    }

    @GetMapping("getMovieDetails2")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails2(){
        MovieDetailsDto[] objects=restTemplate.getForObject(GET_MOVIE_DETAILS,MovieDetailsDto[].class);
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(objects));
    }

    @GetMapping("getMovieDetails3")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails3(){
        ResponseEntity<MovieDetailsDto[]> movieDetails=restTemplate.getForEntity(GET_MOVIE_DETAILS,MovieDetailsDto[].class);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movieDetails.getBody() != null? Arrays.asList(movieDetails.getBody()):Collections.emptyList());
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsById(@PathVariable Long id){
        MovieDetailsDto movieDetailsDto=restTemplate
                .getForObject(GET_MOVIE_DETAILS_BY_ID+"/{id}",MovieDetailsDto.class,id);
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByid/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByid(@PathVariable Long id){
        ResponseEntity<MovieDetailsDto> movieDetailsDto=restTemplate
                .getForEntity(GET_MOVIE_DETAILS_BY_ID+"/{id}",MovieDetailsDto.class,id);
        return movieDetailsDto;
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByName(@PathVariable String name){
        MovieDetailsDto movieDetailsDto=restTemplate.getForObject(GET_MOVIE_DETAILS_BY_NAME+"/{name}",MovieDetailsDto.class,name);
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByname/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByname(@PathVariable String name){
        return restTemplate.getForEntity(GET_MOVIE_DETAILS_BY_NAME+"/{name}",MovieDetailsDto.class,name);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public ResponseEntity updateMovieDetailsById(@PathVariable Long id, @RequestBody MovieDetailsDto movieDetailsDto){
        restTemplate.put(UPDATE_MOVIE_DETAILS_BY_ID+"/{id}",movieDetailsDto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("updateMovieDetailsByid/{id}")
    public ResponseEntity updateMovieDetailsByid(@PathVariable Long id, @RequestBody MovieDetailsDto movieDetailsDto){
        return restTemplate
                .exchange(UPDATE_MOVIE_DETAILS_BY_ID+"/{id}", HttpMethod.PUT,new HttpEntity<>(movieDetailsDto),
                        MovieDetailsDto.class,id);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public ResponseEntity deleteMovieDetailsById(@PathVariable Long id){
        restTemplate.delete(DELETE_MOVIE_DETAILS_BY_ID+"/{id}",id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
