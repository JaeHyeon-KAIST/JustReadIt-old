package jri;

import jri.page.BookSearchPage;
import jri.page.FirstPage;
import jri.page.SecondPage;
import jri.scenario.BookSearchScenario;
import jri.scenario.SecondScenario;
import jri.scenario.FirstScenario;
import x.XScenarioMgr;

public class JRIScenarioMgr extends XScenarioMgr {
  public JRIScenarioMgr(JRIApp jri) {
    super(jri);
  }

  @Override
  protected void addScenarios() {
    this.addScenario(FirstScenario.createSingleton(this.mApp, FirstPage.PAGE_NAME));
    this.addScenario(SecondScenario.createSingleton(this.mApp, SecondPage.PAGE_NAME));
    this.addScenario(BookSearchScenario.createSingleton(this.mApp, BookSearchPage.PAGE_NAME));
  }

  @Override
  protected void setInitCurScene() {
    this.setCurScene(FirstScenario.Scene1.getSingleton());
  }
}
