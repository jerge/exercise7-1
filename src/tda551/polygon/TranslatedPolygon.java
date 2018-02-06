package tda551.polygon;

import java.awt.*;
import java.util.List;

class TranslatedPolygon extends AbstractPolygon {
    private AbstractPolygon base;
    int xMove;
    int yMove;

    TranslatedPolygon( AbstractPolygon polygonToTranslate, int x, int y ) {
        this.base = polygonToTranslate;
        this.xMove = x;
        this.yMove = y;
    }

    @Override
    public IDrawablePolygon translate( int x, int y ) {
        //return new TranslatedPolygon(base, x+xMove, y+yMove);
        this.xMove += x;
        this.yMove += y;
        return this;
    }

    @Override
    public IDrawablePolygon rotate( double radians ) {
        this.base = (AbstractPolygon) base.rotate( radians );
        return this;
    }

    @Override
    public IDrawablePolygon scale( double x, double y ) {
        this.base = (AbstractPolygon) base.scale( x, y );
        return this;
    }

    @Override
    public List<Point> getPoints() {
        // the points from base are already defensively copied
        return getPointsWithBase( base );
    }

    @Override
    protected void manipulatePoint( Point center, Point p ) {
        p.x += this.xMove;
        p.y += this.yMove;
    }

    @Override
    public Point getCenterPoint() {
        // the centerpoint from base is already defensively copied
        Point baseCenter = base.getCenterPoint();
        baseCenter.x += xMove;
        baseCenter.y += yMove;
        return baseCenter;
    }
}
