package com.Rohit.Model.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commId;
    private String commBody;
    private LocalDateTime commCreationTime;
    @ManyToOne
    @JoinColumn(name = "user-Id")
    User user;

    @ManyToOne
    @JoinColumn(name = "post-Id")
    Post post;

}
