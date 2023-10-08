package com.Rohit.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private Integer bookPrice;

    //many to one with student;
    @ManyToOne
    @JoinColumn(name = "fk-std")
    Student std;


}
