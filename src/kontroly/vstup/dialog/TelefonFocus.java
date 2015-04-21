package kontroly.vstup.dialog;
import gui.dialog.DialOsoba;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
public class TelefonFocus implements FocusListener {		//	KONTROLA NA CISLO TELEFONU
	private DialOsoba dialog;
	public TelefonFocus(DialOsoba dialOsoba) {
		this.dialog=dialOsoba;	}
	public void focusGained(FocusEvent arg0) {	}							//	nevyuzite
	@SuppressWarnings("unused")
	public void focusLost(FocusEvent arg0) {
		if(dialog.getTelefon().getText().length() == 9 | dialog.getTelefon().getText().length() == 14) {	// 9 = lokal cislo ,14 = celosvetovì jinak meesage a mazeme
			if(dialog.getTelefon().getText().length() == 9 ){			//	kontrola lokalniho cisla - pouze jestli jej prevedeme na int
				int hodnota=0;
				try { 		//	zkusime ulozit hodnotu do integeru A pokud se neprovede se vyvola se vyjimka
					hodnota = Integer.valueOf(dialog.getTelefon().getText()).intValue();	}			
				catch (RuntimeException E) { 
					JOptionPane.showMessageDialog(null,texty.Text.vyjimkaTelefon9,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
					dialog.getTelefon().setText(null); 	}	}					// vynulujeme text a mohou zacit znova
			if(dialog.getTelefon().getText().length() == 14 ){
				String temp = dialog.getTelefon().getText();
				char znak = temp.charAt(0);					//	ziskame nulty znak    ....	+	
				long hodnota=0;								//	musi byt long nebo int je prilis maly
				try {
					if (znak == '+'){
						//		cislo	+422 153456456 			...	 celkem 14 znaku 
						//		index	0123456789   13			...  13 + 0 znak = 14 znaku
						String cislo = temp.substring(1,4)+temp.substring(5);
						hodnota = Long.valueOf(cislo).longValue();	}	}
				catch (RuntimeException E) { 
					JOptionPane.showMessageDialog(null,texty.Text.vyjimkaTelefon14,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
					dialog.getTelefon().requestFocus();
					dialog.getTelefon().setText(null); 	}	}	}				// vynulujeme text a mohou zacit znova
		else {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaTelefon9_14,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			dialog.getTelefon().requestFocus();
			dialog.getTelefon().setText(null);	}	}						// vynulujeme text a mohou zacit znova
}
