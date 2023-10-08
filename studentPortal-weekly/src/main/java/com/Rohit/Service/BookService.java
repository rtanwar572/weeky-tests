package com.Rohit.Service;

import com.Rohit.Model.Books;
import com.Rohit.Repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    IBookRepo iBookRepo;
    public String addBook(Books bk) {
        iBookRepo.save(bk);
        return "Books Added";
    }

    public Set<Books> getBook() {
        List<Books> bk=iBookRepo.findAll();
        Set<Books> hs=new HashSet<>(bk);
        return hs;
    }

    public String delBooks(Integer id) {
        iBookRepo.deleteById(id);
        return "Books Deleted";
    }

    public String updateBook(Books bk) {
        iBookRepo.save(bk);
        return "Books Updated";
    }
}
