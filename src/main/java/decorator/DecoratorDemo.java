package decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircie = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        circle.draw();
        redCircie.draw();
        redRectangle.draw();
    }
}
