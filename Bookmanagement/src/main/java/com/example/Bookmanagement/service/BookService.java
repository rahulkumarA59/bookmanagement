package com.example.Bookmanagement.service;

import com.example.Bookmanagement.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Updated to include mood and rating
        books.add(new Book(1, "Atomic Habits", "James Clear", "Self-help", 2018, "motivated", 4.8));
        books.add(new Book(2, "1984", "George Orwell", "Fiction", 1949, "thoughtful", 4.6));
        books.add(new Book(3, "The Alchemist", "Paulo Coelho", "Fiction", 1988, "inspired", 4.7));
        books.add(new Book(4, "Clean Code", "Robert C. Martin", "Programming", 2008, "focused", 4.5));
        books.add(new Book(5, "Think Like a Monk", "Jay Shetty", "Self-help", 2020, "calm", 4.9));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Recommend books based on mood, genre, year, rating
    public List<Book> recommendBooks(String mood, String genre, Integer year, Double rating) {
        return books.stream()
                .filter(book -> mood == null || (book.getMood() != null && book.getMood().equalsIgnoreCase(mood)))
                .filter(book -> genre == null || book.getGenre().equalsIgnoreCase(genre))
                .filter(book -> year == null || book.getPublicationYear() == year)
                .filter(book -> rating == null || book.getRating() >= rating)
                .collect(Collectors.toList());
    }
}
