package we_won.hackerton.user.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import we_won.hackerton.user.infra.UserWordScrapID;
import we_won.hackerton.word.domain.Word;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "user_word_scrap")
@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(UserWordScrapID.class)
public class UserWordScrap {
    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User_ user;

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "word_id")
    private Word word;
}
