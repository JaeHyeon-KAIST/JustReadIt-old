package jri;

import x.XApp;
import x.XLogMgr;
import x.XPageMgr;
import x.XScenarioMgr;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.CardLayout;

public class JRIApp extends XApp {
  // fields
  private JFrame frame;
  private JPanel cardPanel;
  private CardLayout cardLayout;
  private JRIScenarioMgr scenarioMgr;
  private JRIEventListener eventListener;
  private JRIPageMgr pageMgr;
  private XLogMgr mLogMgr = null;

  public JPanel getCardPanel() {
    return this.cardPanel;
  }

  public CardLayout getCardLayout() {
    return this.cardLayout;
  }

  @Override
  public XPageMgr getPageMgr() {
    return this.pageMgr;
  }

  @Override
  public XLogMgr getLogMgr() {
    return this.mLogMgr;
  }

  @Override
  public XScenarioMgr getScenarioMgr() {
    return this.scenarioMgr;
  }

  public JRIApp() {
    // create components.
    // 1) frame 2) other components 3) event listeners 4) managers
    this.frame = new JFrame("Just Read It");
    this.cardLayout = new CardLayout();
    this.cardPanel = new JPanel(this.cardLayout);
    this.eventListener = new JRIEventListener(this);
    this.pageMgr = new JRIPageMgr(this);
    this.scenarioMgr = new JRIScenarioMgr(this);
    this.mLogMgr = new XLogMgr();
    this.mLogMgr.setPrintOn(true);

    // connect event listeners
    this.cardPanel.addMouseListener(this.eventListener);
    this.cardPanel.addMouseMotionListener(this.eventListener);
    this.frame.setFocusable(true);
    this.frame.addKeyListener(this.eventListener);

    // build and show visual components.
    this.pageMgr.getPages().forEach(page -> this.cardPanel.add(page.getGUI(), page.getPageName()));
    this.frame.add(this.cardPanel);
    this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setVisible(true);
  }

  public static void main(String[] args) {
    //create a JRI instance.
    JRIApp app = new JRIApp();
  }
}
