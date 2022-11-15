package we_won.hackerton.vocabulary.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.vocabulary.domain.Vocabulary;

public interface VocaRepository extends JpaRepository<Vocabulary,Long> {
}
