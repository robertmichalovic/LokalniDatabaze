package gui.dialog;
import java.awt.event.*;

import databaze.*;
import gui.frame.HlavniJFrame;
public class NewOsoba extends DialOsoba {
	private static final long serialVersionUID = -528765418251487116L;
	public NewOsoba(HlavniJFrame frame) {			// konstruktor
		super(frame, true);
		this.setTitle(texty.Text.nazevJDialoguNovaOsoba);
		stornoTlac.addActionListener(new StornoDialogu(frame));
		okTlac.addActionListener(new OkDialog(frame));	}
	class StornoDialogu implements ActionListener {
		private HlavniJFrame frame;
		public StornoDialogu(HlavniJFrame frame) {
			this.frame=frame;	}
		private void vymazemeHodnotyJTextField(){
			getJmeno().setText(null);
			getPrijmeni().setText(null);
			getZamestnani().setText(null);
			getTelefon().setText(null);
			getMail().setText(null);
			getVyska().setText(null);
			getVyska().setText(null);
			getNarozeniny().setText(null);	}
		public void actionPerformed(ActionEvent arg0) {
			vymazemeHodnotyJTextField();
			/** Kontrola na velikost databaze */
			frame.getTlacPanel().getEditOsoba().setEnabled(false);
			frame.getTlacPanel().getSmazOsoba().setEnabled(false);
			if(SeznamOsob.getInstance().getDatabaze().size() ==0 ){
				frame.getTlacPanel().getUlozDatab().setEnabled(false);
				frame.getTlacPanel().getSmazDatab().setEnabled(false);	}
			dispose(); }
	}
	class OkDialog implements ActionListener {
		private HlavniJFrame frame;
		public OkDialog(HlavniJFrame frame) {
			this.frame=frame;	}
		public void actionPerformed(ActionEvent e) {
			boolean pohlavi;
			if(muz.getState() == true) pohlavi = true; else pohlavi = false;
			Osoba osobaNova = new Osoba(getJmeno().getText(),getPrijmeni().getText(),getZamestnani().getText(),
					getTelefon().getText(),getMail().getText(),getNarozeniny().getText(),
					getVyska().getText(),getVyska().getText(),pohlavi); 
			/** Kontrolni vypis ulozeneho objektu - vytvoreni objektu a vypis objektu funguje ***/
			//System.out.println("osobaNova :"+osobaNova); 			
			/** prvni se provede getInstance a po ni az pridejOsoba			  ...... OK  ***/
			SeznamOsob.getInstance().pridejOsoba(osobaNova); 
	 		/** objekty se ulozi do databaze a zobrazi v conzole pres iterator ...... OK ***/
			//SeznamOsob.getInstance().testTiskKolekceKonzole();		//	testovaci metoda
			/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
			frame.getTabulkaPanel().prevodNaObjectPole();
			/**** metoda ktera provede update tabulky dat ****/
			frame.getTabulkaPanel().vlozimeMaticiDoTabulky();
			//SeznamOsob.getInstance().vlozimeMaticiDoTabulky();
			/****	Aktivuji buttony po vytvoreni uzivatele ****/
			frame.getTlacPanel().getUlozDatab().setEnabled(true);
			frame.getTlacPanel().getSmazDatab().setEnabled(true);
			frame.getLista().getMenu1Volba2().setEnabled(true);
			frame.getLista().getMenu1Volba3().setEnabled(true);
			frame.getLista().getMenu1Volba5().setEnabled(true);
			setVisible(false); }									// nebo dispose(); // zrusi okno
	}
}
