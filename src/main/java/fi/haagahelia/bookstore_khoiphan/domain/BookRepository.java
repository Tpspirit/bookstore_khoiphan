package fi.haagahelia.bookstore_khoiphan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    Book findByTitle(String title);
}
