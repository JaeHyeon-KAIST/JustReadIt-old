package jri.page;

import jri.JRIApp;
import jri.scenario.BookSearchScenario;
import x.XPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSearchPage extends XPage {
  public static final String PAGE_NAME = "BookSearchPage";
  private JLabel label;
  private JPanel BookSearchPage;
  private JButton goBackButton;

  public BookSearchPage(JRIApp app) {
    super(PAGE_NAME);

    goBackButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        BookSearchScenario scenario = (BookSearchScenario) app.getScenarioMgr().getCurScene().getScenario();
        scenario.dispatchReturnButtonPress();
      }
    });
  }

  @Override
  public JPanel getGUI() {
    return BookSearchPage;
  }
}
