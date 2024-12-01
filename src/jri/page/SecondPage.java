package jri.page;

import jri.JRIApp;
import jri.scenario.SecondScenario;
import x.XPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SecondPage extends XPage {
  public static final String PAGE_NAME = "SecondPage";
  private JPanel secondPageGUI;
  private JButton goToHomeButton;
  private JList menuList;
  private JTabbedPane noteListPannel;
  private JLabel menu;
  private JLabel bookName;
  private JLabel bookAuthor;
  private JLabel bookPublisher;
  private JLabel bookPublicationYear;
  private JLabel bookImage;

  public SecondPage(JRIApp app) {
    super(PAGE_NAME);

    goToHomeButton.addActionListener(new ActionListener() {
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

  private void createUIComponents() {
    secondPageGUI = new JPanel();
    secondPageGUI.setLayout(new BorderLayout());

    // Get the current size of the frame (secondPageGUI)
    int frameWidth = secondPageGUI.getWidth();

    menu = new JLabel("Menu");
    menuList = new JList();

    goToHomeButton = new JButton("Go to Home");

    noteListPannel = new JTabbedPane();

    // Book information
    bookImage = new JLabel("Book Image");
    bookName = new JLabel("Book Name");
    bookAuthor = new JLabel("Book Author");
    bookPublisher = new JLabel("Publisher");
    bookPublicationYear = new JLabel("Publication Year");

  }
}
