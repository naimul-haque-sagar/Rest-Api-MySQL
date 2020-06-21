package pack.controller.restConsumer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import pack.dto.MovieDetailsDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("restapi/consumer2")
@AllArgsConstructor
public class RestApiConsumer2 {
    private final WebClient.Builder webClientBuilder;

    @GetMapping("getMovieDetailsByid/{id}")
    public Mono<MovieDetailsDto> getMovieDetailsByid(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsById";
        return webClientBuilder.build().get().uri(url+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetailsByname/{name}")
    public Mono<MovieDetailsDto> getMovieDetailsByname(@PathVariable String name){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
        return webClientBuilder.build().get().uri(url+"/"+name).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails")
    public Flux<MovieDetailsDto> getAllMovieDetails(){
        String url="http://localhost:8080/api/movieDetails/getMovieDetails";
        return webClientBuilder.build().get().uri(url).retrieve().bodyToFlux(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails2")
    public Mono<MovieDetailsDto> postMovieDetails2(@RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/postMovieDetails";
        return webClientBuilder.build()
                .post().uri(url).body(BodyInserters.fromValue(movieDetailsDto)).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails")
    public Mono<MovieDetailsDto> postMovieDetails(@RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/postMovieDetails";
        return webClientBuilder.build()
                .post().uri(url).syncBody(movieDetailsDto).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails1")
    public Mono<String> postMovieDetails1(@RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/postMovieDetails";
        return webClientBuilder.build()
                .post().uri(url).syncBody(movieDetailsDto).retrieve().bodyToMono(String.class);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public Mono<MovieDetailsDto> updateMovieDetailsById(@PathVariable Long id, @RequestBody MovieDetailsDto movieDetailsDto){
        String url="http://localhost:8080/api/movieDetails/updateMovieDetailsById";
        return webClientBuilder.build().put().uri(url+"/"+id).body(BodyInserters.fromValue(movieDetailsDto)).retrieve()
                .bodyToMono(MovieDetailsDto.class);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public Mono deleteMovieDetailsById(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/deleteMovieDetailsById";
        return webClientBuilder.build().delete().uri(url+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails1")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails1(){
        String url="http://localhost:8080/api/movieDetails/getMovieDetails";
        MovieDetailsDto[] movieDetailsDtos=webClientBuilder.build()
                .get().uri(url).retrieve().bodyToMono(MovieDetailsDto[].class).block();
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(movieDetailsDtos));
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsById(@PathVariable Long id){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsById";
        MovieDetailsDto movieDetailsDto=webClientBuilder.build()
                .get().uri(url+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class).block();
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByName(@PathVariable String name){
        String url="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
        MovieDetailsDto movieDetailsDto=webClientBuilder.build()
                .get().uri(url+"/"+name).retrieve().bodyToMono(MovieDetailsDto.class).block();
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }
}
