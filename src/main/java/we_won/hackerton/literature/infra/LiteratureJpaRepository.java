package we_won.hackerton.literature.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.literature.domain.LiteratureRepository;

public interface LiteratureJpaRepository extends LiteratureRepository, JpaRepository<Literature,Long> {

}
