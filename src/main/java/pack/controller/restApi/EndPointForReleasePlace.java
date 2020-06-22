package pack.controller.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.ArtistsDto;
import pack.dto.ReleasePlaceDto;
import pack.service.ReleasePlaceService;

@RestController
@RequestMapping("api/releasePlace")
@AllArgsConstructor
public class EndPointForReleasePlace {
    private final ReleasePlaceService releasePlaceService;

    @PostMapping("postReleasePlace")
    public ResponseEntity postReleasePlace(@RequestBody ReleasePlaceDto releasePlaceDto){
        releasePlaceService.postReleasePlace(releasePlaceDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getReleasePlaceByName/{name}")
    public ResponseEntity<ReleasePlaceDto> getReleasePlaceByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(releasePlaceService.getReleasePlaceByName(name));
    }
}
