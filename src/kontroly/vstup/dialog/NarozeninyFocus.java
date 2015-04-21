package kontroly.vstup.dialog;
import gui.dialog.DialOsoba;
import java.awt.event.*;
import javax.swing.JOptionPane;
//	KONTROLA NA FUNKCNI format datumu - musi byt min. 2. a velikosti cisel
//		datum	10.10.1960 				...	 celkem 10 znaku (max 10 znak a min. 8 znak = 1.1.1960)
//		index	0123456789   			...  9 + 0 znak = 10 znaku
public 	class NarozeninyFocus implements FocusListener {		
	private DialOsoba dialog;
	public NarozeninyFocus(DialOsoba dialOsoba) {
		this.dialog=dialOsoba;	}
	public void focusGained(FocusEvent e) {	}			//	nevyuzite
	public void focusLost(FocusEvent e) {
		String temp = dialog.getNarozeniny().getText();
		int pocetTecek=0;
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i) =='.') pocetTecek++;	}
		String [] jednotlivaCisla = temp.split("[.]");
		int cisloDen=0,cisloMesic=0,cisloRok=0;
		try {
			cisloDen=Integer.valueOf(jednotlivaCisla[0]).intValue();
			cisloMesic=Integer.valueOf(jednotlivaCisla[1]).intValue();
			cisloRok=Integer.valueOf(jednotlivaCisla[2]).intValue();	}
		catch(RuntimeException E){ }		//	vyjimka nezobrazuje nic protoze by vytvarela zbytecne dalsi messagebox
		if(pocetTecek == 2 & cisloDen<32 & cisloMesic<13 & cisloRok>1900 & cisloRok<2050){
			dialog.getOkTlac().setEnabled(true);
			return;	}
		else {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaNarozeniny,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			dialog.getNarozeniny().setText(null);	}	}	
}
