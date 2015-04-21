package gui.frame;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;

import java.awt.*;

import javax.swing.*;

import udalosti.*;
public class JMenuBar extends javax.swing.JMenuBar {
	private static final long serialVersionUID = 592694593273276276L;
	private JMenuItem menu1volba1,menu1volba2,menu1volba3,menu1volba4,menu1volba5,menu1volba6,
					menu2volba1,menu2volba2,menu2volba3,menu3volba1,menu3volba2;
	public JMenuItem getMenu1Volba2() { return menu1volba2; }
	public JMenuItem getMenu1Volba3() { return menu1volba3; }
	public JMenuItem getMenu1Volba5() { return menu1volba5; }
	public JMenuItem getMenu2Volba2() { return menu2volba2; }
	public JMenuItem getMenu2Volba3() { return menu2volba3; }
	JMenuBar(HlavniJFrame frame){														//	konstruktor
		JMenu menu1 = new JMenu(texty.Text.Menu1);
		this.add(menu1);
		menu1.setMnemonic('S');
		JMenu menu2 = new JMenu(texty.Text.Menu2);
		this.add(menu2);
		menu2.setMnemonic('U');
		JMenu menu3 = new JMenu(texty.Text.Menu3);
		this.add(menu3);
		menu3.setMnemonic('I');
		
		menu1volba1 = new JMenuItem(texty.Text.Menu1moznost1);
		menu1.add(menu1volba1);			//	vymaze celou tabulku a vytvori novou
		menu1volba1.setAccelerator(KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK)); 
		menu1volba1.addActionListener(new SmazDatab(frame));
		menu1volba2 = new JMenuItem(texty.Text.Menu1moznost2);
		menu1.add(menu1volba2);
		menu1volba2.setEnabled(false);
		menu1volba2.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK)); 
		//menu1volba2.addActionListener(new UdalostUlozDatab(this));
		menu1volba3 = new JMenuItem(texty.Text.Menu1moznost3);
		menu1.add(menu1volba3);
		menu1volba3.setEnabled(false);
		menu1volba3.addActionListener(new UlozDatab(frame));
		menu1volba4 = new JMenuItem(texty.Text.Menu1moznost4);
		menu1.add(menu1volba4);
		menu1volba4.addActionListener(new NactiDatab(frame));
		menu1volba4.setAccelerator(KeyStroke.getKeyStroke('L', CTRL_DOWN_MASK));
		menu1volba5 = new JMenuItem(texty.Text.Menu1moznost5);
		menu1.add(menu1volba5);
		menu1volba5.setEnabled(false);
		menu1volba5.addActionListener(new SmazDatab(frame));
		menu1volba5.setAccelerator(KeyStroke.getKeyStroke('D', CTRL_DOWN_MASK));
		
		menu1.addSeparator();
		menu1volba6 = new JMenuItem(texty.Text.Menu1moznost6);
		menu1.add(menu1volba6);
		menu1volba6.setAccelerator(KeyStroke.getKeyStroke('Q', CTRL_DOWN_MASK)); // Umozni klavesovou zkratku CTRL+Q + nutny staticky import 
		menu1volba6.addActionListener(new KonecProgramu()); 				// Vytvori objekt z tridy UdalostExit
		
		menu2volba1 = new JMenuItem(texty.Text.Menu2moznost1);
		menu2.add(menu2volba1);
		menu2volba1.addActionListener(new VytvorOsobu(frame)); 			// Vytvori objekt z tridy UdalostNovaOsoba
		menu2volba2 = new JMenuItem(texty.Text.Menu2moznost2);
		menu2.add(menu2volba2);
		menu2volba2.addActionListener(new UpravOsobu(frame));
		menu2volba2.setEnabled(false);
		menu2volba3 = new JMenuItem(texty.Text.Menu2moznost3);
		menu2.add(menu2volba3);
		menu2volba3.setEnabled(false);
		menu2volba3.addActionListener(new SmazOsobu(frame));
		
		menu3volba1 = new JMenuItem(texty.Text.Menu3moznost1);
		menu3.add(menu3volba1);
		menu3volba2 = new JMenuItem(texty.Text.Menu3moznost2);
		menu3.add(menu3volba2); 
		menu3volba2.addActionListener(new InfoDialog(frame));	}
	protected void paintComponent(Graphics g) {							//	gradient pozadi
        if (g instanceof Graphics2D) {
        	Paint p = new GradientPaint(0, 0, Color.green, getWidth(),getHeight(), Color.blue, true);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(p);
            g2d.fillRect(0, 0, getWidth(), getHeight());	}	}

}
