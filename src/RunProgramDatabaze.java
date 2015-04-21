//	SPOUSTECI TRIDA CELEHO PROGRAMU
import gui.frame.*;
import javax.swing.SwingUtilities;
public class RunProgramDatabaze {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	HlavniJFrame okno = new HlavniJFrame();				// objekt GUI
                okno.setVisible(true);	}	});	}
}
