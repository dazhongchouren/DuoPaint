package com.wilsongateway.DuoPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BrushListener implements MouseListener, MouseMotionListener{

	private int oldMouseX = -1;
	private int oldMouseY;
	@Override
	public void mouseClicked(MouseEvent m) {
		if(MainFrame.getPaintMode()){
			MainFrame.paintStroke(m.getX(), m.getY(), m.getX(), m.getY());
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent m) {	
		if(m.getButton() == MouseEvent.BUTTON3){
			MainFrame.clearCanvas();
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	@Override
	public void mouseDragged(MouseEvent m) {
		if(oldMouseX == -1 && MainFrame.getPaintMode()){
			MainFrame.paintStroke(m.getX(), m.getY(), m.getX(), m.getY());
			oldMouseX = m.getX();
			oldMouseY = m.getY();
		}else if(MainFrame.getPaintMode()){
			MainFrame.paintStroke(m.getX(), m.getY(), oldMouseX, oldMouseY);
			oldMouseX = m.getX();
			oldMouseY = m.getY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent m) {
		if(oldMouseX == -1 && MainFrame.getPaintMode() && m.getButton() == MouseEvent.BUTTON1){
			MainFrame.paintStroke(m.getX(), m.getY(), m.getX(), m.getY());
			oldMouseX = m.getX();
			oldMouseY = m.getY();
		}else if(MainFrame.getPaintMode() && m.getButton() == MouseEvent.BUTTON1){
			MainFrame.paintStroke(m.getX(), m.getY(), oldMouseX, oldMouseY);
			oldMouseX = m.getX();
			oldMouseY = m.getY();
		}else{
			oldMouseX = m.getX();
			oldMouseY = m.getY();
		}
	}

}
