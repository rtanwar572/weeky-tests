package com.Rohit.Controller;

import com.Rohit.Model.Laptop;
import com.Rohit.Service.LapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/laptop")
public class LapController {
    @Autowired
    LapService lapService;

    @PostMapping
    public String addlaptop(@RequestBody Laptop lap){
        return lapService.addlaptop(lap);
    }
    @GetMapping
    Set<Laptop> getLaptop(){
        return lapService.getlaptop();
    }
    @DeleteMapping("/id/{id}")
    public String DelLaptop(@PathVariable Integer id){
        return lapService.delLaptop(id);
    }
}
