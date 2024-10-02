package fi.haagahelia.bookstore_khoiphan.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookstore_khoiphan.domain.Book;
import fi.haagahelia.bookstore_khoiphan.domain.BookRepository;
import fi.haagahelia.bookstore_khoiphan.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryrepository;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping({"/", "/booklist"})
    public String booklist(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    // REST - get all books
    @GetMapping("/books")
    public @ResponseBody List<Book> books(){
        return (List<Book>) repository.findAll();
    }

    // REST - get book by id
    @GetMapping("/book/{id}")
    public @ResponseBody Optional<Book> bookById(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categorys", categoryrepository.findAll());
        return "addbook";
    }

    @PostMapping("/add")
    public String add(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categorys", categoryrepository.findAll());
        return "editbook";
    }
}
