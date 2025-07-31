package com.example.solid;

// This file serves as the entry point of the application. It creates instances of the classes demonstrating the SOLID principles and calls their methods.

public class MainSingle {
    public static void main(String[] args) {
        // Demonstrating Single Responsibility Principle
        SingleResponsibility singleResponsibility = new SingleResponsibility();
        singleResponsibility.generateReport();
        singleResponsibility.sendReport("NC");
        singleResponsibility.totalReport(20);
        singleResponsibility.setReportContent("hello i am tushar");
        String num=singleResponsibility.generateReport();
        System.out.println(num);

    }
}