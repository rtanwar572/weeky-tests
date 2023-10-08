package com.Rohit.Controller;

import com.Rohit.Model.Address;
import com.Rohit.Service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddController {
    @Autowired
    AddService addService;

    @PostMapping
    public String addAddress(@RequestBody Address add){
        return addService.addAddress(add);
    }
    @GetMapping
    public Set<Address> getAddresses(){
        return addService.getAddresses();
    }
    @DeleteMapping("/id/{id}")
    public String delAddress(@PathVariable Long id){
        return addService.delAddress(id);
    }
    @PutMapping("/id/{id}/landmark/{lanMark}")
    public String updateAdd(@PathVariable Long id,@PathVariable String lanMark){
        return addService.updateLanMarkById(id,lanMark);
    }
}
