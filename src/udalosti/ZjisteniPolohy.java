package udalosti;
import gui.frame.*;
import java.awt.event.*;
import javax.swing.JTable;
public class ZjisteniPolohy extends MouseAdapter  {
	private HlavniJFrame frame;
	private JTable tab;
	public ZjisteniPolohy(HlavniJFrame frame, JTable tabulka) {
		this.tab=tabulka;
		this.frame=frame;	}
	public void mouseClicked(MouseEvent arg0) {
		frame.getTabulkaPanel().setSloupec(tab.columnAtPoint(arg0.getPoint()));
		frame.getTabulkaPanel().setRadek(tab.rowAtPoint(arg0.getPoint()));
		/****	Aktivuji tlacitko pokud jsou nalezeny souradnice pro vymazani osoby ****/
		frame.getTlacPanel().getSmazOsoba().setEnabled(true);
		frame.getTlacPanel().getEditOsoba().setEnabled(true);
		frame.getLista().getMenu2Volba2().setEnabled(true);
		frame.getLista().getMenu2Volba3().setEnabled(true);
		/*int sloupec = tab.rowAtPoint(arg0.getPoint());
		int radek = tab.columnAtPoint(arg0.getPoint());
		System.out.println("Sloupec : "+sloupec+"\tRadek : "+radek);*/
	}
}
