class Shape {
    public double calculateArea(){
        return 0.0;
    }
}
class Circle extends Shape{
    private double radius;
    public Circle (double radius){
        this.radius=radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI*radius*radius;// Override with specific implementation for circle
    }
}
public class newjava{
    public static void main(String[] args){
        Shape genericShape=new Shape();
        Circle circle=new Circle(7);
        // Calls the overridden method in circle
        System.out.println("Area of the circle:"+circle.calculateArea());
        //Calls the original method in Shape(no overriding)
        System.out.println("Area of the generic shape: "+ genericShape.calculateArea());

    }
}  // We can use this override technique to change some function functionality using
