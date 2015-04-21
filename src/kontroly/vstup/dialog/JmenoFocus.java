/***	Nepocitam s zadnou kontrolou na krestni jmeno	****/
package kontroly.vstup.dialog;
import gui.dialog.DialOsoba;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
public class JmenoFocus implements FocusListener {
	private DialOsoba dialog;
	public JmenoFocus(DialOsoba dialOsoba) {
		this.dialog=dialOsoba;	}
	public void focusGained(FocusEvent arg0) {	}		//	nevyužito
	public void focusLost(FocusEvent arg0) {
		//System.out.println("Test");					//	test
		String temp = dialog.getJmeno().getText();
		//System.out.println("Delka :"+temp.length());
		if(temp.length()==0){
			dialog.getJmeno().requestFocus();
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaJmeno,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);
			}
		else dialog.setNastJmeno(true);		}
}
/*	Old version 
  		System.out.println("Test");					//	test
		String temp = dialog.getJmeno().getText();
		System.out.println("Delka :"+temp.length());
		if(temp.length()==0){
			dialog.getJmeno().requestFocus();
			JOptionPane.showMessageDialog(null,texty.Text.vyjimkaJmeno,texty.Text.infoPozorOptionPane,JOptionPane.WARNING_MESSAGE);	}
		else dialog.setNastJmeno(true);		} 
*/
