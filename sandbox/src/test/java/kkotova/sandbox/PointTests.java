package kkotova.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by home on 09.12.2016.
 */
public class PointTests {

  @Test
  public void TestDistance1() {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(8, 12);
    Assert.assertEquals(p1.distance(p2) , 10.0);
  }

}
