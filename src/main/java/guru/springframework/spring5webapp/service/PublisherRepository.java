package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rumman
 * @since 5/15/22
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
