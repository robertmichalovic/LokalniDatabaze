package udalosti;
import gui.frame.*;
import java.awt.event.*;
import databaze.*;
public class SmazOsobu implements ActionListener {
	private HlavniJFrame frame;
	public SmazOsobu(HlavniJFrame frame) {
		this.frame = frame;		}
	public void actionPerformed(ActionEvent arg0) {
		Object [][] matice = frame.getTabulkaPanel().getPolePrvku();	//	ziskame matici prvku
		int radek = frame.getTabulkaPanel().getRadek();
		Osoba temp = Osoba.vytvorObjektOsoba(radek,matice);					//	vytvorime objekt Osoba
		/**** odtranime objekt z databaze - kolekce ****/
		SeznamOsob.getInstance().odeberOsoba(temp);
		/**** testovaci vypis po odstraneni zvoleno objektu ****/
		//SeznamOsob.getInstance().testTiskKolekceKonzole();
		///////frame.getTabulkaPanel().nastavMaticePrvku(matice);			//	matici opet vlozime do TabulkyPanel
		/***	metoda ktera vymaze tabulku ***/
		frame.getTabulkaPanel().vymazemeTabulku();							//	graficky vymazeme tabulku
		/*** 	nutne pokryt vyjimku v pripade nulove velikosti databaze **/
		if(SeznamOsob.getInstance().getDatabaze().size() !=0){					
			/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
			frame.getTabulkaPanel().prevodNaObjectPole();
			/**** metoda ktera provede update tabulky dat ****/
			frame.getTabulkaPanel().vlozimeMaticiDoTabulky();	}
		/****	DeAktivuji tlacitko pokud jsou nalezeny souradnice pro vymazani osoby ****/
		frame.getTlacPanel().getSmazOsoba().setEnabled(false);
		frame.getLista().getMenu2Volba2().setEnabled(false);
		frame.getTlacPanel().getEditOsoba().setEnabled(false);		//	deaktivovano v ramci bugs
		frame.getLista().getMenu2Volba3().setEnabled(false);
		/*** Po smazani cele databaze uzivatelu po jednom je nutno vypnou tlacitka - provest defaultni nastaveni***/
		if(SeznamOsob.getInstance().getDatabaze().size() ==0){
			frame.getLista().getMenu1Volba2().setEnabled(false);
			frame.getLista().getMenu1Volba3().setEnabled(false);
			frame.getLista().getMenu1Volba5().setEnabled(false);
			frame.getTlacPanel().getUlozDatab().setEnabled(false);
			frame.getTlacPanel().getSmazDatab().setEnabled(false);	}
	}
}
