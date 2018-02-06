package tda551;

import tda551.polygon.PolygonFactory;

public class DrawPolygons {

    public static PolygonModel initPolygons() {
        PolygonModel polygons = new PolygonModel();
        return polygons;
    }

    public static void main( String[] args ) {
        PolygonModel model = initPolygons();
        PolygonViewer view = new PolygonViewer();
        view.add( model );
        model.addListener( view );
        PolygonController controller = new PolygonController( model, view );
        model.addPolygon( PolygonFactory.createRectangle( 0, 0 ) );
        model.addPolygon( PolygonFactory.createRectangle( 0, 0 ) );
        model.addPolygon( PolygonFactory.createRectangle( 0, 0 ) );
        model.addPolygon( PolygonFactory.createRectangle( 0, 0 ) );
        model.addPolygon( PolygonFactory.createRectangle( 0, 0 ) );



        Thread t = new Thread(model);
        t.start();

        // Add creator
        Creator creator = new Creator( model );
        Terminator arnold = new Terminator( model );
        creator.start();
        try {
            Thread.sleep( (int) ( Math.random() * 1000 ) );
        } catch ( InterruptedException e ) {
        }
        arnold.start();

        // Add terminator

    }
}