package dev.javafeatures.j8.functional.patterns;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

enum Shapes {
  Circle, Square, Rectangle
}

interface Shape {
    default double getArea()    { return -1; }
    default double getPerimeter()   { return -1;}
    void draw();
}

class Circle implements Shape   {

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class Square implements Shape   {

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Rectangle implements Shape    {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class ShapeFactory {
    private static final Map<Shapes, Supplier<Shape>> map = new EnumMap<>(Shapes.class);

    static  {
        map.put(Shapes.Circle, Circle::new);
        map.put(Shapes.Square, Square::new);
        map.put(Shapes.Rectangle, Rectangle::new);
    }

    static Shape getShape(Shapes shapeType)   {
        /*
        switch (shapeType)  {
            case Circle -> new Circle();
            case Square -> new Square();
            case Rectangle -> new Rectangle();
        }
        return null;*/

        return map.get(shapeType).get();
    }

    public static void main(String[] args){
        Shape circle = ShapeFactory.getShape(Shapes.Circle);
        circle.draw();

        Shape square = ShapeFactory.getShape(Shapes.Square);
        square.draw();

        Shape rectangle = ShapeFactory.getShape(Shapes.Rectangle);
        rectangle.draw();
    }
}
