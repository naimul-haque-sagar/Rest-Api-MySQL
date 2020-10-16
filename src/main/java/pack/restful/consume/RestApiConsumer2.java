package pack.restful.consume;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import pack.dto.MovieDetailsDto;
import pack.dto.MovieDetails_Dto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("restapi/consumer2")
@AllArgsConstructor
public class RestApiConsumer2 {
    private final WebClient.Builder webClientBuilder;

    static String GET_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/getMovieDetailsById";
    static String GET_MOVIE_DETAILS_BY_NAME="http://localhost:8080/api/movieDetails/getMovieDetailsByName";
    static String GET_MOVIE_DETAILS="http://localhost:8080/api/movieDetails/getMovieDetails";
    static String DELETE_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/deleteMovieDetailsById";
    static String UPDATE_MOVIE_DETAILS_BY_ID="http://localhost:8080/api/movieDetails/updateMovieDetailsById";
    static String POST_MOVIE_DETAILS="http://localhost:8080/api/movieDetails/postMovieDetails";

    @GetMapping("getMovieDetailsByid/{id}")
    public Mono<MovieDetailsDto> getMovieDetailsByid(@PathVariable Long id){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS_BY_ID+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetailsByname/{name}")
    public Mono<MovieDetailsDto> getMovieDetailsByname(@PathVariable String name){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS_BY_NAME+"/"+name).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails")
    public Flux<MovieDetailsDto> getAllMovieDetails(){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS).retrieve().bodyToFlux(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails2")
    public Mono<MovieDetailsDto> postMovieDetails2(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).body(BodyInserters.fromValue(movieDetails_Dto)).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails")
    public Mono<MovieDetailsDto> postMovieDetails(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).syncBody(movieDetails_Dto).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails1")
    public Mono<String> postMovieDetails1(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).syncBody(movieDetails_Dto).retrieve().bodyToMono(String.class);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public Mono<MovieDetailsDto> updateMovieDetailsById(@PathVariable Long id, @RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build().put().uri(UPDATE_MOVIE_DETAILS_BY_ID+"/"+id).body(BodyInserters.fromValue(movieDetails_Dto)).retrieve()
                .bodyToMono(MovieDetailsDto.class);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public Mono deleteMovieDetailsById(@PathVariable Long id){
        return webClientBuilder.build().delete().uri(DELETE_MOVIE_DETAILS_BY_ID+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails1")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails1(){
        MovieDetailsDto[] movieDetailsDtos=webClientBuilder.build()
                .get().uri(GET_MOVIE_DETAILS).retrieve().bodyToMono(MovieDetailsDto[].class).block();
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(movieDetailsDtos));
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsById(@PathVariable Long id){
        MovieDetailsDto movieDetailsDto=webClientBuilder.build()
                .get().uri(GET_MOVIE_DETAILS_BY_ID+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class).block();
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByName(@PathVariable String name){
        MovieDetailsDto movieDetailsDto=webClientBuilder.build()
                .get().uri(GET_MOVIE_DETAILS_BY_NAME+"/"+name).retrieve().bodyToMono(MovieDetailsDto.class).block();
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsDto);
    }
}
