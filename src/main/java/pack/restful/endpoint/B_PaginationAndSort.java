package pack.restful.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.ArtistsDto;
import pack.service.PaginationAndSortService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
@CrossOrigin("*")
public class B_PaginationAndSort {
    private final PaginationAndSortService paginationAndSortService;

    @GetMapping("getBy/{pageNo}/{pageSize}/{sortBy}")
    public ResponseEntity<List<ArtistsDto>> getPagingData(@PathVariable int pageNo, @PathVariable int pageSize, @PathVariable String sortBy){
        return ResponseEntity.status(HttpStatus.OK).body(paginationAndSortService.getPagingData(pageNo,pageSize,sortBy));
    }

    
}
