package com.avik.spring_boot_rest_jobPost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data//creates all the reqd getters and setters
@NoArgsConstructor//creates default constructor
@AllArgsConstructor//creates a constructor that takes all the values
//@Component//required only when we test program by input values from code for which we create bean else not.
//here we dont need to inject dependency of model to create dummy inputs so not needed
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
