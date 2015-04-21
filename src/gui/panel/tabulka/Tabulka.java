package gui.panel.tabulka;
import gui.frame.HlavniJFrame;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import udalosti.ZjisteniPolohy;
import databaze.*;
public class Tabulka extends JPanel {
	private static final long serialVersionUID = -330375042055077451L;
	private int radek=0,sloupec=0;
	private HlavniJFrame frame;
	private JTable tabulka;
	private TabulkaModel tabulkaModel;
	private JScrollPane scrollPane;
	private Object sloupce[] = {texty.Text.labJmeno,texty.Text.labPrijmeni,texty.Text.labZamestani,texty.Text.labTelefon,
			texty.Text.labMail,texty.Text.labNarozeniny,texty.Text.labVyska,texty.Text.labVaha,texty.Text.labPohlavi };
	private Object [][] maticePrvku = null;
	public Object[][] getPolePrvku() {
		return maticePrvku;	}
	public void nastavMaticePrvku(Object[][] temp){
		this.maticePrvku = temp;	}
	public Object [] getNazvySloupcu(){
		return sloupce;	}
	public TabulkaModel getModelTabulka() { 
		return tabulkaModel;}
	private void NastaveniPanelu() {
		this.setLayout(new GridLayout());			//	zajistime zvetseni komponenty na celou plochu
		this.setBackground(Color.black); }			// lze zakomentovat - definovano kvuli zjisteni velikosti okna
	private void NastaveniTabulka(){
		tabulka = new JTable();
		tabulka.setAutoCreateRowSorter(true);								// provedeme umozneni setrideni
		tabulka.addMouseListener(new ZjisteniPolohy(frame,tabulka));		//	listener pro zjisteni radku a sloupce
		tabulkaModel = new TabulkaModel(this.maticePrvku,this.sloupce);
		tabulka.setModel(tabulkaModel);
		scrollPane = new JScrollPane(tabulka);
		scrollPane.setViewportView(tabulka);
		this.add(scrollPane);	}
	public void prevodNaObjectPole() {
		java.util.List<Object> seznam = new ArrayList<Object>(SeznamOsob.getInstance().getDatabaze());  					// predeme HashSet (SET] na Seznam objektu
		/*System.out.println("Test metody");										// seznam probehne pres iterator 
		for(Iterator<Object> iter = seznam.iterator();iter.hasNext();) {
			System.out.println("Osoba :"+iter.next());	}	*/
		Object[] objects = seznam.toArray();										// Seznam objektu prevedeme na pole objektu
		//System.out.println("Pole : "+Arrays.toString(objects));					// vypis pole
		//System.out.println("Velikost pole : "+objects.length);
		maticePrvku = new Object[objects.length][9]; 								// je nutne pole objektu nainicializovat - prvni je velikost pole 
		for (int i=0;i<objects.length;i++) {										// = poctu osob; a druhy rozmer je = poctu atributu
			String pomocna = objects[i].toString();  								// do pomocne promemne string prevedem cele pole objektu 
			//System.out.println("Pomoc : "+pomocna);
			String [] podretezce = pomocna.split(" ");  							// do pole stringu ulozime cely objekt stringu a oddelime je mezernikem
			/*System.out.println("Testovaci vypis celeho pole Stringu : "+podretezce.length);
			for(String temp : podretezce){
				System.out.println("1 : "+temp);	}*/
			for(int j=0;j<podretezce.length;j++) {     								// pro kazdy cyklus rovny poctu podretezcu
				Object hodPodretezce = podretezce[j];  								// vytvorime objekt hodnota podretezce do ktereho vlozime dany podretezec
				maticePrvku[i][j] = hodPodretezce;	}	} 							// do matice objektu provedeme ulozeni vsech podretezcu
	}		
	public void prevodNaObjectPoleFiltr(String pohlavi) {
		java.util.List<Object> seznam = new ArrayList<Object>(SeznamOsob.getInstance().getDatabaze());  					// predeme HashSet (SET] na Seznam objektu
		Object[] objects = seznam.toArray();										// Seznam objektu prevedeme na pole objektu
		//System.out.println("Pole : "+Arrays.toString(objects));					// vypis pole
		//System.out.println("Velikost pole : "+objects.length);
		int pocetMuz = 0,pocetZen=0;
		switch(pohlavi) {
			case texty.Text.checkMuz : {
				for(int i=0;i<objects.length;i++ ){
					//System.out.println("Vypis :"+objects[i]);
					String s = objects[i].toString();
					if(!s.endsWith(pohlavi)) {
						objects[i] = null;											//	vynulujeme radky s zenou
						pocetZen++;	} 	}
				maticePrvku = new Object[objects.length-pocetZen][9]; 				// je nutne pole objektu nainicializovat - prvni je velikost pole
				break;	}
			case texty.Text.checkZena :  {
				for(int i=0;i<objects.length;i++ ){
					//System.out.println("Vypis :"+objects[i]);
					String s = objects[i].toString();
					if(!s.endsWith(pohlavi)) {
						objects[i] = null;										//	vynulujeme radky s muzem
						pocetMuz++;	}	}
				maticePrvku = new Object[objects.length-pocetMuz][9]; 				// je nutne pole objektu nainicializovat - prvni je velikost pole
				break;	}	}
		//System.out.println("PocetMuz : "+pocetMuz+"\t"+pocetZen);
		int x=0;	//	pomocna promenna nutna pro pocet radku v maticePrvku
		for (int i=0;i<objects.length;i++) {										// = poctu osob; a druhy rozmer je = poctu atributu
			if(objects[i] == null) {	continue;	}		//	kdyz je vynulovany ukonci vnitrni cyklus a skoci do dalsi iterace
			String pomocna = objects[i].toString();  								// do pomocne promemne string prevedem cele pole objektu 
			//System.out.println("Pomoc : "+pomocna);
			String [] podretezce = pomocna.split(" ");  							// do pole stringu ulozime cely objekt stringu a oddelime je mezernikem
			/*****	TESTOVACI VYPIS **************   funguje OK ****/
			/*System.out.println("Testovaci vypis celeho pole Stringu : "+podretezce.length);
			for(String temp : podretezce){
				System.out.println("1 : "+temp);	}*/
			for(int j=0;j<podretezce.length;j++) {     								// pro kazdy cyklus rovny poctu podretezcu
				Object hodPodretezce = podretezce[j];  								// vytvorime objekt hodnota podretezce do ktereho vlozime dany podretezec
				//System.out.println("Hodnota X="+x+"\tj="+j+"\t\t"+hodPodretezce.toString());
				maticePrvku[x][j] = hodPodretezce;	}	 							// do matice objektu provedeme ulozeni vsech podretezcu
			x++;	}
	}
	public void vlozimeMaticiDoTabulky() {
		DefaultTableModel temp = (DefaultTableModel) tabulka.getModel();
		temp.setRowCount(0);													//	vymaze stavaci data z tabulky
		//System.out.println("TEst PanelTabulka\n"+maticePrvku.length);
		Object [] poleTemp= new Object[maticePrvku[0].length];					// deklarujeme a alokujeme pole objektu
		Object slovo;															// deklarujeme docasny object slovo
		for(int i=0;i<maticePrvku.length;i++){
			for(int j=0;j<maticePrvku[i].length;j++){
				slovo = maticePrvku[i][j];										// do slova ulozime objekty na radku
				//System.out.print(slovo.toString()+" ");
				poleTemp[j] = (Object)slovo;	}								// do pole objektu ulozime jednotlive slova na radku
			temp.addRow(poleTemp);	}	}										// vlozime cely radek objektu pro tabulku
	public void vymazemeTabulku(){
		DefaultTableModel temp = (DefaultTableModel) tabulka.getModel();
		maticePrvku=null;
		temp.setRowCount(0);	}												//	vymaze stavajici data z tabulky
	public Tabulka(HlavniJFrame hlavniOkno) { 								// konstruktor
		this.frame = hlavniOkno;
		NastaveniPanelu();
		NastaveniTabulka();	}
	public Insets getInsets() {									//	metoda definujici okraje vnitrnich komponent
		return new Insets(1,1,1,1);	}							//	vrch / vlevo / spodek / vpravo ..... v pixelech
	public int getRadek() {	return radek;	}
	public void setRadek(int radek) {	this.radek = radek;	}
	public int getSloupec() {	return sloupec;	}
	public void setSloupec(int sloupec) {	this.sloupec = sloupec;	}
}

//private Object radky[][] = {{"Robert","Michaloviè","Prace","608158204","info@sdf.fd","15.3.1980","178","65","muz"}};