package we_won.hackerton.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import we_won.hackerton.user.domain.User_;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User_,Long> {
    Optional<User_> findByUsername(String login_id);
    User_ getByUsername(String username);
    Optional<User_> findById(long id);

    boolean existsByUsername(String username);
}
