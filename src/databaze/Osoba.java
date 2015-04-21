package databaze;
import java.io.Serializable;
public class Osoba implements Serializable{					//	objekt 
	private static final long serialVersionUID = -168406458183294251L;
	private String jmeno,prijmeni,zamestnani,telefon,mail,narozeni,vyska,vaha;
	public String getJmeno() 		{	return jmeno;	}
	public String getPrijmeni() 	{	return prijmeni;	}
	public String getZamestnani() 	{	return zamestnani;	}
	public String getTelefon() 		{	return telefon;	}
	public String getMail() 		{	return mail;	}
	public String getNarozeni() 	{	return narozeni;	}
	public String getVyska() 		{	return vyska;	}
	public String getVaha() 		{	return vaha;	}
	public void nastavJmeno(String jmeno) 			{ 	this.jmeno=jmeno; }
	public void nastavPrijmeni(String prijmeni) 	{	this.prijmeni=prijmeni; }
	public void nastavZamestnani(String zamestnani) {	this.zamestnani=zamestnani; }
	public void nastavTelefon(String telefon)		{	this.telefon=telefon;	}
	public void nastavMail(String mail)				{	this.mail=mail;	}
	public void nastavNarozeniny(String narozeniny)	{	this.narozeni=narozeniny; }
	public void nastavVyska(String vyska)			{	this.vyska=vyska;	}
	public void nastavVaha(String vaha)				{	this.vaha=vaha;	}
	private boolean pohlavi; 								// 	pohlavi true muz, false zena
	public boolean ziskejPohlavi(){	return pohlavi;	}
	public void nastavPohlavi(boolean pohlavi) { this.pohlavi=pohlavi;	}
	private String pohlavi(boolean pohlavi){				//	metoda 
		String text;
		if(pohlavi != true)text = texty.Text.checkZena;
		else text = texty.Text.checkMuz;
		return text;	}
	public Osoba(String jmeno,String prijmeni, String zamestnani,String telefon,String mail,		//	konstruktor
			String narozeni,String vyska,String vaha,boolean pohlavi){
		this.jmeno = jmeno;this.prijmeni = prijmeni;this.zamestnani = zamestnani;this.telefon=telefon;this.mail = mail;
		this.narozeni = narozeni; this.vyska = vyska; this.vaha = vaha;this.pohlavi=pohlavi;	}
	public static Osoba vytvorObjektOsoba(int radek,Object [][] matice){
		String jmeno,prijmeni,zamestnani,telefon,mail,narozeni,vyska,vaha,pohlaviString;
		boolean pohlavi = false;
		jmeno = (String)matice[radek][0].toString();
		prijmeni = (String)matice[radek][1].toString();
		zamestnani = (String)matice[radek][2].toString();
		telefon = (String)matice[radek][3].toString();
		mail = (String)matice[radek][4].toString();
		narozeni = (String)matice[radek][5].toString();
		vyska = (String)matice[radek][6].toString();
		vaha = (String)matice[radek][7].toString();
		pohlaviString = (String) matice[radek][8].toString();
		if(texty.Text.checkMuz.equals(pohlaviString)) pohlavi = true;
		//System.out.println("TEST : "+matice[radek][8].toString());
		Osoba temp = new Osoba(jmeno,prijmeni,zamestnani,telefon,mail,narozeni,vyska,vaha,pohlavi); 
		/** Kontrolni vypis ulozeneho objektu - vytvoreni objektu a vypis objektu funguje ***/
		//System.out.println("osobaNova :"+temp); 
		return temp;	}
	/*				 TENTO popis neni vhodny pro prevod stringu na pole proto je zablokovan
	public String toString() {return "Jmeno :"+jmeno+"\tPrijmeni :"+prijmeni+"\tZamestnani :"+zamestnani+"\tTelefon :"+telefon+
			"\tMail :"+mail+"\tNarozeny :"+narozeni+"\tVyska :"+vyska+"\tVaha :"+vaha+"\tPohlavi :"+pohlavi(pohlavi);}*/
	public String toString() {return ""+jmeno+" "+prijmeni+" "+zamestnani+" "+telefon+" "+mail+" "+narozeni+" "+vyska+
			" "+vaha+" "+pohlavi(pohlavi); }
	public boolean equals(Object o){		//	porovname objekty na data - PROTOZE POROVNAVAME STRINGY JE NUTNE EQUALS
		//System.out.println("Porovnavame 1");
		if(this == o) return true;
		//System.out.println("Porovnavame 2");
		if(o instanceof Osoba == false) return false;
		//System.out.println("Porovnavame 3");
		Osoba t =(Osoba) o;			//	PROTOZE POROVNAVAME STRINGY JE NUTNE EQUALS
		boolean jmeno = this.jmeno.equals(t.jmeno);
		boolean narozeni = this.narozeni.equals(t.narozeni);
		boolean prijmeni = this.prijmeni.equals(t.prijmeni);
		boolean telefon = this.telefon.equals(t.telefon);
		//System.out.println("Porovnavame 4"+jmeno+narozeni+prijmeni+telefon);
		return  jmeno && narozeni && prijmeni && telefon;
	}
}
