package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingDemoService {

    // Create logger for this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemoService.class);

    public void demonstrateAllLogLevels() {
        logger.trace("🔍 TRACE: Very detailed tracing information");
        logger.debug("🐛 DEBUG: Debug information - method entry/exit, variable values");
        logger.info("ℹ️ INFO: General application flow information");
        logger.warn("⚠️ WARN: Something unexpected happened but not an error");
        logger.error("❌ ERROR: An error occurred but application can continue");
    }

    public void logMethodExecution(String methodName, Object... params) {
        logger.debug("🚀 Method [{}] started with parameters: {}", methodName, params);
        
        try {
            // Simulate some work
            Thread.sleep(10);
            logger.trace("✅ Method [{}] processing completed successfully", methodName);
        } catch (Exception e) {
            logger.error("💥 Error in method [{}]: {}", methodName, e.getMessage(), e);
        }
        
        logger.debug("🏁 Method [{}] finished", methodName);
    }

    public void simulateBusinessLogic() {
        logger.info("📊 Starting business logic processing");
        
        // Simulate different scenarios
        logger.debug("🔄 Processing step 1: Data validation");
        logger.trace("📋 Validating input parameters...");
        
        logger.debug("🔄 Processing step 2: Database operation");
        logger.trace("🗃️ Executing database query...");
        
        // Simulate a warning condition
        if (System.currentTimeMillis() % 2 == 0) {
            logger.warn("⚠️ Performance warning: Operation took longer than expected");
        }
        
        logger.info("✅ Business logic completed successfully");
    }

    public void simulateError() {
        logger.info("🧪 Testing error logging...");
        
        try {
            // Simulate an error condition
            throw new RuntimeException("This is a simulated error for logging demo");
        } catch (Exception e) {
            logger.error("💥 Caught exception in simulateError(): {}", e.getMessage());
            logger.debug("🔍 Full stack trace for debugging", e);
        }
    }

    public void logWithDifferentFormats() {
        String userName = "john_doe";
        int userAge = 25;
        double balance = 1234.56;
        
        // Different logging patterns
        logger.info("Simple message");
        logger.info("User login: {}", userName);
        logger.info("User {} is {} years old", userName, userAge);
        logger.info("User {} has balance: ${:.2f}", userName, balance);
        
        // Structured logging
        logger.info("User details - Name: {}, Age: {}, Balance: {}", userName, userAge, balance);
    }
} 