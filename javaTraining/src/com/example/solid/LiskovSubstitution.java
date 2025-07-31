package com.example.solid;

/**
 * Liskov Substitution Principle (LSP)
 * 
 * The Liskov Substitution Principle states that objects of a superclass
 * should be replaceable with objects of a subclass without affecting
 * the correctness of the program. This principle is about ensuring
 * that a derived class can stand in for its base class.
 * 
 * This class demonstrates the Liskov Substitution Principle by providing
 * an example of a base class and a derived class that adheres to this
 * principle.
 */

// Base class
class Bird {
    public void fly() {
        System.out.println("I can fly!");
    }
}

// Derived class
class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying!");
    }
}
class Peacock extends Bird{
    @Override
    public void fly(){
        System.out.println("Peacock can fly");
    }
}

// Another derived class
class Ostrich extends Bird {
    @Override
    public void fly() {
        System.out.println("Ostriches cannot fly.");
    }
}