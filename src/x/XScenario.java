package x;

import java.util.ArrayList;

public abstract class XScenario {
  // fields
  protected XApp mApp = null;

  public XApp getApp() {
    return this.mApp;
  }

  protected ArrayList<XScene> mScenes = null;

  private String mPageName = null;

  public String getPageName() {
    return this.mPageName;
  }

  // constructor
  protected XScenario(XApp app, String pageName) {
    this.mApp = app;
    this.mScenes = new ArrayList<XScene>();
    this.mPageName = pageName;
    this.addScenes();
  }

  // abstract methods
  protected abstract void addScenes();

  // concrete methods
  public void addScene(XScene scene) {
    this.mScenes.add(scene);
  }
}
