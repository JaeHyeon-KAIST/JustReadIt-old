package jri.scenario;

import jri.AladdinOpenAPI.AladdinOpenAPI;
import jri.AladdinOpenAPI.AladdinResponse;
import jri.AladdinOpenAPI.Item;
import jri.JRIScene;
import x.XApp;
import x.XCmdToChangeScene;
import x.XScenario;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class BookSearchScenario extends XScenario {
  // singleton pattern
  private static BookSearchScenario mSingleton = null;

  public static BookSearchScenario getSingleton() {
    assert (BookSearchScenario.mSingleton != null);
    return mSingleton;
  }

  public static BookSearchScenario createSingleton(XApp app, String pageName) {
    assert (BookSearchScenario.mSingleton == null);
    BookSearchScenario.mSingleton = new BookSearchScenario(app, pageName);
    return BookSearchScenario.mSingleton;
  }

  private BookSearchScenario(XApp app, String pageName) {
    super(app, pageName);
  }

  @Override
  protected void addScenes() {
    this.addScene(Scene1.createSingleton(this));
  }

  public void dispatchReturnButtonPress() {
    // 현재 활성화된 씬에 따라 동작 분기
    if (this.getApp().getScenarioMgr().getCurScene() == Scene1.mSingleton) {
      Scene1.mSingleton.onReturnButtonPress();
    }
  }

  public static class Scene1 extends JRIScene {
    //  singleton
    private static Scene1 mSingleton = null;

    public static Scene1 getSingleton() {
      assert (Scene1.mSingleton != null);
      return Scene1.mSingleton;
    }

    public static Scene1 createSingleton(XScenario scenario) {
      assert (Scene1.mSingleton == null);
      Scene1.mSingleton = new Scene1(scenario);
      return Scene1.mSingleton;
    }

    private Scene1(XScenario scenario) {
      super(scenario);
    }

    public void onReturnButtonPress() {
      XCmdToChangeScene.execute(this.mScenario.getApp(), this.mReturnScene, null);
    }

    @Override
    public void handleMousePress(MouseEvent e) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e) {
    }

    @Override
    public void handleMouseRelease(MouseEvent e) {
    }

    @Override
    public void handleKeyDown(KeyEvent e) {
      try {
        // Instantiate the AladdinOpenAPI
        AladdinOpenAPI api = new AladdinOpenAPI();

        try {
          AladdinResponse response = api.searchItems("과학", 10, 1);

          System.out.println("Total Results: " + response.getTotalResults());
          for (Item item : response.getItems()) {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor());
            System.out.println("Publisher: " + item.getPublisher());
            System.out.println("Price: " + item.getPriceSales());
            System.out.println("PubDate: " + item.getPubDate());
            System.out.println("Description: " + item.getDescription());
            System.out.println("SeriesInfo: " + item.getSeriesInfo().getSeriesName());
            System.out.println("ImageCover: " + item.getCover());
            System.out.println("---------");
          }
        } catch (Exception ex) {
          System.out.println("Exception: " + ex.getMessage());
        }
      } catch (Exception ex) {
        System.out.println("Exception: " + ex.getMessage());
      }
    }

    @Override
    public void handleKeyUp(KeyEvent e) {
    }

    @Override
    public void getReady() {
      this.mScenario.getApp().getPageMgr().switchPage(BookSearchScenario.getSingleton().getPageName());
    }

    @Override
    public void wrapUp() {
    }
  }
}
