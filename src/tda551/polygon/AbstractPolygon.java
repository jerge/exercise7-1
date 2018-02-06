package tda551.polygon;

import javax.swing.*;
import java.awt.*;
import java.util.List;

abstract class AbstractPolygon extends JComponent implements IDrawablePolygon {
    public void paint( Graphics g ) {
        List<Point> corners = getPoints();
        // first and last point should be the same
        corners.add( corners.get( 0 ) );
        Point from = null;
        for ( Point to : corners ) {
            if ( from != null ) {
                g.drawLine( from.x, from.y, to.x, to.y );
            }
            from = to;
        }
    }

    protected abstract void manipulatePoint( Point center, Point p );

    protected List<Point> getPointsWithBase( AbstractPolygon base ) {
        List<Point> points = base.getPoints();
        Point center = getCenterPoint();
        for ( Point p : points ) {
            manipulatePoint( center, p );
        }
        return points;
    }

    protected abstract List<Point> getPoints();

}
