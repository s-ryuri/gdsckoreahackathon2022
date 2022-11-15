package we_won.hackerton.sentence.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we_won.hackerton.literature.infra.LiteratureJpaRepository;
import we_won.hackerton.sentence.domain.Sentence;
import we_won.hackerton.sentence.infra.SentenceRepository;
import we_won.hackerton.user.infra.UserRepository;
import we_won.hackerton.user.infra.UserSentenceScrapDAO;
import we_won.hackerton.user.api.DeleteDTO;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.user.infra.UserSentenceScrapID;
import we_won.hackerton.user.domain.User_;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sentence")
public class SentenceController {


    private final LiteratureJpaRepository literatureJpaRepository;
    private final UserSentenceScrapDAO userSentenceScrapDAO;
    private final UserRepository userRepository;
    private final SentenceRepository sentenceRepository;

    @GetMapping("/{title}")
    public ResponseEntity<?> getLiteratureInfo(@PathVariable("title") String title){
        Literature literature = literatureJpaRepository.findByTitle(title);
        return new ResponseEntity<>(literature,HttpStatus.CREATED);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteLiterature(@RequestBody DeleteDTO deleteDTO){
        Optional<User_> user = userRepository.findByUsername(deleteDTO.getUsername());

        Optional<Sentence> sentence = sentenceRepository.findById(deleteDTO.getId());
        UserSentenceScrapID id = new UserSentenceScrapID(user.get().getId(),sentence.get().getId());
        userSentenceScrapDAO.deleteById(id);
        HashMap<String,String> result = new HashMap<>();
        result.put("status","200");
        result.put("message","문장 스크랩 목록에서 삭제 됐습니다.");
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
