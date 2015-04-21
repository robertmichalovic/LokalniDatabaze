package udalosti;
import gui.frame.*;

import java.awt.event.*;
public class JFrameFunkce implements ComponentListener, WindowListener {
	@SuppressWarnings("unused")
	private HlavniJFrame temp;
	public JFrameFunkce(HlavniJFrame hlavniOkno) {
		this.temp=hlavniOkno;	}
	public void componentHidden(ComponentEvent arg0) {	}
	public void componentMoved(ComponentEvent arg0) {	}
	public void componentResized(ComponentEvent arg0) {	}
	public void componentShown(ComponentEvent arg0) {	}
	public void windowActivated(WindowEvent e) {	}
	public void windowClosed(WindowEvent e) {	}
	public void windowClosing(WindowEvent e) {
		//System.out.println("Konec");
	}
	public void windowDeactivated(WindowEvent e) {	}
	public void windowDeiconified(WindowEvent e) {	}
	public void windowIconified(WindowEvent e) {	}
	public void windowOpened(WindowEvent e) {	}
}
