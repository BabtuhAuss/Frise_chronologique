package vue;





import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import modele.*;

public class PanelTableFrise extends JPanel {

	private static final long serialVersionUID = 1L;
	ModeleTable modele;
	JTable tableSemaine;
	Date today;
	public PanelTableFrise(){
		today = new Date(30,05,2018);
		modele = new ModeleTable(today);
		tableSemaine = new JTable(modele);
		tableSemaine.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableSemaine.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent evt){
				JTable table = (JTable)evt.getSource();
				ModeleTable modele = (ModeleTable)table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				JOptionPane.showMessageDialog(tableSemaine, modele.getValueAt(rowIndex, colIndex));
			}

		});
		tableSemaine.setDefaultRenderer(Evenement.class, new CelluleRenderer());
		JScrollPane scroll = new JScrollPane(tableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		this.add(scroll);
		
		
		
	}
/*	public void setDate(Date parDate){
		tableSemaine.setModel( new ModeleTable(parDate, agenda));
	}*/
}
