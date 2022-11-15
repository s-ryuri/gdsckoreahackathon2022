package we_won.hackerton.literature.domain;

import java.util.List;
import java.util.Optional;

public interface LiteratureRepository {

    List<Literature> findAllByCategory(Category category);
    List<Literature> findAll();

    Optional<Literature> findById();

    Optional<Literature> findByTitle(String title);

    Optional<Literature> findByRandom();


}
