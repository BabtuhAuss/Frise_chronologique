package vue;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.Frise;

public class PanelAffichage extends JPanel {
	
	public PanelAffichage(Frise parFrise){
		
		
		this.setLayout(new BorderLayout(20,20));
		
		JLabel intituleFrise = new JLabel("<html><h1>"+parFrise.toString()+ "</h1></html>");
		intituleFrise.setLocation(100, 200);
		JPanel diapoEvent = new JPanel();
		PanelTableFrise frise = new PanelTableFrise(parFrise);
		
		intituleFrise.setHorizontalAlignment(SwingConstants.CENTER);
		intituleFrise.setVerticalAlignment(SwingConstants.CENTER);
		
		
		
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(frise, BorderLayout.SOUTH);
		
		
		
		
		/**/
		
	}
}
