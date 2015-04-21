package udalosti;
import gui.frame.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import java.util.Iterator;
import javax.swing.*;
import databaze.*;
public class UlozDatab implements ActionListener {
	private JFrame dialog;
	private String cestaSoubor;
	/* - nevyuzity konstruktor
	public UlozDatab(JPanel dialog){  					// konstruktor jehoz parametr je objekt typu JPanel
		this.dialog=((JFrame)dialog.getParent());	} 	// pretypujeme JPanel dialog na JFrame dialog*/
	public UlozDatab(HlavniJFrame dialog) {
		this.dialog =(JFrame)dialog;	}
	public void actionPerformed(ActionEvent arg0) {
		zjistiCestuSoubor(FileDialog.SAVE,dialog);
		if(SeznamOsob.getInstance().getDatabaze().size() != 0 )ulozSoubor();		//	nedovoli to ulozit prazdnou kolekci
		else JOptionPane.showMessageDialog(null,texty.Text.prazdnaKolekce,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
	}
	private void zjistiCestuSoubor(int mod,JFrame dialog){
		FileDialog volicSouboru = new FileDialog(dialog,"Uloz Soubor ...  *.datab",mod); // konstruktor objektu akceptuje pouze dialog typu JFrame
		volicSouboru.setFile("*.datab");
		volicSouboru.setDirectory("\\");
		volicSouboru.setVisible(true);
		//cestaSoubor = volicSouboru.getFile();									// ziska nazev souboru
		cestaSoubor = volicSouboru.getDirectory()+volicSouboru.getFile();		//	ziska celou cestu k souboru
		//System.out.println("Jmeno souboru :"+cestaSoubor);					//	vypise cestu k souboru
	}		
	private void ulozSoubor(){
		if(cestaSoubor == null) return;				//	kontrola na nulovou referenci - neprovede se ulozeni a metoda se ukonci
		/**** 	NASTAVIME PROUDY PRO ULOZENI */
		FileOutputStream souborObjekt=null;
		ObjectOutputStream objektUkladani=null;
		try {
			souborObjekt = new FileOutputStream(cestaSoubor);
			objektUkladani = new ObjectOutputStream(souborObjekt); 		}		// vytvorime objekt pro ukladani do souboru 
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaFile,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();	} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaIO,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();	}
		/**** 	PROVEDEME ULOZENI DO KOLEKCE JEDNOTLIVE OBJEKTY */
		/* -- problem s ze pri nacitani nelze zjisti pocet ulozenych objektu
		for(Iterator<Osoba> iter = SeznamOsob.getInstance().getDatabaze().iterator();iter.hasNext();) {
			Osoba pomocObjekt = iter.next();
			try {
				objektUkladani.writeObject(pomocObjekt);	}
			catch (IOException e) {	
				e.printStackTrace();	}	}*/
		try {
			objektUkladani.writeObject(SeznamOsob.getInstance().getDatabaze());	}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaUlozeni,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();	}
		/**** 	Provedeme ukonceni proudu */
		try {
			objektUkladani.close(); 
			souborObjekt.close();	}
		catch (IOException e) {	
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaUkonceniStream,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();	} 
	}
}
