package inheritanceException;

public class Square extends shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Override method
    @Override
    public double area() {
        return  side * side;
    }
}

