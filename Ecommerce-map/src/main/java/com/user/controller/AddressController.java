package com.user.controller;

import com.user.entities.Address;
import com.user.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    AddressService addressService;


    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable Integer addressId) {
        return addressService.getAddressById(addressId);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddressById(@PathVariable Integer addressId) {
        addressService.deleteAddressById(addressId);
    }
}

