package tda551;

import javax.swing.*;

public class PolygonViewer extends JFrame implements AnimateListener {

  public PolygonViewer() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(30, 30, 300, 300);
    setVisible(true);
  }

  @Override
  public void actOnUpdate() {
    repaint();
    validate();
  }
}
