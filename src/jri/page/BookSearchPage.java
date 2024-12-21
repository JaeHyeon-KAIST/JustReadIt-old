package jri.page;

import jri.JRIApp;
import x.XPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BookSearchPage extends XPage {
  public static final String PAGE_NAME = "BookSearchPage";
  private JLabel label;
  private JPanel BookSearchPage;
  private JPanel webViewPanel;
  private JButton goBackButton;
  private JFXPanel fxPanel;

  public BookSearchPage(JRIApp app) {
    super(PAGE_NAME);

    // Swing 패널에 JFXPanel 추가
    fxPanel = new JFXPanel();
    webViewPanel.setLayout(new BorderLayout());
    webViewPanel.add(fxPanel, BorderLayout.CENTER);

    // WebView 초기화
    Platform.runLater(() -> {
      WebView webView = new WebView();
      WebEngine webEngine = webView.getEngine();

      // URL로 페이지 로드
      webEngine.load("https://jaehyeon.com/");

      webEngine.documentProperty().addListener((observable, oldDoc, newDoc) -> {
        if (newDoc != null) {
          webEngine.executeScript(
            "document.addEventListener('click', function(event) {" +
              "  event.preventDefault();" +
              "});"
          );
        }
      });
//
//      webEngine.locationProperty().addListener((observable, oldLocation, newLocation) -> {
//        if (!newLocation.equals(initialURL)) {
//          System.out.println("Blocked link: " + newLocation);
//          Platform.runLater(() -> webEngine.load(initialURL));
//        }
//      });
//
//      webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
//        System.out.println("WebEngine state: " + newState);
//      });
//      webEngine.setOnError(event -> System.out.println("WebView Error: " + event.getMessage()));

      Scene scene = new Scene(webView);
      fxPanel.setScene(scene);
    });

//    goBackButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        BookSearchScenario scenario = (BookSearchScenario) app.getScenarioMgr().getCurScene().getScenario();
//        scenario.dispatchReturnButtonPress();
//      }
//    });
  }

  @Override
  public JPanel getGUI() {
    return BookSearchPage;
  }
}
