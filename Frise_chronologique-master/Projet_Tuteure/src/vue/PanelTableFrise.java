package vue;





import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import modele.*;

public class PanelTableFrise extends JPanel {

	private static final long serialVersionUID = 1L;
	ModeleTable modele;
	JTable tableAnneeEvt;
	Date today;
	Frise frise;
	
	public PanelTableFrise(Frise parFrise){
		frise = parFrise;
		modele = new ModeleTable(frise.getPeriode(), frise);
		
		tableAnneeEvt = new JTable(modele);
		
		tableAnneeEvt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	/*	tableAnneeEvt.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent evt){
				JTable table = (JTable)evt.getSource();
				ModeleTable modele = (ModeleTable)table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				JOptionPane.showMessageDialog(tableAnneeEvt, modele.getValueAt(rowIndex, colIndex));
			}

		});*/
		//tableAnneeEvt.setDefaultRenderer(Evenement.class, new CelluleRenderer());
		JScrollPane scroll = new JScrollPane(tableAnneeEvt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );

		//scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		//scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 50));
		
		
		scroll.setPreferredSize(new Dimension(1000,450));
		
		
		
		this.add(scroll);
		
		tableAnneeEvt.setRowHeight(100);
		
		
	}
/*	public void setDate(Date parDate){
		tableSemaine.setModel( new ModeleTable(parDate, agenda));
	}*/
}
