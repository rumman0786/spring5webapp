package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.service.AddressRepository;
import guru.springframework.spring5webapp.service.AuthorRepository;
import guru.springframework.spring5webapp.service.BookRepository;
import guru.springframework.spring5webapp.service.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rumman
 * @since 5/14/22
 */
@Component
public class BoostrapData implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BoostrapData.class);

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BoostrapData(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository,
                        AddressRepository addressRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1231231");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Address address1 = new Address("Shamoli Housing", "Shekhertek", "Dhaka", "1207");
        Address address2 = new Address("Road 06", "Adabor", "Dhaka", "1207");

        addressRepository.save(address1);
        addressRepository.save(address2);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address1);
        addresses.add(address2);

        Publisher publisher = new Publisher("Ananta Jalil", addresses);
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);

        publisherRepository.save(publisher);
        System.out.println("Number of Addresses: " + addressRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
