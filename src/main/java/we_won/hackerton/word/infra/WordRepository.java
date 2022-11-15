package we_won.hackerton.word.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.word.domain.Word;

public interface WordRepository extends JpaRepository<Word,Long> {
}
