package jri.scenario;

import jri.JRIScene;
import x.XApp;
import x.XCmdToChangeScene;
import x.XScenario;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class FirstScenario extends XScenario {
  // singleton pattern
  private static FirstScenario mSingleton = null;

  public static FirstScenario getSingleton() {
    assert (FirstScenario.mSingleton != null);
    return mSingleton;
  }

  public static FirstScenario createSingleton(XApp app, String pageName) {
    assert (FirstScenario.mSingleton == null);
    FirstScenario.mSingleton = new FirstScenario(app, pageName);
    return FirstScenario.mSingleton;
  }

  private FirstScenario(XApp app, String pageName) {
    super(app, pageName);
  }

  @Override
  protected void addScenes() {
    this.addScene(Scene1.createSingleton(this));
  }

  public void dispatchMoveToSecondPageButtonPress() {
    System.out.println("Button Pressed in FirstScenario");
    // 현재 활성화된 씬에 따라 동작 분기
    if (this.getApp().getScenarioMgr().getCurScene() == Scene1.mSingleton) {
      Scene1.mSingleton.onMoveToSecondPageButtonPress();
    }
  }

  public void dispatchMoveToBookSearchPageButtonPress() {
    // 현재 활성화된 씬에 따라 동작 분기
    if (this.getApp().getScenarioMgr().getCurScene() == Scene1.mSingleton) {
      Scene1.mSingleton.onMoveToBookSearchPageButtonPress();
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

    public void onMoveToBookSearchPageButtonPress() {
      XCmdToChangeScene.execute(this.mScenario.getApp(), BookSearchScenario.Scene1.getSingleton(), this);
    }

    public void onMoveToSecondPageButtonPress() {
      System.out.println("Button Pressed in FirstScenario : Scene1");
      XCmdToChangeScene.execute(this.mScenario.getApp(), SecondScenario.Scene1.getSingleton(), this);
    }

    @Override
    public void handleMousePress(MouseEvent e) {
      System.out.println("Mouse Pressed in  FirstScenario : Scene1");
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
      this.mScenario.getApp().getPageMgr().switchPage(FirstScenario.getSingleton().getPageName());
    }

    @Override
    public void wrapUp() {
    }
  }
}
