package pack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pack.dto.MovieDetailsDto;
import pack.model.MovieDetails;

@Mapper(componentModel = "spring")
public interface MovieDetailsMapper {
    MovieDetailsDto toDto(MovieDetails movieDetails);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "created", expression = "java(java.time.Instant.now())")
    @Mapping(target = "lastUpdated",ignore = true)
    MovieDetails toModel(MovieDetailsDto movieDetailsDto);
}
