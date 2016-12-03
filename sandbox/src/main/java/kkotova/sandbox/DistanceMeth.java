package kkotova.sandbox;

public class DistanceMeth {

  public static void main(String[] args) {
    Point p1 = new Point(2, 4);
    System.out.println("Первая точка " + p1.x + ", " + p1.y);
    Point p2 = new Point(8, 12);
    System.out.println("Вторая точка " + p2.x + ", " + p2.y);
    p1.x = p2.x - p1.x;
    p1.y = p2.y - p1.y;
    System.out.println("Расстояние между двумя точками " + p1.distance());
  }

}
