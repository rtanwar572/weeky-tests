package com.Rohit.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Student.class,property = "stuId")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StuId;
    private String stuName;
    private Integer stuAge;
    private String stuContact;
    private String stuDepart;

    //one to one with address;
    @OneToOne
    @JoinColumn(name = "fk-add")
    Address address;

    //oneto many with courseSet
    @OneToMany
    @JoinColumn(name = "fk-student")
    Set<Course> courseList;

}
