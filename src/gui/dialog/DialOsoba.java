package gui.dialog;
import gui.frame.*;
import java.awt.*;
import javax.swing.*;
import kontroly.vstup.dialog.*;
public class DialOsoba extends JDialog {
	private static final long serialVersionUID = -528765418251487116L;
	private JTextField jmeno,prijmeni,zamestnani,telefon,mail,vyska,vaha,narozeniny;	//	nesmi private kvuli dedicnosti
	public JTextField getVaha() 		{	return vaha;	}
	public JTextField getVyska() 		{	return vyska;	}
	public JTextField getZamestnani() 	{	return zamestnani;	}
	public JTextField getPrijmeni() 	{	return prijmeni;	}
	public JTextField getTelefon() 		{	return telefon;	}
	public JTextField getJmeno() 		{	return jmeno;	}
	public JTextField getMail() 		{	return mail;	}
	public JTextField getNarozeniny() 	{	return narozeniny;	}
	private boolean nastJmeno,nastPrijme,nastZamest,nastTel,nastMail,nastVyska,nastVaha,nastNaroz,nastPohl;
	public boolean getNastJmeno()				{ 	return nastJmeno;	}
	public void setNastJmeno(boolean jmeno)		{	this.nastJmeno=jmeno;	}
	public boolean getNastPrijme()				{ 	return nastPrijme;	}
	public void setNastPrijme(boolean prijme)	{	this.nastPrijme=prijme;	}
	public boolean getNastZamest()				{ 	return nastZamest;	}
	public void setNastZamest(boolean zamest)	{	this.nastZamest=zamest;	}
	public boolean getNastTel()					{ 	return nastTel;	}
	public void setNastTel(boolean tel)			{	this.nastTel=tel;	}
	public boolean getNastMail()				{ 	return nastMail;	}
	public void setNastMail(boolean mail)		{	this.nastMail=mail;	}
	public boolean getNastVyska()				{ 	return nastVyska;	}
	public void setNastVyska(boolean vyska)		{	this.nastVyska=vyska;	}
	public boolean getNastVaha()				{ 	return nastVaha;	}
	public void setNastVahat(boolean vaha)		{	this.nastVaha=vaha;	}
	public boolean getNastNaroz()				{ 	return nastNaroz;	}
	public void setNastNaroz(boolean vyska)		{	this.nastNaroz=vyska;	}
	public boolean getNastPohl()				{ 	return nastPohl;	}
	public void setNastPohl(boolean vaha)		{	this.nastPohl=vaha;	}	
	protected Checkbox muz,zena;								//	puvodne default 
	public Checkbox getMuz() 			{	return muz;	}
	protected CheckboxGroup pohlavi;							//	puvodne default
	protected JButton okTlac,stornoTlac;						//	puvodne default
	public JButton getOkTlac() {	return okTlac;	}
	private void jmenoNastaveni(){
		JLabel labJmeno = new JLabel(texty.Text.labJmeno);				//	balicek.trida.promenna
		labJmeno.setBounds(20,20,70,30);
		labJmeno.setToolTipText(texty.Text.toolJmeno);
		getContentPane().add(labJmeno);
		jmeno = new JTextField();
		jmeno.setBounds(90,20, 190, 30);
		jmeno.setToolTipText(texty.Text.toolJmeno);
		jmeno.addFocusListener(new JmenoFocus(this));			//	kontrola na vstupni jmeno
		getContentPane().add(jmeno);	}
	private void prijmeniNastaveni(){
		JLabel labPrijm = new JLabel(texty.Text.labPrijmeni);
		labPrijm.setBounds(20,60,70,30);
		labPrijm.setToolTipText(texty.Text.toolPrijmeni);
		getContentPane().add(labPrijm);
		prijmeni = new JTextField();
		prijmeni.setBounds(90,60,190, 30);
		prijmeni.setToolTipText(texty.Text.toolPrijmeni);
		prijmeni.addFocusListener(new PrijmeFocus(this));			//	kontrola na vstupni jmeno
		getContentPane().add(prijmeni);	}
	private void telefonNastaveni(){
		JLabel labTelefon = new JLabel(texty.Text.labTelefon);
		labTelefon.setBounds(20,100,70,30);
		labTelefon.setToolTipText(texty.Text.toolTelefon);
		getContentPane().add(labTelefon);
		telefon = new JTextField();
		telefon.setBounds(90,100,190, 30);
		telefon.setToolTipText(texty.Text.toolTelefon);
		telefon.addFocusListener(new TelefonFocus(this));			//	kontrola na vstupni cislo
		getContentPane().add(telefon);	}
	private void zamestnaniNastaveni(){
		JLabel labPrace = new JLabel(texty.Text.labZamestani);
		labPrace.setBounds(20,140,70,30);
		labPrace.setToolTipText(texty.Text.toolZamestani);
		getContentPane().add(labPrace);
		zamestnani = new JTextField();
		zamestnani.setBounds(90,140,190, 30);
		zamestnani.setToolTipText(texty.Text.toolZamestani);
		getContentPane().add(zamestnani);	}
	private void mailNastaveni(){
		JLabel labMail = new JLabel(texty.Text.labMail);
		labMail.setBounds(20,180,70,30);
		labMail.setToolTipText(texty.Text.toolMail);
		getContentPane().add(labMail);
		mail = new JTextField();
		mail.setBounds(90,180,190, 30);
		mail.setToolTipText(texty.Text.toolMail);
		mail.addFocusListener(new MailFocus(this));					//	kontrola na zavinac a tecku
		getContentPane().add(mail);	}
	private void vyskaNastaveni(){
		JLabel labVyska = new JLabel(texty.Text.labVyska);
		labVyska.setBounds(20,220,70,30);
		labVyska.setToolTipText(texty.Text.toolVyska);
		getContentPane().add(labVyska);
		vyska = new JTextField();
		vyska.setBounds(90,220,190, 30);
		vyska.setToolTipText(texty.Text.toolVyska);
		getContentPane().add(vyska);	}
	private void vahaNastaveni(){
	    JLabel labVaha = new JLabel(texty.Text.labVaha);
	    labVaha.setBounds(20,260,70,30);
	    labVaha.setToolTipText(texty.Text.toolVaha);
		getContentPane().add(labVaha);
		vaha = new JTextField();
		vaha.setBounds(90,260,190, 30);
		vaha.setToolTipText(texty.Text.toolVaha);
		getContentPane().add(vaha);	}
	private void pohlaviNastaveni(){
	    JLabel labPohlavi = new JLabel(texty.Text.labPohlavi);
	    labPohlavi.setBounds(20,300,70,30);
	    getContentPane().add(labPohlavi);
	    pohlavi = new CheckboxGroup();
		muz = new Checkbox(texty.Text.checkMuz,pohlavi,false);
		muz.setBounds(90,300,70,30);
		getContentPane().add(muz);
		zena = new Checkbox(texty.Text.checkZena,pohlavi,false);
		zena.setBounds(160,300,190,30);
		getContentPane().add(zena);	}
	private void narozeninyNastaveni(){
	    JLabel labNarozeni = new JLabel(texty.Text.labNarozeniny);
	    labNarozeni.setBounds(20,340,120,30);
	    labNarozeni.setToolTipText(texty.Text.toolNarozeniny);
	    getContentPane().add(labNarozeni);
		narozeniny = new JTextField();
		narozeniny.setToolTipText(texty.Text.toolNarozeniny);
		narozeniny.addFocusListener(new NarozeninyFocus(this));					//	kontrola na tecky a velikost cisel
		narozeniny.setBounds(140,340,140, 30);
		getContentPane().add(narozeniny);	}
	private void NastaveniUmisteniDialogu() {
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int sirkaObrazovky = maxBounds.width;
		int vyskaObrazovky = maxBounds.height;
		this.setSize(300,500);
		this.setLocation((sirkaObrazovky-300)/2,(vyskaObrazovky-500)/2);	}	//	umisteni okna
	public DialOsoba(HlavniJFrame frame, boolean b) {			// konstruktor
		super(frame, true);					//	modal = true ... neumoznuje pracovat s hlavnim frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// zajisti ukonceni Dialogu bez ukonceni aplikace
		NastaveniUmisteniDialogu();
		this.setSize(300,500); 										// velikost okna
		this.setLayout(null);  										// nastaveni absolutni layoutu
		this.nastJmeno = this.nastPrijme = this.nastZamest = this.nastTel = this.nastMail = this.nastVyska = this.nastVaha = this.nastNaroz = this.nastPohl = false;
		//  nastaveni vstupnich textFieldu  		    
		jmenoNastaveni();
		prijmeniNastaveni();
		telefonNastaveni();
		zamestnaniNastaveni();
		mailNastaveni();
		vyskaNastaveni();    	
		vahaNastaveni();
		pohlaviNastaveni();
		narozeninyNastaveni();
		//	nastaveni kontrolnich tlacitek - zruseni a potvrzeni
		okTlac = new JButton(texty.Text.ok);
		okTlac.setEnabled(false);
		stornoTlac = new JButton(texty.Text.zrusit);
		okTlac.setBounds(180,410, 90, 35);
		stornoTlac.setBounds(80,410, 90, 35);
		getContentPane().add(okTlac);
		getContentPane().add(stornoTlac);	}
	/*	POZOR NESMI BYT LISTENER NA FOCUSLOST DVAKRAT V EDITBOXECH ZA SEBOU - problem s message boxem, vyhodi-li se vyjimka tak automaticky 
	 *  focus prenese na messagebox a to vyvola zbytecne druhou vyjimku .... pokusime se to obejit objektovou boolean promenou vyjimka.
	 */
}
