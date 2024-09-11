package fi.haagahelia.bookstore_khoiphan;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore_khoiphan.domain.Book;
import fi.haagahelia.bookstore_khoiphan.domain.BookRepository;

@SpringBootApplication
public class BookstoreKhoiphanApplication {

	public static final Logger log = LoggerFactory.getLogger(BookstoreKhoiphanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreKhoiphanApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			log.info("Save some books.");
			repository.save(new Book("Ernest Hemmingway", "A Farewell to Arms", 1232323-21L, 1929));
			repository.save(new Book("George Orwell", "Animal Farm", 2212343-5L, 1945));

			log.info("Fetch all books.");
			for(Book book : repository.findAll()){
				log.info(book.toString());
			}

		};
	}

}
