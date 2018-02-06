package tda551;

public class Terminator extends Thread{

    PolygonModel model;
    final int WAIT = 1;
    boolean stop;

    public Terminator(PolygonModel model) {
        this.model = model;
        stop = false;
    }
    public void run(){
        while ( !stop ) {
            try {
                wait();
            } catch ( InterruptedException e ) {
            }
            model.removePolygon();
            try {
                wait();
            } catch ( InterruptedException e ) {
            }
        }
    }
}
