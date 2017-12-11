package tda551.polygon;

import java.awt.*;

public interface IPolygon {
  IPolygon translate(int x, int y);

  IPolygon rotate(double radians);

  IPolygon scale(double x, double y);

  Point getCenterPoint();
}
