package tda551;

import tda551.polygon.PolygonFactory;

import java.awt.*;
import java.awt.event.*;

public class PolygonController {

  private PolygonModel model;
  private PolygonViewer view;

  public PolygonController(PolygonModel model, PolygonViewer view) {
    this.model = model;
    this.view = view;
    initInteraction();
  }

  private void initInteraction() {
    view.addMouseListener(new PolygonCreator());
  }

  private class PolygonCreator implements MouseListener {
    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
      Point pointClicked = e.getPoint();
      model.addPolygon(PolygonFactory.createRectangle(pointClicked.x, pointClicked.y));
      view.repaint();
    }
  }
}