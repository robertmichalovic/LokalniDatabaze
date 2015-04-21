/***	Nepocitam s zadnou kontrolou na prijmeni	****/
package kontroly.vstup.dialog;
import gui.dialog.DialOsoba;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
public class PrijmeFocus implements FocusListener {
	private DialOsoba dialog;
	public PrijmeFocus(DialOsoba dialOsoba) {
		this.dialog=dialOsoba;	}
	public void focusGained(FocusEvent arg0) {	}			//	nevyužito
	public void focusLost(FocusEvent arg0) {
		//System.out.println("Test");					//	test
		String temp = dialog.getPrijmeni().getText();
		//System.out.println("Info Jmeno : "+dialog.getJmeno().getText().length() );
		if(temp.length()==0 | dialog.getJmeno().getText().length() == 0) {
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaPrijme,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			dialog.getPrijmeni().requestFocus();	}
		else dialog.setNastPrijme(true);		}		
}
