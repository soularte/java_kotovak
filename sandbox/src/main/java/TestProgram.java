public class TestProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user Alex");

    double l = 5;
            System.out.println("Площать квадрата со стороной " + l + " = " + area(l));

    double a = 4;
    double b = 6;

    System.out.println("Площать прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String smb) {
    System.out.println("Hello, " + smb + "!");

  }

  public static double area(double len){
    return len * len;
  }

  public static double area(double a, double b){
    return a * b;
  }
}