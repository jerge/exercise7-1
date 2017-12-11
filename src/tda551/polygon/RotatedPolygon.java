package tda551.polygon;

import java.awt.*;
import java.util.List;

class RotatedPolygon extends AbstractPolygon {
  private AbstractPolygon base;
  private double radians;

  RotatedPolygon(AbstractPolygon base, double radians) {
    this.base = base;
    this.radians = radians;
  }

  @Override
  public IDrawablePolygon translate(int x, int y) {
    this.base = (AbstractPolygon) base.translate(x, y);
    return this;
  }

  @Override
  public IDrawablePolygon rotate(double radians) {
    this.radians += radians;
    return this;
  }

  @Override
  public IDrawablePolygon scale(double x, double y) {
    this.base = (AbstractPolygon) base.scale(x, y);
    return this;
  }

  @Override
  public List<Point> getPoints() {
    return getPointsWithBase(base);
  }

  @Override
  protected void manipulatePoint(Point center, Point p) {
    rotatePoint(center, p, this.radians);
  }

  private static void rotatePoint(Point center, Point point, double alpha) {
    double newX = center.x + (point.x - center.x) * Math.cos(alpha) - (point.y - center.y) * Math.sin(alpha);
    double newY = center.y + (point.x - center.x) * Math.sin(alpha) + (point.y - center.y) * Math.cos(alpha);
    point.x = (int) newX;
    point.y = (int) newY;
  }

  @Override
  public Point getCenterPoint() {
    return base.getCenterPoint();
  }
}
