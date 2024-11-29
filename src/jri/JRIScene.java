package jri;

import x.XScenario;
import x.XScene;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class JRIScene extends XScene {
  protected JRIScene(XScenario scenario) {
    super(scenario);
  }

  public abstract void handleMousePress(MouseEvent e);

  public abstract void handleMouseDrag(MouseEvent e);

  public abstract void handleMouseRelease(MouseEvent e);

  public abstract void handleKeyDown(KeyEvent e);

  public abstract void handleKeyUp(KeyEvent e);
}
