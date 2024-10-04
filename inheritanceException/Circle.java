package inheritanceException;

public class Circle extends shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override method
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

