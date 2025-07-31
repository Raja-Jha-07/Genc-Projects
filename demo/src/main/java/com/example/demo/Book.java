
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is required and cannot be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;
    
    @NotBlank(message = "Author is required and cannot be empty")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    private String author;

    // Default constructor for JPA
    public Book() {}

    // Constructor for testing
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}