package jri.scenario;

import jri.JRIScene;
import x.XApp;
import x.XCmdToChangeScene;
import x.XScenario;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SecondScenario extends XScenario {
  // singleton pattern
  private static SecondScenario mSingleton = null;

  public static SecondScenario getSingleton() {
    assert (SecondScenario.mSingleton != null);
    return mSingleton;
  }

  public static SecondScenario createSingleton(XApp app, String pageName) {
    assert (SecondScenario.mSingleton == null);
    SecondScenario.mSingleton = new SecondScenario(app, pageName);
    return SecondScenario.mSingleton;
  }

  private SecondScenario(XApp app, String pageName) {
    super(app, pageName);
  }

  @Override
  protected void addScenes() {
    this.addScene(Scene1.createSingleton(this));
  }

  public void dispatchReturnButtonPress() {
    System.out.println("Button Pressed in SecondScenario");
    // 현재 활성화된 씬에 따라 동작 분기
    if (this.getApp().getScenarioMgr().getCurScene() == Scene1.mSingleton) {
      Scene1.mSingleton.onReturnButtonPress();
    }
  }

  public static class Scene1 extends JRIScene {
    //  singleton
    private static Scene1 mSingleton = null;

    public static Scene1 getSingleton() {
      assert (Scene1.mSingleton != null);
      return Scene1.mSingleton;
    }

    public static Scene1 createSingleton(XScenario scenario) {
      assert (Scene1.mSingleton == null);
      Scene1.mSingleton = new Scene1(scenario);
      return Scene1.mSingleton;
    }

    private Scene1(XScenario scenario) {
      super(scenario);
    }

    public void onReturnButtonPress() {
      System.out.println("Button Pressed in SecondScenario : Scene1");
      XCmdToChangeScene.execute(this.mScenario.getApp(), this.mReturnScene, null);
    }

    @Override
    public void handleMousePress(MouseEvent e) {
      System.out.println("Mouse Pressed in  SecondScenario : Scene1");
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
      this.mScenario.getApp().getPageMgr().switchPage(SecondScenario.getSingleton().getPageName());
    }

    @Override
    public void wrapUp() {
    }
  }
}
