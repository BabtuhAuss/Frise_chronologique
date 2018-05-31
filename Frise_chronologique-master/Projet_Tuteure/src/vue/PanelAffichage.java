package vue;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Frise;

public class PanelAffichage extends JPanel {
	
	public PanelAffichage(Frise parFrise){
		
		
		this.setLayout(new BorderLayout(20,20));
		JLabel intituleFrise = new JLabel(parFrise.toString());
		JPanel diapoEvent = new JPanel();
		PanelTableFrise frise = new PanelTableFrise(parFrise);
		
		
		
		
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(frise, BorderLayout.SOUTH);
		
		
		
		
		/**/
		
	}
}
