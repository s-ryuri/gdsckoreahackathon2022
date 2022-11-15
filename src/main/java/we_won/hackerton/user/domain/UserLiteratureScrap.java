package we_won.hackerton.user.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.user.infra.UserLiteratureScrapId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "UserLiteratureScrap")
@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(UserLiteratureScrapId.class)
public class UserLiteratureScrap {

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User_ user;

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "literature_id")
    private Literature literature;


}
