package tda551;

import tda551.polygon.PolygonFactory;

public class Creator extends Thread {
    private final int WAIT = 10;
    private boolean stop;
    private PolygonModel model;

    public Creator( PolygonModel model ) {
        this.model = model;
        stop = false;
    }

    public void run() {
        while ( !stop ) {
            int x = (int) ( Math.random() * 250 );
            int y = (int) ( Math.random() * 250 );
            model.addPolygon( PolygonFactory.createRectangle( x, y ) );
            try {
                Thread.sleep( (int) ( Math.random() * WAIT ) );
            } catch ( InterruptedException e ) {
            }
        }
    }

    public void halt() {
        stop = true;
    }
}
