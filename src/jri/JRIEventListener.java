package jri;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JRIEventListener implements MouseListener, MouseMotionListener, KeyListener {

  private JRIApp mJRI = null;

  public JRIEventListener(JRIApp jsi) {
    this.mJRI = jsi;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    JRIScene curScene = (JRIScene) mJRI.getScenarioMgr().getCurScene();
    curScene.handleMousePress(e);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    JRIScene curScene = (JRIScene) mJRI.getScenarioMgr().getCurScene();
    curScene.handleMouseDrag(e);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    JRIScene curScene = (JRIScene) mJRI.getScenarioMgr().getCurScene();
    curScene.handleMouseRelease(e);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    JRIScene curScene = (JRIScene) mJRI.getScenarioMgr().getCurScene();
    curScene.handleKeyDown(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    JRIScene curScene = (JRIScene) mJRI.getScenarioMgr().getCurScene();
    curScene.handleKeyUp(e);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }
}
