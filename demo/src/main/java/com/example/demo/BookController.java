package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@RestController
public class BookController {

    // Add logger for this controller
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private LoggingDemoService loggingDemoService;

    // Simple hello endpoint
    @GetMapping("/hello")
    public String hello() {
        logger.info("👋 Hello endpoint accessed");
        return "Hello World Spring boot initialize!";
    }

    // DevTools Hot Reload Demo Endpoint
    @GetMapping("/devtools-demo")
    public Map<String, Object> devToolsDemo() {
        logger.info("🔧 DevTools demo endpoint accessed");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "🚀 DevTools Auto-Restart is Amazing!");
        response.put("timestamp", java.time.LocalDateTime.now());
        response.put("version", "2.0");
        response.put("features", List.of("Auto Restart", "Live Reload", "Property Defaults", "Fast Development"));
        response.put("status", "HOT RELOAD WORKING!");
        return response;
    }

    // ============================
    // LOGGING DEMO ENDPOINTS
    // ============================

    @GetMapping("/logging/demo")
    public Map<String, Object> loggingDemo() {
        logger.info("🧪 Logging demo endpoint accessed");
        
        // Demonstrate all log levels
        loggingDemoService.demonstrateAllLogLevels();
        loggingDemoService.simulateBusinessLogic();
        loggingDemoService.logWithDifferentFormats();
        loggingDemoService.logMethodExecution("loggingDemo", "param1", "param2");
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Check console for different log levels!");
        response.put("logLevels", List.of("TRACE", "DEBUG", "INFO", "WARN", "ERROR"));
        response.put("timestamp", java.time.LocalDateTime.now());
        
        logger.info("✅ Logging demo completed");
        return response;
    }

    @GetMapping("/logging/error-demo")
    public Map<String, Object> errorLoggingDemo() {
        logger.info("💥 Error logging demo endpoint accessed");
        
        // Demonstrate error logging
        loggingDemoService.simulateError();
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Error logging demonstrated - check console!");
        response.put("note", "Error was caught and logged, application continues running");
        response.put("timestamp", java.time.LocalDateTime.now());
        
        return response;
    }

    // ============================
    // BOOK MANAGEMENT ENDPOINTS  
    // ============================

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        logger.info("📚 GET /api/books - Retrieving all books");
        List<Book> books = bookService.getAllBooks();
        logger.debug("📊 Returning {} books", books.size());
        return ResponseEntity.ok(books);
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        logger.info("📝 POST /api/books - Creating new book: '{}'", book.getTitle());
        try {
            Book savedBook = bookService.saveBook(book);
            logger.info("✅ Book created successfully with ID: {}", savedBook.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            logger.error("❌ Failed to create book: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        logger.info("🔍 GET /api/books/{} - Retrieving book by ID", id);
        
        if (id == null || id <= 0) {
            logger.warn("⚠️ Invalid book ID provided: {}", id);
            return ResponseEntity.badRequest().build();
        }
        
        Optional<Book> book = bookService.getBookById(id);
        return book.map(b -> {
            logger.debug("✅ Book found and returned: '{}'", b.getTitle());
            return ResponseEntity.ok(b);
        }).orElseGet(() -> {
            logger.warn("❓ Book not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        });
    }

    @PutMapping("/api/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
        logger.info("✏️ PUT /api/books/{} - Updating book", id);
        
        if (id == null || id <= 0) {
            logger.warn("⚠️ Invalid book ID for update: {}", id);
            return ResponseEntity.badRequest().build();
        }
        
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            String oldTitle = book.getTitle();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            Book updatedBook = bookService.saveBook(book);
            logger.info("✅ Book updated: '{}' -> '{}'", oldTitle, updatedBook.getTitle());
            return ResponseEntity.ok(updatedBook);
        }
        logger.warn("❓ Attempted to update non-existent book with ID: {}", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        logger.info("🗑️ DELETE /api/books/{} - Deleting book", id);
        
        if (id == null || id <= 0) {
            logger.warn("⚠️ Invalid book ID for deletion: {}", id);
            return ResponseEntity.badRequest().build();
        }
        
        if (bookService.getBookById(id).isPresent()) {
            bookService.deleteBook(id);
            logger.info("✅ Book deletion completed for ID: {}", id);
            return ResponseEntity.noContent().build();
        }
        logger.warn("❓ Attempted to delete non-existent book with ID: {}", id);
        return ResponseEntity.notFound().build();
    }
} 