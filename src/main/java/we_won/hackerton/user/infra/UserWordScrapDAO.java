package we_won.hackerton.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.user.domain.UserWordScrap;

import java.util.List;

public interface UserWordScrapDAO extends JpaRepository<UserWordScrap, UserWordScrapID> {
    List<UserWordScrap> findAllByUser_id(long user_id);
}
