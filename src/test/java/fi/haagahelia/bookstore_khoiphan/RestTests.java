 package fi.haagahelia.bookstore_khoiphan;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.Arrays;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.hamcrest.Matchers.hasSize;
// import static org.hamcrest.Matchers.is;
// import static org.mockito.Mockito.when;

// import org.springframework.security.test.context.support.WithMockUser;


// import fi.haagahelia.bookstore_khoiphan.domain.Book;
// import fi.haagahelia.bookstore_khoiphan.domain.BookRepository;
// import fi.haagahelia.bookstore_khoiphan.domain.Category;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class RestTests {

//     @Autowired
//     private BookRepository bookRepository;

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     @WithMockUser(username = "user", roles = {"USER"})
//     public void getAllBookJson() throws Exception{

//         Book book1 = new Book("Ernest Hemmingway", "A Farewell to Arms", "1232323-21L", 1929, 12, new Category("History"));

//         Book book2 = new Book("George Orwell", "Animal Farm", "2212343-5", 1945,13,new Category("Politic"));


//         this.mockMvc.perform(get("/books"))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$",hasSize(2)))
//             .andExpect(jsonPath("$.author", is("Ernest Hemmingway")))
//             .andExpect(jsonPath("$.author", is("George Orwell")));
//     }
// }


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RestTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetBooks() throws Exception {
        this.mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].author").value("Ernest Hemmingway"))
                .andExpect(jsonPath("$[1].author").value("George Orwell"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetBookById() throws Exception{
        this.mockMvc.perform(get("/book/2"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.author").value("George Orwell"));
    }

}
