package udalosti;
import gui.frame.*;
import java.awt.event.*;
public class MuziFiltr implements ItemListener {
	private HlavniJFrame frame;
	public MuziFiltr(HlavniJFrame frame) {
		this.frame=frame;	}
	private void nastavFiltr(){
		frame.getTabulkaPanel().vymazemeTabulku();					//	graficky vymazeme tabulku
		/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
		frame.getTabulkaPanel().prevodNaObjectPoleFiltr(texty.Text.checkMuz);
		/**** metoda ktera provede update tabulky dat ****/
		if(frame.getTabulkaPanel().getPolePrvku().length !=0)	//	kontrola na velikost pole, jinak vyjimka pri nule 
			frame.getTabulkaPanel().vlozimeMaticiDoTabulky();
	}
	private void deaktivFiltr(){
		frame.getTabulkaPanel().vymazemeTabulku();					//	graficky vymazeme tabulku
		/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
		frame.getTabulkaPanel().prevodNaObjectPole();
		/**** metoda ktera provede update tabulky dat ****/
		frame.getTabulkaPanel().vlozimeMaticiDoTabulky();
	}
	/***	nutne pokryt moznost aktivace filtru pred existenci databaze ***/
	public void itemStateChanged(ItemEvent arg0) {
		/**** 1 - true, 2 - false	****/
		//System.out.println("Info :"+arg0.getStateChange());
		if(frame.getTabulkaPanel().getPolePrvku()!=null){
			if(arg0.getStateChange() == 1 ){		//	aktivuje filtr
				nastavFiltr();	}
			if(arg0.getStateChange() == 2 ){		//	deaktivuje filtr
				deaktivFiltr();	}	}
	}
}
