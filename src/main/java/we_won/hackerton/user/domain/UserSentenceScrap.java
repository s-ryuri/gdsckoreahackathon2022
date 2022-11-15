package we_won.hackerton.user.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import we_won.hackerton.sentence.domain.Sentence;
import we_won.hackerton.user.infra.UserSentenceScrapID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "UserSentenceScrap")
@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(UserSentenceScrapID.class)
public class UserSentenceScrap {

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User_ user;

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sentence_id")
    private Sentence sentence;


}
