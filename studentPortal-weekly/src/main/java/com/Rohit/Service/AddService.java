package com.Rohit.Service;

import com.Rohit.Model.Address;
import com.Rohit.Repo.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddService {
    @Autowired
    IAddRepo iAddRepo;
    public String addAddress(Address add) {
        iAddRepo.save(add);
//       System.out.print(getAddress());
        return "Address Added";
    }

    public String updateLanMarkById(Long id,String lanMark) {
        Address add=iAddRepo.findById(id).orElseThrow();
        add.setLandMark(lanMark);
        return "Address updated";
    }

    public String delAddress(Long id) {
        iAddRepo.deleteById(id);
        return "Address Deleted";
    }

    public Set<Address> getAddresses() {
        List<Address> add= iAddRepo.findAll();
        Set<Address> hs=new HashSet<>(add);
        return hs;

    }
}
