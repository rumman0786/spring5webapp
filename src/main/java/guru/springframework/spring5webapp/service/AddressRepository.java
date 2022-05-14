package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rumman
 * @since 5/15/22
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
