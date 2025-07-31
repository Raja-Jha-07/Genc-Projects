package com.example.solid;

// Interface for shape
interface Shape {
    double area();
}

// Circle class implementing Shape interface
class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class implementing Shape interface
class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
class Triangle implements Shape{
  private double height;
  private double breadth;
  public Triangle(double height,double breadth){
    this.breadth=breadth;
    this.height=height;

  }
  @Override
  public double area(){
    return 0.5*height*breadth;
  }
}
// AreaCalculator class that uses the Open/Closed Principle
class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            System.out.println(shape.area());
            total += shape.area();
        }
        return total;
    }
}