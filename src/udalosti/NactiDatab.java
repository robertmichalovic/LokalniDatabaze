package udalosti;
import gui.frame.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import databaze.*;
public class NactiDatab implements ActionListener {
	private JFrame frame;
	private HlavniJFrame mujFrame;
	private String cestaSoubor;
	/*
	public NactiDatab(PanelTlacitek dialog){  				// konstruktor jehoz parametr je objekt typu JPanel
		this.mujFrame = dialog.ziskejHlavniFrame();
		this.frame=((JFrame)dialog.getParent());	} 		// pretypujeme JPanel dialog na JFrame dialog */
	public NactiDatab(HlavniJFrame dialog) {
		this.mujFrame = dialog;
		this.frame = (JFrame) dialog;	}
	public void actionPerformed(ActionEvent arg0) {
		zjistiCestuSoubor(FileDialog.LOAD,frame);
		nactiSoubor();
		/****	Aktivuji buttony po nacteni databaze ****/
		if(SeznamOsob.getInstance().getDatabaze().size() !=0) {				//	pokud je kolekce vetsi nez nula aktivuj
			mujFrame.getTlacPanel().getUlozDatab().setEnabled(true);
			mujFrame.getLista().getMenu1Volba2().setEnabled(true);
			mujFrame.getLista().getMenu1Volba3().setEnabled(true);
			mujFrame.getLista().getMenu1Volba5().setEnabled(true);
			//mujFrame.getTlacPanel().getSmazOsoba().setEnabled(true);		//	deaktivovano v ramci bugs
			//mujFrame.getTlacPanel().getEditOsoba().setEnabled(true);		//	deaktivovano v ramci bugs
			mujFrame.getTlacPanel().getSmazDatab().setEnabled(true);	}	}
	private void zjistiCestuSoubor(int mod,JFrame dialog){
		FileDialog volicSouboru = new FileDialog(dialog,"Nacti Soubor ...  *.datab",mod); // konstruktor objektu akceptuje pouze dialog typu JFrame
		volicSouboru.setFile("*.datab");
		volicSouboru.setDirectory("\\");
		volicSouboru.setVisible(true);
		cestaSoubor = volicSouboru.getDirectory()+volicSouboru.getFile();		//	ziska celou cestu k souboru
		//System.out.println("Jmeno souboru :"+cestaSoubor);					//	vypise cestu k souboru
	}
	@SuppressWarnings({ "unchecked" })
	private void nactiSoubor() {
		/**** 	NASTAVIME PROUDY PRO Nacteni */
		FileInputStream souborObjekt=null;
		ObjectInputStream objektNacteni=null;
		try {
			souborObjekt = new FileInputStream(cestaSoubor);
			objektNacteni = new ObjectInputStream(souborObjekt); 		}		// vytvorime objekt pro ukladani do souboru 
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaFile,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
			} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaIO,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
			}
		/**** 	PROVEDEME Nacteni DO KOLEKCE JEDNOTLIVE OBJEKTY **********/
		SeznamOsob.getInstance().vymazDatabazi();					//	odstranime data z predchozi kolekce
		Set<Osoba> databaze = null;
		if(objektNacteni != null || souborObjekt != null) {		//	nutne kvuli vypsani vyjimce
			try {
				databaze = (HashSet<Osoba>)objektNacteni.readObject();	}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null,texty.Text.vyjimkaNacteni,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
				//e.printStackTrace();
				}
			catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,texty.Text.vyjimkaTypovani,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
				//e.printStackTrace();
				}	
			/**** 	Provedeme ukonceni proudu *********/
			try {
				objektNacteni.close(); 
				souborObjekt.close();	}
			catch (IOException e) {	
				JOptionPane.showMessageDialog(null,texty.Text.vyjimkaUkonceniStream,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();	}	}
		/*** metoda ktera nactenou databazi ulozi do kolekce singletou **/
		if(databaze != null )SeznamOsob.getInstance().nastavDatabazi(databaze);		//	pokud se podarilo ulozit databazi
		else return;																//	jinak ukonci metodu
		/*** TESTOVACI VYPIS FUNGUJE - OK ***/
		//SeznamOsob.getInstance().testTiskKolekceKonzole();							//	testovaci vypis na konzolu
		/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
		mujFrame.getTabulkaPanel().prevodNaObjectPole();
		/**** metoda ktera provede update tabulky dat ****/
		mujFrame.getTabulkaPanel().vlozimeMaticiDoTabulky();
	}
}
