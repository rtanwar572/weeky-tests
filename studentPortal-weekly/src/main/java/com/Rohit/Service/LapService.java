package com.Rohit.Service;

import com.Rohit.Model.Laptop;
import com.Rohit.Repo.ILapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LapService {
    @Autowired
    ILapRepo iLapRepo;
    public String addlaptop(Laptop lap) {
        iLapRepo.save(lap);
        return "Laptop Added";
    }

    public Set<Laptop> getlaptop() {
        List<Laptop> lp=iLapRepo.findAll();
        Set<Laptop> hs=new HashSet<>(lp);
        return hs;
    }

    public String delLaptop(Integer id) {
        iLapRepo.deleteById(id);
        return "Laptop Deleted";
    }
}
