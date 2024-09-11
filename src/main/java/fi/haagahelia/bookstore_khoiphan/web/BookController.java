package fi.haagahelia.bookstore_khoiphan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.bookstore_khoiphan.domain.Book;
import fi.haagahelia.bookstore_khoiphan.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;
    
    @GetMapping({"/", "/booklist"})
    public String booklist(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
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
        return "editbook";
    }
}
