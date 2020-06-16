package pack.restClient;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pack.dto.MovieDetailsDto;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("restClient/consume")
@AllArgsConstructor
public class RestClientForMovieDetails {
    private final RestTemplate restTemplate;

    @PostMapping("postMovieDetails1")
    public ResponseEntity postMovieDetails1(@RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/postMovieDetails";
        restTemplate.postForObject(url,movieDetailsDto,MovieDetailsDto.class);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("postMovieDetails2")
    public ResponseEntity postMovieDetails2(@RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/postMovieDetails";
        return restTemplate.postForEntity(url,movieDetailsDto,MovieDetailsDto.class);
    }

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
                .getForObject(url+"/{id}",MovieDetailsDto.class,id);
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByid/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByid(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsById";
        ResponseEntity<MovieDetailsDto> movieDetailsDto=restTemplate
                .getForEntity(url+"/{id}",MovieDetailsDto.class,id);
        return movieDetailsDto;
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByName(@PathVariable String name){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
        MovieDetailsDto movieDetailsDto=restTemplate.getForObject(url+"/{name}",MovieDetailsDto.class,name);
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByname/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByname(@PathVariable String name){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
        return restTemplate.getForEntity(url+"/{name}",MovieDetailsDto.class,name);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public ResponseEntity updateMovieDetailsById(@PathVariable Long id, @RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/updateMovieDetailsById";
        restTemplate.put(url+"/{id}",movieDetailsDto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("updateMovieDetailsByid/{id}")
    public ResponseEntity updateMovieDetailsByid(@PathVariable Long id, @RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/updateMovieDetailsById";
        return restTemplate
                .exchange(url+"/{id}", HttpMethod.PUT,new HttpEntity<>(movieDetailsDto),
                        MovieDetailsDto.class,id);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public ResponseEntity deleteMovieDetailsById(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/deleteMovieDetailsById";
        restTemplate.delete(url+"/{id}",id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
