package udalosti;
import gui.frame.HlavniJFrame;
import java.awt.event.*;
public class ZenaFiltr implements ItemListener {
	private HlavniJFrame frame;
	public ZenaFiltr(HlavniJFrame frame) {
		this.frame=frame;	}
	private void nastavFiltr(){
		frame.getTabulkaPanel().vymazemeTabulku();					//	graficky vymazeme tabulku
		/*** metoda jenz prenese data z kolekce do pole Object [][] ***/
		frame.getTabulkaPanel().prevodNaObjectPoleFiltr(texty.Text.checkZena);
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
	public void itemStateChanged(ItemEvent e) {
		/**** 1 - true, 2 - false	****/
		//System.out.println("Info :"+e.getStateChange());
		if(frame.getTabulkaPanel().getPolePrvku()!=null){
			if(e.getStateChange() == 1 ){		//	aktivuje filtr - jdou videt zeny
				nastavFiltr();	}
			if(e.getStateChange() == 2 ){		//	deaktivuje filtr - pujdou videt vsichni
				deaktivFiltr();	}	}
	}
}
