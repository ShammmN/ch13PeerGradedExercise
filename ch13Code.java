/*
 * Name: Chapter 13 Peer Review Exercise 
 * Purpose: Modify the GeometricObject class to implement the Comparable interface, and define a static max method in 
 * the GeometricObject class for finding the larger of two GeometricObject objects.
 * Programmer: Sham Nemer
 * Date: 11 / 20 / 2025
 */

public class ch13Code {
    // Main method
    public static void main(String[] args) {

        // Create two comparable circles
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(4);

        // Use the max class to determine the larger circle by radius
        Circle biggerCircle = (Circle) max.findLarger(c1, c2);

        // Display the max circle
        System.out.println("The max circles radius is " + biggerCircle.getRadius());
        System.out.println(biggerCircle);

        // Create two Rectangle with different widths and heights
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(3, 6);

        // Use the maz class to determine the larger rectangle by their areas
        Rectangle biggerRectangle = (Rectangle) max.findLarger(r1, r2);

        // Display max rectangle
        System.out.println("The max rectangle area is " + biggerRectangle.getArea());
        System.out.println(biggerRectangle);
    }
}

/*
GeometricObject Class
Abstract class that defines common properties and methods for the circles and rectangles.
*/
abstract class GeometricObject implements Comparable<GeometricObject> {
    // setting the default properties
    private String color = "white";   
    private boolean filled = false;   
    private java.util.Date dateCreated;  

    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    // Accessor and mutator methods
    /** Return color */
    public String getColor() {
        return color;
    }
    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }
    /** Return filled. Since filled is boolean,
     *  the get method is named isFilled */
    public boolean isFilled() {
        return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // Abstract methods that all shapes must implement
    public abstract double getArea();
    public abstract double getPerimeter();

    // Using the compareTo method to compare areas of two GeometricObjects
    @Override
    public int compareTo(GeometricObject other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    // Using the max method to return the larger of two GeometricObjects
    public static GeometricObject max(GeometricObject a, GeometricObject b) {
        return (a.compareTo(b) >= 0) ? a : b;
    }

    // Displaying the description of this geometric object
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

/*
Circle Class
The Circle class extends GeometricObject and provides formulas for area and perimeter and information about the circle.
*/
class Circle extends GeometricObject {
    // The radius of the circle field
    private double radius; 

    // Constructor that sets radius
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    // Constructor that sets radius and any inherited fields
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Accessor for radius
    public double getRadius() { 
        return radius; 
    }

    // Calculates the area of the circle
    @Override
    public double getArea() { 
        return Math.PI * radius * radius; 
    }

    // Calculates the circumference of the circle
    @Override
    public double getPerimeter() { 
        return 2 * Math.PI * radius; 
    }

    // Displaying the description of this circle
    @Override
    public String toString() {
        return "[Circle] radius = " + radius + super.toString();
    }
}

/*
Rectangle Class
The Rectangle class extends GeometricObject and provides formulas for area and perimeter and information about the rectangle.
*/
class Rectangle extends GeometricObject {
    // The width and height of the rectangle fields
    private double width;   
    private double height;  

    // Constructor for width and height
    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    // Constructor with inherited fields 
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Calculates the rectangles area
    @Override
    public double getArea() { 
        return width * height; 
    }

    // Calculates the rectangles perimeter
    @Override
    public double getPerimeter() { 
        return 2 * (width + height); 
    }

    // Displaying the description of this rectangle
    @Override
    public String toString() {
        return "[Rectangle] area = " + width * height + super.toString();
    }
}

/*
SimpleMax Class
Class that contains a static method to find the larger of two GeometricObject objects based on their area.
*/
class max {
    // Static method to find the larger GeometricObject
    public static GeometricObject findLarger(GeometricObject a, GeometricObject b) {
        return (a.getArea() >= b.getArea()) ? a : b;
    }
}