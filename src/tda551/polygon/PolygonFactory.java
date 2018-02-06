package tda551.polygon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class PolygonFactory {
    private static int[][] rectangleOffsets = {{-20, -10}, {20, -10}, {20, 10}, {-20, 10}};

    public static IDrawablePolygon createRectangle( int x, int y ) {
        return createPolygon( x, y, rectangleOffsets );
    }

    private static int[][] triangleOffsets = {{0, -10}, {10, 10}, {-10, 10}};

    public static IDrawablePolygon createTriangle( int x, int y ) {
        return createPolygon( x, y, triangleOffsets );
    }

    private static int[][] squareOffsets = {{-10, -10}, {10, -10}, {10, 10}, {-10, 10}};

    public static IDrawablePolygon createSquare( int x, int y ) {
        return createPolygon( x, y, squareOffsets );
    }

    private static IDrawablePolygon createPolygon( int x, int y, int[][] offsets ) {
        return new BasePolygon( basePoints( offsets ) ).translate( x, y );
    }

    private static List<Point> basePoints( int[][] offsets ) {
        List<Point> points = new ArrayList<>();
        for ( int[] xy : offsets ) {
            points.add( new Point( xy[0], xy[1] ) );
        }
        return points;
    }
}
