package we_won.hackerton.literature.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import we_won.hackerton.literature.domain.Literature;
import we_won.hackerton.literature.domain.LiteratureRepository;

import java.util.Optional;

public interface LiteratureJpaRepository extends LiteratureRepository, JpaRepository<Literature,Long> {
    @Override
    @Query(value = "SELECT * FROM literature order by RAND() limit 1", nativeQuery = true)
    Optional<Literature> findByRandom();
}
