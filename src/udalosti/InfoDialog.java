//	Udalost zobrazujici info dialog s popisem a obrazkem
package udalosti;
import gui.dialog.Info;
import gui.frame.HlavniJFrame;

import java.awt.event.*;
public class InfoDialog implements ActionListener {  // menuInfo
	private HlavniJFrame frame;
	public InfoDialog(HlavniJFrame temp) {
		this.frame=temp;	}
	public void actionPerformed(ActionEvent e) {
		Info dialogInfo = new Info(frame);
		dialogInfo.setVisible(true);	}
}
