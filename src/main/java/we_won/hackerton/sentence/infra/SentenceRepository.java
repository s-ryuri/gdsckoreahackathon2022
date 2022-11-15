package we_won.hackerton.sentence.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.sentence.domain.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence,Long> {
}
