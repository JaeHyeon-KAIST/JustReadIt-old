package jri.scenario;

import jri.JRIScene;
import x.XApp;
import x.XScenario;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JRIEmptyScenario extends XScenario {
  // singleton pattern
  private static JRIEmptyScenario mSingleton = null;

  public static JRIEmptyScenario getSingleton() {
    assert (JRIEmptyScenario.mSingleton != null);
    return mSingleton;
  }

  public static JRIEmptyScenario createSingleton(XApp app, String pageName) {
    assert (JRIEmptyScenario.mSingleton == null);
    JRIEmptyScenario.mSingleton = new JRIEmptyScenario(app, pageName);
    return JRIEmptyScenario.mSingleton;
  }

  private JRIEmptyScenario(XApp app, String pageName) {
    super(app, pageName);
  }

  @Override
  protected void addScenes() {
    this.addScene(EmptyScene.createSingleton(this));
  }

  public static class EmptyScene extends JRIScene {
    //  singleton
    private static EmptyScene mSingleton = null;

    public static EmptyScene getSingleton() {
      assert (EmptyScene.mSingleton != null);
      return EmptyScene.mSingleton;
    }

    public static EmptyScene createSingleton(XScenario scenario) {
      assert (EmptyScene.mSingleton == null);
      EmptyScene.mSingleton = new EmptyScene(scenario);
      return EmptyScene.mSingleton;
    }

    private EmptyScene(XScenario scenario) {
      super(scenario);
    }

    @Override
    public void handleMousePress(MouseEvent e) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e) {
    }

    @Override
    public void handleMouseRelease(MouseEvent e) {
    }

    @Override
    public void handleKeyDown(KeyEvent e) {
    }

    @Override
    public void handleKeyUp(KeyEvent e) {
    }

    @Override
    public void getReady() {
    }

    @Override
    public void wrapUp() {
    }
  }
}
