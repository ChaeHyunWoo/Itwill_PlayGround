package practice;

abstract class Shape {
	
    public abstract void draw();
    
}

class Line extends Shape {
    @Override
    public void draw(){
        System.out.println("Line");
    }
}

class Circle extends Shape {
    @Override
    public void draw(){
        System.out.println("Circle");
    }

    public static void main(String args[]) {
    	Shape wrong = new Shape();      // ¿¡·¯!
    	Shape shape = new Line();       // ok
    	Shape shape2 = new Circle();    // ok
		}
    
}