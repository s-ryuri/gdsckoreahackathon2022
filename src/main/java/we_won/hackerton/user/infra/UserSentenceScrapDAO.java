package we_won.hackerton.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.user.domain.UserSentenceScrap;

import java.util.List;

public interface UserSentenceScrapDAO extends JpaRepository<UserSentenceScrap, UserSentenceScrapID> {
    List<UserSentenceScrap> findAllByUser_id(long user_id);

}
