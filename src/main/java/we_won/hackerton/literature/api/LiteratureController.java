package we_won.hackerton.literature.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import we_won.hackerton.common.response.ApiUtils.ApiResult;
import we_won.hackerton.literature.api.dto.LiteratureResponseV1;
import we_won.hackerton.literature.application.LiteratureQueryService;
import we_won.hackerton.literature.application.dto.LiteratureResponse;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.user.api.DeleteDTO;
import we_won.hackerton.user.domain.User_;
import we_won.hackerton.user.infra.UserLiteratureScrapId;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static we_won.hackerton.common.response.ApiUtils.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/literatures")
public class LiteratureController {

    private final LiteratureQueryService literatureQueryService;

    @GetMapping("/")
    public ApiResult<?> loadAll() {
        final List<LiteratureResponse> literatureResponses = literatureQueryService.loadAll();

        final List<LiteratureResponseV1> result = literatureResponses.stream()
                                                                     .map(LiteratureResponseV1::new)
                                                                     .collect(Collectors.toList());
        return success(result);
    }

    @GetMapping("/random")
    public ApiResult<?> loadByRandom() {
        final LiteratureResponse literatureResponse = literatureQueryService.loadByRandom();

        return success(new LiteratureResponseV1(literatureResponse));
    }

    @GetMapping("/category")
    public ApiResult<?> getLiteratureById(@RequestParam(name = "category") final String category) {
        final List<LiteratureResponse> literatureResponses = literatureQueryService.loadByCategory(category);
        final List<LiteratureResponseV1> results = literatureResponses.stream()
                                                                      .map(LiteratureResponseV1::new)
                                                                      .collect(Collectors.toList());
        return success(results);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteLiterature(@RequestBody DeleteDTO deleteDTO) {
        Optional<User_> user = userRepository.findByUsername(deleteDTO.getUsername());

        Optional<Literature> literature = literatureJpaRepository.findById(deleteDTO.getId());
        UserLiteratureScrapId id = new UserLiteratureScrapId(user.get().getId(), literature.get().getId());
        userLiteratureScrapDAO.deleteById(id);
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("message", "글 스크랩 목록에서 삭제 됐습니다.");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
