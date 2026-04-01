package com.example.Bookmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data               // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates no-arg constructor
@AllArgsConstructor // Generates all-arg constructor
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    // Added for recommendation
    private String mood;     // e.g., "happy", "motivated"
    private double rating;   // e.g., 4.5
}
