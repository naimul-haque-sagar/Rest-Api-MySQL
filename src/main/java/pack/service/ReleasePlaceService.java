package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.dto.ReleasePlaceDto;
import pack.exception.AppException;
import pack.mapper.ReleasePlaceMapper;
import pack.repo.ReleasePlaceRepo;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ReleasePlaceService {
    private final ReleasePlaceRepo releasePlaceRepo;

    private final ReleasePlaceMapper releasePlaceMapper;

    public void postReleasePlace(ReleasePlaceDto releasePlaceDto) {
        releasePlaceRepo.save(releasePlaceMapper.toModel(releasePlaceDto));
    }

    public ReleasePlaceDto getReleasePlaceByName(String name) {
        return releasePlaceMapper
                .toDto(releasePlaceRepo.findByMovieName(name).orElseThrow(()->new AppException("ReleasePlace not fond")));
    }
}
