package pack.mapper;

import org.mapstruct.Mapper;
import pack.dto.ReleasePlaceDto;
import pack.model.ReleasePlace;

@Mapper(componentModel = "spring")
public interface ReleasePlaceMapper {
    ReleasePlace toModel(ReleasePlaceDto releasePlaceDto);

    ReleasePlaceDto toDto(ReleasePlace byMovieName);
}
