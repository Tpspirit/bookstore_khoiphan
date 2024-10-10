package fi.haagahelia.bookstore_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import fi.haagahelia.bookstore_khoiphan.domain.Book;
import fi.haagahelia.bookstore_khoiphan.domain.BookRepository;
import fi.haagahelia.bookstore_khoiphan.domain.Category;
import fi.haagahelia.bookstore_khoiphan.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewBookTest() throws Exception{

        Category cate1 = new Category("Fantasy");
        categoryRepository.save(cate1);


        Book book = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699", 1997, 20, cate1);


        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBookTest() throws Exception{

        Category cate1 = new Category("Fantasy");
        categoryRepository.save(cate1);

        Book book = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699", 1997, 20, cate1);

        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();

        Long id = book.getId();

        bookRepository.deleteById(id);

        List<Book> books = (List<Book>) bookRepository.findAll();

        assertThat(books).hasSize(2);
     
    }

    @Test
    public void searchBookTest() throws Exception{
        Category cate1 = new Category("Fantasy");
        categoryRepository.save(cate1);

        Book book = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699", 1997, 20, cate1);

        bookRepository.save(book);
        
        Book books = bookRepository.findByTitle("Harry Potter and the Philosopher's Stone");

        assertThat(books).isNotNull();
        assertThat(books.getTitle()).isEqualTo("Harry Potter and the Philosopher's Stone");


    }
}
