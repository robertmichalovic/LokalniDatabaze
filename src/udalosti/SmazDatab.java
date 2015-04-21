package udalosti;
import gui.frame.*;
import java.awt.event.*;
import databaze.*;
public class SmazDatab implements ActionListener {
	private HlavniJFrame frame;
	public SmazDatab(HlavniJFrame frame) {
		this.frame = frame;	}
	public void actionPerformed(ActionEvent e) {
		SeznamOsob.getInstance().vymazDatabazi();					//	odstranime data z predchozi kolekce
		frame.getTabulkaPanel().vymazemeTabulku();					//	graficky vymazeme tabulku
		/****	DeAktivuji buttony po nacteni databaze ****/
		frame.getTlacPanel().getUlozDatab().setEnabled(false);
		frame.getTlacPanel().getSmazOsoba().setEnabled(false);
		frame.getTlacPanel().getEditOsoba().setEnabled(false);
		frame.getTlacPanel().getSmazDatab().setEnabled(false);
		frame.getLista().getMenu2Volba2().setEnabled(false);
		frame.getLista().getMenu2Volba3().setEnabled(false);
		frame.getLista().getMenu1Volba2().setEnabled(false);
		frame.getLista().getMenu1Volba3().setEnabled(false);
		frame.getLista().getMenu1Volba5().setEnabled(false);
	}
}
