package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pack.dto.ReleasePlaceDto;
import pack.exception.AppException;
import pack.mapper.ReleasePlaceMapper;
import pack.repo.ReleasePlaceRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReleasePlaceService {
    private final ReleasePlaceRepo releasePlaceRepo;

    private final ReleasePlaceMapper releasePlaceMapper;

    public void postReleasePlace(ReleasePlaceDto releasePlaceDto) {
        releasePlaceRepo.save(releasePlaceMapper.toModel(releasePlaceDto));
    }

    public List<ReleasePlaceDto> getReleasePlaceByName(String name) {
        return releasePlaceRepo.findByMovieName(name).stream().map(releasePlaceMapper::toDto).collect(Collectors.toList());
    }
}
