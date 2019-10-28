

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Shape painted cost --");
        // create Circle object
        Circle circle = new Circle(3);
        System.out.println(circle.isBorderPainted());
        circle.paintBorder();
        System.out.println(circle.isBorderPainted());
        // create Triangle object
        Triangle triangle = new Triangle(3, 4, 5);
        // create Rectangle object
        Rectangle rectangle = new Rectangle(5, 6);
        // create Cost object
        CostCalculator cost = new CostCalculator(1, 2);
        System.out.println(cost.calculate(circle));
        System.out.println(cost.calculate(triangle));
        System.out.println(cost.calculate(rectangle));
    }
}

// BorderColorable interface
interface BorderColorable {
    public void paintBorder();          // print what shape border has been painted.
    public boolean isBorderPainted();   // if border was painted.
}

// SolidColorable interface
interface SolidColorable {
    public void paintShape();           // print what shape has been painted.
    public boolean isShapePainted();    // if shape was painted.
}

abstract class Shape2D {
    public abstract double getPerimeter();
    public abstract double getArea();
}

class Circle extends Shape2D implements BorderColorable {

    private double r;
    private boolean flag = false;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * r * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public void paintBorder() {
        System.out.println("Paint the Circle's border!");
        flag = true;
    }

    @Override
    public boolean isBorderPainted() {
        return flag;
    }
}

class Triangle extends Shape2D implements SolidColorable {
    
    private double a,b,c;
    private boolean flag = false;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        return 0.25 * Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a));
    }

    @Override
    public void paintShape() {
        System.out.println("Paint the Triangle's solid!");
        flag = true;
    }

    @Override
    public boolean isShapePainted() {
        return flag;
    }
}

class Rectangle extends Shape2D implements BorderColorable, SolidColorable {
    
    private double l;
    private double w;
    private boolean flagBorder = false;
    private boolean flagSolid = false;

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    @Override
    public double getPerimeter() {
        return 2 * (l + w);
    }

    @Override
    public double getArea() {
        return l * w;
    }

    @Override
    public void paintBorder() {
        System.out.println("Paint the Rectangle's border!");
        flagBorder = true;
    }

    @Override
    public boolean isBorderPainted() {
        return flagBorder;
    }

    @Override
    public void paintShape() {
        System.out.println("Paint the Rectangle's solid!");
        flagSolid = true;
    }

    @Override
    public boolean isShapePainted() {
        return flagSolid;
    }
}

class Square extends Rectangle {

    public Square(double l) {
        super(l, l);
    }
}

class CostCalculator {

    private double borderCost;
    private double solidCost;
    
    public CostCalculator(double borderCost, double solidCost) {
        this.borderCost = borderCost;
        this.solidCost = solidCost;
    }

    public double calculate(Shape2D shape) {
        String shapeName = shape.getClass().getName();
        if (shapeName.equals("Circle")) {
            // if is Circle
            return shape.getPerimeter() * borderCost;
        } else if (shapeName.equals("Triangle")) {
            // if is Triangle
            return shape.getArea() * solidCost;
        } else if (shapeName.equals("Rectangle")) {
            // if is Rectangle
            return shape.getPerimeter() * borderCost + shape.getArea() * solidCost;
        } else {
            return 0;
        }
    }
}