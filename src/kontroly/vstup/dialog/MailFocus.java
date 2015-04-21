package kontroly.vstup.dialog;
import gui.dialog.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
public 	class MailFocus implements FocusListener {		//	KONTROLA NA FUNKCNI MAIL - musi byt min. 1 @ a .
	private DialOsoba dialog;
	public MailFocus(DialOsoba dialog) {
		this.dialog=dialog;	}
	public void focusGained(FocusEvent arg0) {	}							//	nevyuzite
	public void focusLost(FocusEvent arg0) {
		String temp = dialog.getMail().getText();
		int pocetZavinac = temp.indexOf('@');
		int pocetTecka = temp.indexOf('.');
		if(pocetZavinac>0 & pocetTecka>0) {			//	pokud je ve stringu vice zavinacu a tecek nez je 0 pak ukoncime metodu
				return;	}							//	pokud sedi ukoncime metodu
		else { 
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaMail,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			dialog.getMail().setText(null);
			dialog.getMail().requestFocus();		}	}		//	melo by to vratit na zacatek focus - CHYBA NEUMOZNI TO ODEJIT Z DANEHO TEXTFIELDU
}
