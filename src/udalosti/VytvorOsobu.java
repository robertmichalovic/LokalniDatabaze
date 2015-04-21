package udalosti;
import gui.dialog.NewOsoba;
import gui.frame.HlavniJFrame;
import java.awt.event.*;
public class VytvorOsobu implements ActionListener {  //Dialog Nova Osoba
	private HlavniJFrame frame;
	public VytvorOsobu(HlavniJFrame frame) {
		this.frame = frame;	}
	public void actionPerformed(ActionEvent e) {
		NewOsoba dialogNovy = new NewOsoba(frame);
		dialogNovy.setVisible(true);
	}	
}
