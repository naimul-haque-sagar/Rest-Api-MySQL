package pack.restful.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.ReleasePlaceDto;
import pack.service.ReleasePlaceService;

import java.util.List;

@RestController
@RequestMapping("api/releasePlace")
@AllArgsConstructor
@CrossOrigin("*")
public class EndPointForReleasePlace {
    private final ReleasePlaceService releasePlaceService;

    @PostMapping("postReleasePlace")
    public ResponseEntity postReleasePlace(@RequestBody ReleasePlaceDto releasePlaceDto){
        System.out.println(releasePlaceDto);
        releasePlaceService.postReleasePlace(releasePlaceDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getReleasePlaceByName/{name}")
    public ResponseEntity<List<ReleasePlaceDto>> getReleasePlaceByName(@PathVariable String name){
        System.out.println(name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(releasePlaceService.getReleasePlaceByName(name));
    }
}
