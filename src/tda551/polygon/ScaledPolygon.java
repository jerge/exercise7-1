package tda551.polygon;

import java.awt.*;
import java.util.List;

class ScaledPolygon extends AbstractPolygon {
  private AbstractPolygon base;
  double xFactor, yFactor;

  ScaledPolygon(AbstractPolygon base, double xFactor, double yFactor) {
    this.base = base;
    this.xFactor = xFactor;
    this.yFactor = yFactor;
  }

  @Override
  public IDrawablePolygon translate(int x, int y) {
    this.base = (AbstractPolygon) base.translate(x, y);
    return this;
  }

  @Override
  public IDrawablePolygon rotate(double radians) {
    this.base = (AbstractPolygon) base.rotate(radians);
    return this;
  }

  @Override
  public IDrawablePolygon scale(double x, double y) {
    this.xFactor *= x;
    this.yFactor *= y;
    return this;
  }

  protected void manipulatePoint(Point center, Point point) {
    double newX = (point.x - center.x) * xFactor + center.x;
    double newY = (point.y - center.y) * yFactor + center.y;
    point.x = (int) newX;
    point.y = (int) newY;
  }

  public List<Point> getPoints() {
    return getPointsWithBase(base);
  }


  @Override
  public Point getCenterPoint() {
    return base.getCenterPoint();
  }
}
