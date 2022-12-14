package we_won.hackerton.user.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import we_won.hackerton.literature.infra.LiteratureRepository;
import we_won.hackerton.sentence.infra.SentenceRepository;
import we_won.hackerton.user.domain.UserLiteratureScrap;
import we_won.hackerton.user.infra.UserLiteratureScrapDAO;
import we_won.hackerton.user.infra.UserRepository;
import we_won.hackerton.user.domain.UserSentenceScrap;
import we_won.hackerton.user.infra.UserSentenceScrapDAO;
import we_won.hackerton.user.application.UserServiceImpl;
import we_won.hackerton.user.domain.UserWordScrap;
import we_won.hackerton.user.infra.UserWordScrapDAO;
import we_won.hackerton.user.domain.User_;
import we_won.hackerton.word.infra.WordRepository;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.sentence.domain.Sentence;
import we_won.hackerton.word.domain.Word;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserRepository userRepository;
    private final LiteratureRepository literatureRepository;
    private final UserLiteratureScrapDAO userLiteratureScrapDAO;
    private final UserSentenceScrapDAO userSentenceScrapDAO;
    private final SentenceRepository sentenceRepository;
    private final WordRepository wordRepository;
    private final UserWordScrapDAO userWordScrapDAO;
//    @PostMapping("/{username}")
//    public ResponseEntity<?> checkUsernameDuplicate(@PathVariable String username){
//        //System.out.println(user);
//        System.out.println(username);
//
//    }

    @PostMapping("")
    public ResponseEntity<?> insertAccount(
            @Valid @RequestBody UserFormDTO dto,
            BindingResult bindingResult
    ){

        if(bindingResult.hasErrors()){
            System.out.println("???????????????????");
            return new ResponseEntity<>("hello world~",HttpStatus.BAD_REQUEST);
        }

        boolean user = userRepository.existsByUsername(dto.getUsername());
        System.out.println(user);
        if(user){
            HashMap<String,String> result = new HashMap<>();
            result.put("status","400");
            result.put("message","???????????? ?????????????????????.");
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
        else{
            userService.saveOrUpdateAccount(dto.toEntity());
            HashMap<String,String> result = new HashMap<>();
            result.put("status","200");
            result.put("message","???????????? ???????????????!.");
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }

    }

    @GetMapping("")
    public ResponseEntity<?> viewAccount() {

        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    @GetMapping("/scrap/literature/{username}")
    public ResponseEntity<?> scrapList(@PathVariable("username") String username){
        final User_ user = userRepository.getByUsername(username);
        final List<UserLiteratureScrap> scrapList = userLiteratureScrapDAO.findAllByUser_id(user.getId());
        final List<Literature> literature_list = new ArrayList<>();
        for(int i = 0;i<scrapList.size();i++){
            literature_list.add(scrapList.get(i).getLiterature());
        }
        return new ResponseEntity<>(literature_list, HttpStatus.OK);

    }

    @PostMapping("scrap/literature")
    public ResponseEntity<?> userLiteratureScrap(@RequestBody UserScrapDTO userScrapDTO){
        final UserLiteratureScrap newScrap = new UserLiteratureScrap();
        final User_ user = userRepository.getByUsername(userScrapDTO.getUsername());
        final Literature literature = literatureRepository.getByTitle(userScrapDTO.getLiteratureTitle());
        final SuccessResponse result = new SuccessResponse<>();

        newScrap.setUser(user);
        newScrap.setLiterature(literature);

        userLiteratureScrapDAO.save(newScrap);
        result.setSuccess(true);
        result.setData("success");
        return new ResponseEntity<>(result,HttpStatus.OK);

    }
    @PostMapping("scrap/sentence") //?????? ???????????? ???
    public ResponseEntity<?> userSentenceScrap(@RequestBody UserSentenceDTO userSentenceDTO){
        sentenceRepository.save(userSentenceDTO.toEntity()); //sentence DB??? ??????
        final UserSentenceScrap newScrap = new UserSentenceScrap();
        final User_ user = userRepository.getByUsername(userSentenceDTO.getUsername());
        final Sentence sentence = sentenceRepository.getById(userSentenceDTO.getSentenceId());
        final SuccessResponse result = new SuccessResponse<>();

        newScrap.setUser(user);
        newScrap.setSentence(sentence);

        userSentenceScrapDAO.save(newScrap);
        result.setSuccess(true);
        result.setData("success");
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @GetMapping("/scrap/sentence/{username}")
    public ResponseEntity<?> scrapSentenceList(@PathVariable("username") String username){
        final User_ user = userRepository.getByUsername(username);
        final List<UserSentenceScrap> scrapList = userSentenceScrapDAO.findAllByUser_id(user.getId());
        final List<Sentence> sentences_list = new ArrayList<>();
        for(int i = 0;i<scrapList.size();i++){
            sentences_list.add(scrapList.get(i).getSentence());
        }
        return new ResponseEntity<>(sentences_list, HttpStatus.OK);

    }

    @PostMapping("scrap/word") //????????? ???????????? ???
    public ResponseEntity<?> userWordScrap(@RequestBody UserWordDTO userWordDTO){
        wordRepository.save(userWordDTO.toEntity()); //sentence DB??? ??????
        final UserWordScrap newScrap = new UserWordScrap();
        final User_ user = userRepository.getByUsername(userWordDTO.getUsername());
        final Word word = wordRepository.getById(userWordDTO.getWordId());
        final SuccessResponse result = new SuccessResponse<>();

        newScrap.setUser(user);
        newScrap.setWord(word);

        userWordScrapDAO.save(newScrap);
        result.setSuccess(true);
        result.setData("success");
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @GetMapping("/scrap/word/{username}")
    public ResponseEntity<?> scrapWordList(@PathVariable("username") String username){
        final User_ user = userRepository.getByUsername(username);
        final List<UserWordScrap> scrapList = userWordScrapDAO.findAllByUser_id(user.getId());
        final List<Word> word_list = new ArrayList<>();
        for(int i = 0;i<scrapList.size();i++){
            word_list.add(scrapList.get(i).getWord());
        }
        return new ResponseEntity<>(word_list, HttpStatus.OK);

    }

}
