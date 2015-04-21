package gui.dialog;
/* Pridani obrazku pres Eclipse do Package Exploreru
 *  tvz. zvolim adresar do kteroho to chci vlozit - File - New - Other - General - File - vyberu adresar - Advanced - browser - najdu soubor - FINISH
 */
import gui.frame.HlavniJFrame;

import java.awt.*;
import java.io.*;

import javax.swing.*;
class DialogInfoObrazek extends JPanel {
	private static final long serialVersionUID = 4051077290865531433L;
	DialogInfoObrazek() { 
		this.setBounds(1,1,250,470);	} // nastaveni v absolutnich souradnicich
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    Image img1 = Toolkit.getDefaultToolkit().getImage("logo.jpg");
	    g2.drawImage(img1, 0, 0, this);
	    g2.finalize();	}
}
class DialogInfoPopis extends JPanel {
	private static final long serialVersionUID = -7457280685770485161L;
	private String text;
	void NacteniSouboru() throws IOException {
		FileReader soubor = new FileReader("InfoProgram");
		BufferedReader nactenySoubor = new BufferedReader(soubor);
		while((text = nactenySoubor.readLine()) != null) {
			
		}
		soubor.close();nactenySoubor.close();
	}
	DialogInfoPopis() {//throws IOException { // konstruktor
		/*try	{	NacteniSouboru();	}
		catch(Exception e) {	System.out.println("Nacteni souboru InfoProgram: "+getClass().getName()); 	}

		JLabel info = new JLabel();
		this.add(info);	
		info.setText(text);*/
		this.setBounds(255,5,200,470);
		this.setBackground(Color.white);
		}
	public String getText() {	return text;	}
	public void setText(String text) {	this.text = text;	}

}
public class Info extends JDialog{
	private static final long serialVersionUID = 3518127210684714955L;
	@SuppressWarnings("unused")
	private HlavniJFrame frame;
	private void NastaveniUmisteniDialogu() {
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int sirkaObrazovky = maxBounds.width;
		int vyskaObrazovky = maxBounds.height;
		this.setSize(450,500);
		this.setLocation((sirkaObrazovky-450)/2,(vyskaObrazovky-500)/2);	}	//	umisteni okna
	void NastaveniOkna(){
		super.setTitle(" O Programu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// zajisti ukonceni Dialogu bez ukonceni aplikace
		//this.setBounds(1150, 100, 450, 500 );
		NastaveniUmisteniDialogu();
		this.getContentPane().setBackground(Color.white);
	    this.setLayout(null); } 									// nastaveni absolutni layoutu
	public Info(HlavniJFrame frame) { 											// konstruktor
		super(frame,true);							//	nastavime modal na true - neni umozneno praci s Frame pri aktivaci dialogu
		NastaveniOkna(); 
		this.frame=frame;
		
		DialogInfoObrazek logoObrazek = new DialogInfoObrazek();
		this.add(logoObrazek);
				
		DialogInfoPopis texty = new DialogInfoPopis();
		this.add(texty); }											// pridame panel do hlavniho okna
}
