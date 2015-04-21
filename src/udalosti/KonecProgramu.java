// trida overujici jestli program skuteène chceme ukoncit
package udalosti;
import java.awt.event.*;
import javax.swing.*;
public class KonecProgramu implements ActionListener {  						// Button Exit
	public void actionPerformed(ActionEvent e) {
		Object [] volba = {texty.Text.ano,texty.Text.ne};
		int n = JOptionPane.showOptionDialog(null,texty.Text.dotazKonec, texty.Text.nazevDialogu, 
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,volba,volba[0]);
		if (n == JOptionPane.YES_OPTION) System.exit(1);	}
}