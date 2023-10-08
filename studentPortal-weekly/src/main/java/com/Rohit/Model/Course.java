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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Course.class,property = "corId")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer corId;
    private String corTitle;
    private String corDescription;
    private String corDuration;

    //many to many with set of students;
   @ManyToMany
   @JoinTable(name = "studen_course", joinColumns = @JoinColumn(name = "std_id"),inverseJoinColumns = @JoinColumn(name = "cor_id"))
   Set<Student> stdSet;


}
