package gui.frame;
import java.awt.*;

import javax.swing.*;

import udalosti.*;
public class PanelTlacitek extends JPanel{
	private static final long serialVersionUID = 3293999039675418513L;
	private JButton novaOsobaBT,smazOsobaBT,editOsobaBT,smazDataBT,ulozDatabBT,nacDataBT,konecBT;
	private JLabel filtr;
	private JCheckBox muz,zena;
	private HlavniJFrame frame;
	public HlavniJFrame ziskejHlavniFrame() { return frame; }
	public JButton getSmazOsoba() 	{ 	return smazOsobaBT; }
	public JButton getEditOsoba()	{	return editOsobaBT; }
	public JButton getSmazDatab()	{	return smazDataBT;	}
	public JButton getUlozDatab()	{	return ulozDatabBT;	}
	public PanelTlacitek(HlavniJFrame hlavniOkno) {
		this.frame = hlavniOkno;
		this.setLayout(null); 			// nutne nebot defaultne je BorderLayout, pokud chci absolutni razeni, pak jej musim deaktivoat
		 
		novaOsobaBT = new JButton(texty.Text.Menu2moznost1);
		novaOsobaBT.setBounds(15,20,120,30);
		this.add(novaOsobaBT);
		novaOsobaBT.addActionListener(new VytvorOsobu(frame));
		 
		smazOsobaBT = new JButton(texty.Text.Menu2moznost3);
		smazOsobaBT.setBounds(15,80,120,30);					//	60px - vyska
		this.add(smazOsobaBT);
		smazOsobaBT.addActionListener(new SmazOsobu(frame));
		smazOsobaBT.setEnabled(false);
		 
		editOsobaBT = new JButton(texty.Text.Menu2moznost2);
		editOsobaBT.setBounds(15,140,120,30);					//	60px - vyska
		this.add(editOsobaBT);
		editOsobaBT.addActionListener(new UpravOsobu(frame));
		editOsobaBT.setEnabled(false);
		
		smazDataBT = new JButton(texty.Text.Menu1moznost5);
		smazDataBT.setBounds(15,200,120,30);					//	60px - vyska
		this.add(smazDataBT);
		smazDataBT.addActionListener(new SmazDatab(frame));
		smazDataBT.setEnabled(false);
		
		ulozDatabBT = new JButton(texty.Text.Menu1moznost2);
		ulozDatabBT.setBounds(15,260,120,30);					//	60px - vyska
		this.add(ulozDatabBT);
		ulozDatabBT.addActionListener(new UlozDatab(frame));
		ulozDatabBT.setEnabled(false);
		 
		nacDataBT = new JButton(texty.Text.Menu1moznost4);
		nacDataBT.setBounds(15,320,120,30);						//	60px - vyska
		this.add(nacDataBT);
		nacDataBT.addActionListener(new NactiDatab(frame));
		 
		konecBT = new JButton(texty.Text.konec);
		konecBT.setBounds(15,380,120,30);						//	60px - vyska
		this.add(konecBT);
		konecBT.addActionListener(new KonecProgramu());
		 
		filtr = new JLabel(texty.Text.filtr);
		filtr.setBounds(15,440,120,30);			//	30px - vyska
		this.add(filtr);
		 
		muz = new JCheckBox(texty.Text.muzi);
		muz.setBounds(15,470,120,30);			//	50px - vyska
		this.add(muz);
		muz.addItemListener(new MuziFiltr(frame));
		 
		zena = new JCheckBox(texty.Text.zeny);
		zena.setBounds(15,520,120,30);			
		this.add(zena);
		zena.addItemListener(new ZenaFiltr(frame));
		
		this.setVisible(true);	 	}
	protected void paintComponent(Graphics g) {				//	metoda vykreslujici gradient - prechod barev na pozadi
        if (g instanceof Graphics2D) {
        	Paint p = new GradientPaint(0, 0, Color.green, getWidth(),getHeight(), Color.blue, true);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(p);
            g2d.fillRect(0, 0, getWidth(), getHeight());	}	}
}

