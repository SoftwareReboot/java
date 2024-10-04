package encap;

public class rectangle {
    // Attributes
    private double width;
    private double height;

    // Constructor
    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getters
    public double getWidth() {
       return width;
    }

    public double getHeight() {
        return height;
    }
    

    // Methods to implement
    public void setDimensions(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

  
  public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

