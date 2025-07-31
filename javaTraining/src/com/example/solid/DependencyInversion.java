package com.example.solid;

// High-level module
public class DependencyInversion {
    // private MessageService messegeService;
    // public DependencyInversion(MessageService messegeService){
    //         this.messegeService=messegeService;
    // }
    public static void main(String[] args) {
        // Create a new instance of the EmailService
        MessageService emailService = new EmailService();
        MessageService smsService=new SmsService();
        // Create a new instance of the MessageProcessor with the email service
        MessageProcessor messageProcessor = new MessageProcessor(emailService);
        MessageProcessor smsProcessor=new MessageProcessor(smsService);
        
        // Send a message
        messageProcessor.sendMessage("Hello, Dependency Inversion!");
        smsProcessor.sendMessage("hey its sms messege");
    }
}


// Abstraction for message services
interface MessageService {
    void sendMessage(String message);
}

// Low-level module
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}
class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sms sent: " + message);
    }
}
// High-level module that depends on the abstraction
class MessageProcessor {
    private final MessageService messageService;

    // Constructor Injection
    public MessageProcessor(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendMessage(String message) {
        messageService.sendMessage(message);
    }
}