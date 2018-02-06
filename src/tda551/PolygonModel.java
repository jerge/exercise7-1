package tda551;

import tda551.polygon.IDrawablePolygon;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PolygonModel extends JComponent implements Runnable {
    private List<IDrawablePolygon> polygons = new ArrayList<>();

    private boolean direction = true;
    private int ticker = 0;
    private boolean stop = false;

    public synchronized void addPolygon( IDrawablePolygon p ) {
        System.out.println( "Adding a polygon." );
        polygons.add( p );
    }

    public synchronized void removePolygon() {
        if ( !polygons.isEmpty() ) {
            System.out.println( "Removing a polygon." );
            polygons.remove( 0 );
        } else {
            JOptionPane.showMessageDialog( this, "This is very bad!" );
        }
    }

    public void paint( Graphics g ) {
        for ( IDrawablePolygon polygon : polygons ) {
            polygon.paint( g );
        }
    }

    private void translate( int x, int y ) {
        for ( IDrawablePolygon p : polygons ) {
            p.translate( x, y );
        }
    }

    private synchronized void update() {
        ticker++;
        int value = direction ? 10 : -10;
        translate( value, value );
        notifyListeners();
        if ( ticker > 10 ) {
            direction = !direction;
            ticker = 0;
        }
    }

    private void notifyListeners() {
        for ( AnimateListener l : listeners )
            l.actOnUpdate();
    }

    public void run() {
        animate();
    }

    private void animate() {
        try {
            while ( !stop ) {
                Thread.sleep( 500 );
                update();
            }
        } catch ( InterruptedException e ) {
        }
    }

    private List<AnimateListener> listeners = new ArrayList<>();

    public void addListener( AnimateListener l ) {
        listeners.add( l );
    }
}

