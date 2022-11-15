package we_won.hackerton.literature.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we_won.hackerton.common.exception.NotFoundException;
import we_won.hackerton.literature.application.dto.LiteratureResponse;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.literature.domain.LiteratureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LiteratureService {

    private final LiteratureRepository literatureRepository;

    public List<LiteratureResponse> loadAll() {
        return literatureRepository.findAll()
                                   .stream()
                                   .map(LiteratureResponse::new)
                                   .collect(Collectors.toList());
    }

    public LiteratureResponse loadByRandom() {
        final Literature literature = literatureRepository.findByRandom()
                                                          .orElseThrow(() -> new NotFoundException("작품이 존재하지 않습니다."));

        return new LiteratureResponse(literature);
    }
}
