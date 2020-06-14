package pack.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "movie_details_table")
@Data
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant created;
    private Instant lastUpdated;
    private String name;
    private String ratings;
    private String details;
    private String director;
}
