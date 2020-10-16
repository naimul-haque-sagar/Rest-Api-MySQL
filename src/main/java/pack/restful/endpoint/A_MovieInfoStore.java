package pack.restful.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.model.MovieInfoStore;
import pack.service.MovieInfoStoreService;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin("*")
public class A_MovieInfoStore {
    private MovieInfoStoreService movieInfoStoreService;

    @PostMapping("/store")
    public ResponseEntity postEntity(@RequestBody MovieInfoStore movieInfoStore){
        movieInfoStoreService.postEntity(movieInfoStore);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("findBy/{director}/{producer}")
    public ResponseEntity<MovieInfoStore> findByDirectorAndProducer(@PathVariable String director,@PathVariable String producer){
        return ResponseEntity.status(HttpStatus.OK).body(movieInfoStoreService.findByDirectorAndProducer(director,producer));
    }

    @GetMapping("findDistinct/{name}")
    public ResponseEntity<MovieInfoStore> findDistinctByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(movieInfoStoreService.findDistinctByName(name));
    }

    @GetMapping("findDistinct/{name}/{director}")
    public ResponseEntity<MovieInfoStore> findDistinctByNameOrDirector(@PathVariable String name, @PathVariable String director){
        return ResponseEntity.status(HttpStatus.OK).body(movieInfoStoreService.findDistinctByNameOrDirector(name,director));
    }

}
