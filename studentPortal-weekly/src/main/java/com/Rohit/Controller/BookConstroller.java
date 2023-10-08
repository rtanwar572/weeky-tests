package com.Rohit.Controller;

import com.Rohit.Model.Books;
import com.Rohit.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookConstroller {
    @Autowired
    BookService bookService;

    @PostMapping
    public String addBook(@RequestBody Books bk){
        return bookService.addBook(bk);
    }
    @GetMapping
    public Set<Books> getBook(){
        return bookService.getBook();
    }
    @PutMapping
    public  String updateBook(@RequestBody Books bk){
        return bookService.updateBook(bk);
    }

    @DeleteMapping("/id/{id}")
    public String DelBooks(@PathVariable Integer id){
        return bookService.delBooks(id);
    }
}
