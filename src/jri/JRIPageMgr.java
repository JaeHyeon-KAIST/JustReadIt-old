package jri;

import jri.page.FirstPage;
import jri.page.SecondPage;
import x.XPageMgr;

public class JRIPageMgr extends XPageMgr {
  // constructor
  public JRIPageMgr(JRIApp app) {
    super(app);
  }

  // methods
  @Override
  public void addPages() {
    this.addPage(new FirstPage((JRIApp) this.mApp));
    this.addPage(new SecondPage((JRIApp) this.mApp));
  }

  @Override
  public void switchPage(String pageName) {
    JRIApp app = (JRIApp) this.mApp;
    app.getCardLayout().show(app.getCardPanel(), pageName);
  }
}
