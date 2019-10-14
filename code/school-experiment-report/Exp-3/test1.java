

public class test1{
    public static void main(String[] args) {
        System.out.println("-- Test1 : Shape C&S calculate --");
        // test Circle
        Circle circle = new Circle(4);
        System.out.println("\nThe circle's perimeter is : " + circle.calcPerimeter());
        System.out.println("The circle's area is : " + circle.calcArea());
        // test Triangle
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("\nThe triangle's perimeter is : " + triangle.calcPerimeter());
        System.out.println("The triangle's area is : " + triangle.calcArea());
        // test Rectangle
        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println("\nThe rectangle's perimeter is : " + rectangle.calcPerimeter());
        System.out.println("The rectangle's area is : " + rectangle.calcArea());
        // test Square
        Square square = new Square(7);
        System.out.println("\nThe square's perimeter is : " + square.calcPerimeter());
        System.out.println("The square's area is : " + square.calcArea());
    }
}

/**
 * Shape2D
 */
abstract class Shape2D {
    // C
    public abstract double calcPerimeter();
    // S
    public abstract double calcArea();
}

/**
 * Circle
 */
class Circle extends Shape2D {
    double r;
    final double PI = 3.14;
    public Circle() {
        r = 0;
    }
    public Circle(double r) {
        this.r = r;
    }
    public double calcPerimeter() {
        return 2 * r * PI;
    }
    public double calcArea() {
        return PI * r * r;
    }
}

/**
 * Triangle
 */
class Triangle extends Shape2D {
    double a;
    double b;
    double c;
    public Triangle() {
        a = b = c = 0;
    }
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double calcPerimeter() {
        return a + b + c;
    }
    public double calcArea() {
        return 0.25 * Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a));
    }
}

/**
 * Rectangle
 */
class Rectangle extends Shape2D {
    double l;
    double w;
    public Rectangle() {
        l = w = 0;
    }
    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }
    public double calcPerimeter() {
        return 2 * (l + w);
    }
    public double calcArea() {
        return l * w;
    }
}

/**
 * Square
 */
class Square extends Rectangle {
    double length;
    public Square() {
        super();
        length = 0;
    }
    public Square(double length) {
        super(length, length);
        this.length = length;
    }
}
