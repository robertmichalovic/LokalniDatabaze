package databaze;
import javax.swing.table.*;
public class TabulkaModel extends DefaultTableModel {
	private static final long serialVersionUID = 2908383612279474567L;
	public TabulkaModel(Object[][] maticePrvku, Object[] sloupce) {
		super(maticePrvku,sloupce);	}
	//	pokyn pro prezenta�n� vrstvu, aby t�to bu�ce nedovolila zm�nu
	public boolean isCellEditable(int row, int column) {		
		return false;	}
}
