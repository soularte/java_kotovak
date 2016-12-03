package kkotova.sandbox;

public class TestProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user Alex");

    Square s = new Square(5);

            System.out.println("Площать квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);

    System.out.println("Площать прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
  }

  public static void hello(String smb) {
    System.out.println("Hello, " + smb + "!");

  }


  public static double area(Rectangle r){
    return r.a * r.b;
  }
}