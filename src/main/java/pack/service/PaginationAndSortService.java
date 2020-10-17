package pack.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pack.dto.ArtistsDto;
import pack.mapper.ArtistsMapper;
import pack.model.Artists;
import pack.repo.ArtistsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaginationAndSortService {
    private final ArtistsRepo artistsRepo;

    private final ArtistsMapper artistsMapper;

    public List<ArtistsDto> getPagingData(int pageNo, int pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Artists> page=artistsRepo.findAll(pageable);
        if(page.hasContent()){
            return page.getContent().stream().map(artistsMapper::toDto).collect(Collectors.toList());
        }else{
            return new ArrayList<ArtistsDto>();
        }
    }
}
