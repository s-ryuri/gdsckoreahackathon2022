package we_won.hackerton.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.user.domain.UserLiteratureScrap;

import java.util.List;

public interface UserLiteratureScrapDAO extends JpaRepository<UserLiteratureScrap, UserLiteratureScrapId> {
    List<UserLiteratureScrap> findAllByUser_id(long user_id);
}
