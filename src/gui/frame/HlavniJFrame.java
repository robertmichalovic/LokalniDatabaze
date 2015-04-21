package gui.frame;
import databaze.*;
import gui.panel.tabulka.Tabulka;
import java.awt.*;
import javax.swing.*;
import udalosti.JFrameFunkce;
public class HlavniJFrame extends JFrame {
	private static final long serialVersionUID = 1100251925094769893L;
	private Tabulka panelTabulka;
	public Tabulka getTabulkaPanel() { return panelTabulka; }
	private PanelTlacitek panelTlacitek;
	public PanelTlacitek getTlacPanel() { return panelTlacitek; }
	private JMenuBar lista;
	public JMenuBar getLista() {	return lista;	}
	@SuppressWarnings("unused")
	private SeznamOsob databaze;
	private int velikostOknaX=1000; int velikostOknaY=700;			//	velikost okna
	private void ZmenaGUI() {
		String LOOKANDFEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel"; 	// zvolen NIMBUS
		try{
			UIManager.setLookAndFeel(LOOKANDFEEL);
			SwingUtilities.updateComponentTreeUI(this);
			this.pack();	}
		catch(Exception e){	
			e.printStackTrace();	}	}
	private void NastaveniUmisteniOkna() {
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int sirkaObrazovky = maxBounds.width;
		int vyskaObrazovky = maxBounds.height;
		this.setSize(velikostOknaX,velikostOknaY);
		this.setLocation((sirkaObrazovky-velikostOknaX)/2,(vyskaObrazovky-velikostOknaY)/2);	}	//	umisteni okna na stred
	private void NastaveniOkna() {
		ZmenaGUI();
		NastaveniUmisteniOkna();
		JFrame.setDefaultLookAndFeelDecorated(true); 					//	pro hezci vzhled
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 			//	zajisti ukonceni aplikace
	    this.setLayout(new BorderLayout()); 	} 						
	private void PanelNastrojeMenu(){
		lista = new JMenuBar(this);									//	str.100 Herout GUI
		setJMenuBar(lista); 	}
	private void PanelTabulka(){
		panelTabulka = new Tabulka(this);  				// Panel pro tabulku - JTable GUI - tabulka zobrazujici data z databaze
		this.getContentPane().add(panelTabulka,BorderLayout.CENTER); }		// alternativne lze i this.add(panelTabulka);
	private void PanelTlacitek() {
		panelTlacitek = new PanelTlacitek(this); 				// Panel pro tlacitka	- levy panel - "Nová osoba"/"Smazat osobu"/"Upravit osobu"
		panelTlacitek.setPreferredSize(new Dimension(160,10));
		this.add(panelTlacitek ,BorderLayout.WEST); } 	// pridame panel do hlavniho okna
	public HlavniJFrame() { 												// konstruktor
		super.setTitle(texty.Text.nazevJFrame);							//	balicek.trida.promenna
		databaze = new SeznamOsob();									// objekt databaze + kolekce
		NastaveniOkna(); 
		PanelNastrojeMenu();											//	zavolame metodu pro pridani JMenu
		PanelTlacitek();												//	zavolame metodu pro pridani panelu tlacitek
		PanelTabulka();													//	zavolame metodu pro pridani panelu tabulky
		this.addComponentListener(new JFrameFunkce(this));
		this.addWindowListener(new JFrameFunkce(this));
	}
}
