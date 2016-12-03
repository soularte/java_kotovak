package kkotova.sandbox;

public class DistanseFunc {

  public static void main(String[] args) {
    Point p1 = new Point(2, 4);
    System.out.println("Первая точка " + p1.x + ", " + p1.y);
    Point p2 = new Point(8, 12);
    System.out.println("Вторая точка " + p2.x + ", " + p2.y);
    System.out.println("Расстояние между двумя точками " + distance(p1, p2));
//    Point r = new Point(10, 20);
// //System.out.println("Расстояние между двумя точками " + r.distance());
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));

  }
}
