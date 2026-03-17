package com.example.Bookmanagement.controller;

import com.example.Bookmanagement.entity.Book;
import com.example.Bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")  // Changed base path for HTML pages
public class BookController {

    @Autowired
    private BookService bookService;

    // 1️⃣ Show all books
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books"; // Thymeleaf template: books.html
    }

    // 2️⃣ Show book by ID
    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("books", book != null ? List.of(book) : List.of());
        return "books";
    }

    // 3️⃣ Show books by author
    @GetMapping("/author/{author}")
    public String getBooksByAuthor(@PathVariable String author, Model model) {
        List<Book> books = bookService.getBooksByAuthor(author);
        model.addAttribute("books", books);
        return "books";
    }

    // 4️⃣ Show books by genre
    @GetMapping("/genre/{genre}")
    public String getBooksByGenre(@PathVariable String genre, Model model) {
        List<Book> books = bookService.getBooksByGenre(genre);
        model.addAttribute("books", books);
        return "books";
    }

    // 5️⃣ Recommend books based on mood, genre, year, rating
    @GetMapping("/recommend")
    public String recommendBooks(
            @RequestParam(required = false) String mood,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double rating,
            Model model
    ) {
        List<Book> books = bookService.recommendBooks(mood, genre, year, rating);
        model.addAttribute("books", books);
        model.addAttribute("mood", mood);
        model.addAttribute("genre", genre);
        model.addAttribute("year", year);
        model.addAttribute("rating", rating);
        return "books"; // redirect to same table page
    }
}
