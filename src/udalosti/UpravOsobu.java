package udalosti;
import gui.dialog.EditOsoba;
import gui.frame.HlavniJFrame;
import java.awt.event.*;
import databaze.Osoba;
public class UpravOsobu implements ActionListener {
	private HlavniJFrame frame;
	public UpravOsobu(HlavniJFrame frame) {
		this.frame=frame;	}
	public void actionPerformed(ActionEvent arg0) {
		Object [][] matice = frame.getTabulkaPanel().getPolePrvku();			//	ziskame matici prvku
		int radek = frame.getTabulkaPanel().getRadek();
		Osoba osoba = Osoba.vytvorObjektOsoba(radek,matice);					//	vytvorime objekt Osoba
		EditOsoba dialog = new EditOsoba(frame,osoba);
		dialog.setVisible(true);
	}
}
