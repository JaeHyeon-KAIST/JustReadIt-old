package jri.page;

import jri.JRIApp;
import jri.scenario.SecondScenario;
import x.XPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends XPage {
  public static final String PAGE_NAME = "SecondPage";
  private JLabel label;
  private JPanel secondPageGUI;
  private JButton returnButton;

  public SecondPage(JRIApp app) {
    super(PAGE_NAME);

    returnButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SecondScenario scenario = (SecondScenario) app.getScenarioMgr().getCurScene().getScenario();
        scenario.dispatchReturnButtonPress();
      }
    });
  }

  @Override
  public JPanel getGUI() {
    return secondPageGUI;
  }
}
