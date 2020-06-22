package pack.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "movie_details_table")
@NoArgsConstructor
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant created;
    private Instant lastUpdated;
    private String movieName;
    private String ratings;

    @OneToOne(cascade = CascadeType.ALL)
    private Artists artists;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReleasePlace> releasePlaceList;
}
