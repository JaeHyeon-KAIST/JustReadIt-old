package jri.page;

import jri.JRIApp;
import jri.scenario.FirstScenario;
import x.XPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends XPage {
  public static final String PAGE_NAME = "FirstPage";
  private JLabel label;
  private JPanel firstPageGUI;
  private JButton moveToSecondPageButton;

  public FirstPage(JRIApp app) {
    super(PAGE_NAME);

    moveToSecondPageButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        FirstScenario scenario = (FirstScenario) app.getScenarioMgr().getCurScene().getScenario();
        scenario.dispatchMoveToSecondPageButtonPress();
      }
    });
  }

  @Override
  public JPanel getGUI() {
    return firstPageGUI;
  }
}
