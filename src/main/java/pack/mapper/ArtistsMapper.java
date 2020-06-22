package pack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pack.dto.ArtistsDto;
import pack.model.Artists;

@Mapper(componentModel = "spring")
public interface ArtistsMapper {
    Artists toModel(ArtistsDto artistsDto);

    ArtistsDto toDto(Artists artists);
}
