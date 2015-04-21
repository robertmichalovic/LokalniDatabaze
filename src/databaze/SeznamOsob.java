package databaze;
/*  SINGLETON - typicke zapouzdreni mnoziny Osob - trida disponujici seznamem objektu OSOBA
 * 
 */
import java.util.*;
public final class SeznamOsob {
	private Set<Osoba> databaze = new HashSet<Osoba>(); 						// vytvorime privatni mnozinu neboli kolekci
	public Set<Osoba> getDatabaze(){ return databaze;	}						//	getter - ukladani pro soubor atd..
	public void nastavDatabazi(Set<Osoba> datab){	this.databaze=datab;	}	//	setter - nacitani ze souboru
	private static SeznamOsob thisSingleton; 									// deklarujem privatni staticky objekt dostupny metodou
	public static SeznamOsob getInstance() {
		if (thisSingleton == null) { thisSingleton = new SeznamOsob();} 			//	pokud databaze osob nema referenci(nema vytvoreny objekt) vyrob objekt databaze osob
		return thisSingleton;	}
	public void pridejOsoba(Osoba osoba) { databaze.add(osoba);} 					// 	metoda ktera pridava objekty
	public void vymazDatabazi(){	databaze.clear();	}
	public Collection<Osoba> ziskatVseOsoby() {
		return Collections.unmodifiableSet(databaze);	}
	public void odeberOsoba(Osoba osoba1) { 				//	metoda odeberouci objekt s kolekce
		//System.out.println("metoda odeber");
		for(Iterator<Osoba> iter = databaze.iterator();iter.hasNext();) {
			Osoba osoba2 = iter.next();
			//System.out.println("Osoba 1 : "+osoba1+"\nOsoba 2 : "+osoba2);
			//System.out.println("iterator ");
			if(osoba1.equals(osoba2))  {
				databaze.remove(osoba2);
				break;	}	}	}
	/*****	POMOCNA METODA PRO VYPIS KOLEKCE   ******/
	public void testTiskKolekceKonzole() { 										// vytiskneme kolekci do konzoly pres iterator 
		System.out.println("Tisk cele databaze");
		for(Iterator<Osoba> iter = databaze.iterator();iter.hasNext();) {
			System.out.println("Osoba :"+iter.next());	}	}
	/*
	@SuppressWarnings("unused")
	private void testTiskMaticeObjektu() {
		System.out.println("Tisk matice objektu");
		for(int i=0;i<maticePrvku.length;i++){
			for(int j=0;j<maticePrvku[i].length;j++){
				System.out.print(maticePrvku[i][j]+" ");	}
			System.out.println();	}	}*/

}

//private static Object [][] polePrvku;//	 = {{"Robert","Michaloviè","Prace","608158204","info@sdf.fd","15.3.1980","178","65","muz"}};
//{{" "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "}};
