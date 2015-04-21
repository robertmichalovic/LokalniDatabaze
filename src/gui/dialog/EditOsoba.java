package gui.dialog;
import java.awt.event.*;
import java.util.Iterator;

import databaze.Osoba;
import databaze.SeznamOsob;
import gui.frame.HlavniJFrame;
public class EditOsoba extends DialOsoba{
	private static final long serialVersionUID = -6155876996098963869L;
	private HlavniJFrame frame;
	private Osoba zdrojOsoba;
	private void nastavOsobuDoDialogu(){
		this.getJmeno().setText(zdrojOsoba.getJmeno());
		this.getPrijmeni().setText(zdrojOsoba.getPrijmeni());
		this.getZamestnani().setText(zdrojOsoba.getZamestnani());
		this.getTelefon().setText(zdrojOsoba.getTelefon());
		this.getMail().setText(zdrojOsoba.getMail());
		this.getVyska().setText(zdrojOsoba.getVyska());
		this.getVaha().setText(zdrojOsoba.getVaha());
		this.getNarozeniny().setText(zdrojOsoba.getNarozeni());
		//	 	pohlavi true muz, false zena
		if(zdrojOsoba.ziskejPohlavi())	muz.setState(true);
		else zena.setState(true);	}
	public EditOsoba(HlavniJFrame frame, Osoba osoba) {			// konstruktor
		super(frame, true);
		this.frame = frame;
		this.zdrojOsoba = osoba;
		this.setTitle(texty.Text.nazevJDialoguUpravaOsoba);
		/****	Testovaci vypis 	****/
		//System.out.println("Vybrana osoba :"+osoba);
		nastavOsobuDoDialogu();
		this.okTlac.setEnabled(true);
		stornoTlac.addActionListener(new StornoDialogu(frame));
		okTlac.addActionListener(new OkDialog(frame));
	}
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
		public void actionPerformed(ActionEvent e) {
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
		public OkDialog(HlavniJFrame frame) {	}
		public void upravOsobu(Osoba novaOsoba) { 				//	metoda upravujici objekt v kolekci
			//System.out.println("metoda uprav");
			for(Iterator<Osoba> iter = SeznamOsob.getInstance().getDatabaze().iterator();iter.hasNext();) {
				Osoba osobaIter = iter.next();
				//System.out.println("Osoba 1 : "+osoba1+"\nOsoba 2 : "+osoba2);
				//System.out.println("iterator ");
				if(zdrojOsoba.equals(osobaIter))  {
					osobaIter.nastavJmeno(novaOsoba.getJmeno());
					osobaIter.nastavPrijmeni(novaOsoba.getPrijmeni());
					osobaIter.nastavZamestnani(novaOsoba.getZamestnani());
					osobaIter.nastavTelefon(novaOsoba.getTelefon());
					osobaIter.nastavMail(novaOsoba.getMail());
					osobaIter.nastavVaha(novaOsoba.getVaha());
					osobaIter.nastavVyska(novaOsoba.getVyska());
					osobaIter.nastavNarozeniny(novaOsoba.getNarozeni());
					osobaIter.nastavPohlavi(novaOsoba.ziskejPohlavi());
					break;	}	}	}
		public void actionPerformed(ActionEvent e) {
			boolean pohlavi;
			if(muz.getState() == true) pohlavi = true; else pohlavi = false;
			Osoba osobaNova = new Osoba(getJmeno().getText(),getPrijmeni().getText(),getZamestnani().getText(),
					getTelefon().getText(),
					getMail().getText(),getNarozeniny().getText(),getVyska().getText(),getVyska().getText(),pohlavi);
			upravOsobu(osobaNova);
	 		/** objekty se ulozi do databaze a zobrazi v conzole pres iterator ...... OK ***/
			//SeznamOsob.getInstance().testTiskKolekceKonzole();		//	testovaci metoda
			/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
			frame.getTabulkaPanel().prevodNaObjectPole();
			/**** metoda ktera provede update tabulky dat ****/
			frame.getTabulkaPanel().vlozimeMaticiDoTabulky();
			//SeznamOsob.getInstance().vlozimeMaticiDoTabulky();
			/****	Aktivuji buttony po vytvoreni uzivatele ****/
			frame.getTlacPanel().getEditOsoba().setEnabled(false);
			frame.getTlacPanel().getSmazOsoba().setEnabled(false);
			frame.getTlacPanel().getUlozDatab().setEnabled(true);
			frame.getTlacPanel().getSmazDatab().setEnabled(true);
			frame.getLista().getMenu1Volba2().setEnabled(true);
			frame.getLista().getMenu1Volba3().setEnabled(true);
			frame.getLista().getMenu1Volba5().setEnabled(true);
			dispose(); }									// nebo setVisible(false); // zrusi okno
	}
}
