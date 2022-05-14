package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rumman
 * @since 5/14/22
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
