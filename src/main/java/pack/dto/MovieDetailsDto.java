package pack.dto;

import lombok.Data;
import pack.model.Artists;
import pack.model.ReleasePlace;

import java.util.List;

@Data
public class MovieDetailsDto {
    private String movieName;
    private String ratings;

    private Artists artists;
    private List<ReleasePlace> releasePlaceList;
}
