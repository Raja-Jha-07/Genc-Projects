package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // Add logger
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMetrics bookMetrics;

    @PostConstruct
    public void init() {
        logger.info("🚀 BookService initialized - setting up metrics");
        // Initialize the current book count on startup
        int currentCount = bookRepository.findAll().size();
        bookMetrics.setCurrentBookCount(currentCount);
        logger.debug("📊 Initial book count set to: {}", currentCount);
    }

    public Book saveBook(Book book) {
        logger.info("💾 Attempting to save book: {}", book.getTitle());
        logger.debug("📝 Book details - Title: '{}', Author: '{}'", book.getTitle(), book.getAuthor());
        
        try {
            Book savedBook = bookRepository.save(book);
            
            // Increment metrics counter when a new book is created
            if (book.getId() == null) {
                logger.debug("🆕 New book created, incrementing metrics");
                bookMetrics.incrementBookCreated();
                bookMetrics.incrementCurrentBookCount();
            } else {
                logger.debug("📝 Existing book updated");
            }
            
            logger.info("✅ Book saved successfully with ID: {}", savedBook.getId());
            return savedBook;
            
        } catch (Exception e) {
            logger.error("❌ Failed to save book '{}': {}", book.getTitle(), e.getMessage(), e);
            throw e;
        }
    }
    
    public List<Book> getAllBooks() {
        logger.debug("📚 Retrieving all books from database");
        
        try {
            List<Book> books = bookRepository.findAll();
            logger.info("📖 Retrieved {} books from database", books.size());
            logger.trace("📋 Book list: {}", books);
            return books;
            
        } catch (Exception e) {
            logger.error("❌ Failed to retrieve books: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Optional<Book> getBookById(Long id) {
        logger.debug("🔍 Searching for book with ID: {}", id);
        
        if (id == null || id <= 0) {
            logger.warn("⚠️ Invalid book ID provided: {}", id);
            return Optional.empty();
        }
        
        try {
            Optional<Book> book = bookRepository.findById(id);
            
            if (book.isPresent()) {
                logger.info("✅ Found book: '{}'", book.get().getTitle());
                logger.trace("📖 Book details: {}", book.get());
            } else {
                logger.warn("❓ No book found with ID: {}", id);
            }
            
            return book;
            
        } catch (Exception e) {
            logger.error("❌ Error while searching for book with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public void deleteBook(Long id) {
        logger.info("🗑️ Attempting to delete book with ID: {}", id);
        
        try {
            Optional<Book> book = getBookById(id);
            
            if (book.isPresent()) {
                String bookTitle = book.get().getTitle();
                bookRepository.deleteById(id);
                
                // Update metrics
                bookMetrics.incrementBookDeleted();
                bookMetrics.decrementCurrentBookCount();
                
                logger.info("✅ Book '{}' deleted successfully", bookTitle);
                logger.debug("📊 Updated metrics after deletion");
            } else {
                logger.warn("⚠️ Attempted to delete non-existent book with ID: {}", id);
            }
            
        } catch (Exception e) {
            logger.error("❌ Failed to delete book with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}