package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rumman
 * @since 5/14/22
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
