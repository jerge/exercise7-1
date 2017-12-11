package tda551;

public class DrawPolygons {

  public static PolygonModel initPolygons() {
    PolygonModel polygons = new PolygonModel();
    return polygons;
  }

  public static void main(String[] args) {
    PolygonModel model = initPolygons();
    PolygonViewer view = new PolygonViewer();
    view.add(model);
    model.addListener(view);
    PolygonController controller = new PolygonController(model, view);

    model.animate();

    // Add creator
    Creator creator = new Creator(model);
    creator.start();

    // Add terminator

  }
}