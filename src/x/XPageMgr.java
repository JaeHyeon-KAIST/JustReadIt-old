package x;

import java.util.ArrayList;

public abstract class XPageMgr {
  // fields
  protected XApp mApp = null;
  protected ArrayList<XPage> mPages = null;

  // constructor
  protected XPageMgr(XApp app) {
    this.mApp = app;
    this.mPages = new ArrayList<XPage>();
    this.addPages();
  }

  // abstract methods
  protected abstract void addPages();

  public abstract void switchPage(String pageName);

  // concrete methods
  public ArrayList<XPage> getPages() {
    return this.mPages;
  }

  public void addPage(XPage page) {
    this.mPages.add(page);
  }
}
