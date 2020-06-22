package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.dto.ArtistsDto;
import pack.exception.AppException;
import pack.mapper.ArtistsMapper;
import pack.repo.ArtistsRepo;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ArtistsService {
    private final ArtistsRepo artistsRepo;

    private final ArtistsMapper artistsMapper;

    public void postArtists(ArtistsDto artistsDto) {
        artistsRepo.save(artistsMapper.toModel(artistsDto));
    }

    public ArtistsDto getArtistsByName(String name) {
        return artistsMapper
                .toDto(artistsRepo.findByMovieName(name).orElseThrow(()->new AppException("Artists not found")));
    }
}
