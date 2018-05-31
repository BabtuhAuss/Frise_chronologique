package vue;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAffichage extends JPanel {
	
	String intitule[] = {"s0", "s1","s2","s3","s4"};
	public PanelAffichage(){
		this.setLayout(new BorderLayout(20,20));
		JLabel intituleFrise = new JLabel(intitule[0]);
		JPanel diapoEvent = new JPanel();
		PanelTableFrise frise = new PanelTableFrise();
		
		
		
		
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(frise, BorderLayout.SOUTH);
		
		
		
		
		/**/
		
	}
}
