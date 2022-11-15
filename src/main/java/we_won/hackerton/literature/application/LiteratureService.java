package we_won.hackerton.literature.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we_won.hackerton.literature.application.dto.LiteratureResponse;
import we_won.hackerton.literature.domain.LiteratureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LiteratureService {

    private final LiteratureRepository literatureRepository;

    public List<LiteratureResponse> loadAll() {
        return literatureRepository.findAll()
                                   .stream()
                                   .map(LiteratureResponse::new)
                                   .collect(Collectors.toList());
    }
}
