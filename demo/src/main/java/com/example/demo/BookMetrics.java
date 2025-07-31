package com.example.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BookMetrics {

    @Autowired
    private MeterRegistry meterRegistry;

    private Counter bookCreatedCounter;
    private Counter bookDeletedCounter;
    private final AtomicInteger currentBookCount = new AtomicInteger(0);

    @PostConstruct
    public void init() {
        // Counter for books created
        bookCreatedCounter = Counter.builder("books.created")
            .description("Total number of books created")
            .register(meterRegistry);

        // Counter for books deleted
        bookDeletedCounter = Counter.builder("books.deleted")
            .description("Total number of books deleted")
            .register(meterRegistry);

        // Gauge for current book count - using AtomicInteger to avoid circular dependency
        Gauge.builder("books.total", currentBookCount, AtomicInteger::get)
            .description("Current total number of books")
            .register(meterRegistry);
    }

    public void incrementBookCreated() {
        bookCreatedCounter.increment();
        currentBookCount.incrementAndGet();
    }

    public void incrementBookDeleted() {
        bookDeletedCounter.increment();
        currentBookCount.decrementAndGet();
    }

    public void incrementCurrentBookCount() {
        currentBookCount.incrementAndGet();
    }

    public void decrementCurrentBookCount() {
        currentBookCount.decrementAndGet();
    }

    public void setCurrentBookCount(int count) {
        currentBookCount.set(count);
    }
} 