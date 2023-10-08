package com.Rohit.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lapid;
    private String lapName;
    private String lapBrand;
    private Integer lapPrice;
    //onto one with student
    @OneToOne
    @JoinColumn(name = "fk-std")
    Student std;
}
