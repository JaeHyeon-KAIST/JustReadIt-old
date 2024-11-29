package x;

import javax.swing.JPanel;

public abstract class XPage {
  // fields
  protected String mPageName = null;

  public String getPageName() {
    return this.mPageName;
  }

  // constructor
  protected XPage(String pageName) {
    this.mPageName = pageName;
  }

  // abstract methods
  public abstract JPanel getGUI();
}
