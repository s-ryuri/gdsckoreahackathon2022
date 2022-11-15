package we_won.hackerton.sentence.api;

import lombok.Getter;
import lombok.Setter;
import we_won.hackerton.sentence.domain.Sentence;

//db에 저장할 때
@Setter
@Getter
public class SentenceFormDTO {

    private long sentenceId;
    private String sentence;
    private String title;
    //private String writer;

    public Sentence toEntity(){
        return Sentence.builder()
                .id(sentenceId)
                .sentence(this.sentence)
                .title(this.title)
                .build();
                //.writer(this.writer)


    }
}
