package fi.haagahelia.bookstore_khoiphan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {
    
    @GetMapping("/index")
    public String index(){
        return "Hello this is my Bookstore";
    }
}
