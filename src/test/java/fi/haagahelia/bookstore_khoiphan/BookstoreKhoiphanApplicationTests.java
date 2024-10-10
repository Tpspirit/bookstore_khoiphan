package fi.haagahelia.bookstore_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore_khoiphan.web.BookController;

@SpringBootTest
class BookstoreKhoiphanApplicationTests {

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() throws Exception{
		assertThat(bookController).isNotNull();
	}

}
