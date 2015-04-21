package databaze;
import javax.swing.table.*;
public class TabulkaModel extends DefaultTableModel {
	private static final long serialVersionUID = 2908383612279474567L;
	public TabulkaModel(Object[][] maticePrvku, Object[] sloupce) {
		super(maticePrvku,sloupce);	}
	//	pokyn pro prezentaèní vrstvu, aby této buòce nedovolila zmìnu
	public boolean isCellEditable(int row, int column) {		
		return false;	}
}
