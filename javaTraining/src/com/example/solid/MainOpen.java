package com.example.solid;

// This file serves as the entry point of the application. It creates instances of the classes demonstrating the SOLID principles and calls their methods.

public class MainOpen {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[] {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(5,4)
        };

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total Area: " + calculator.totalArea(shapes));
    }
}