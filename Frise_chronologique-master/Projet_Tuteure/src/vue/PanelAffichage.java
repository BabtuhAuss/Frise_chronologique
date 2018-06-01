package vue;

import java.awt.*;
import java.io.File;

import javax.swing.ImageIcon;
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
		
		/*COMPOSANTS POUR LE DIAPO EVENT*/
		
		File repertoire = new File("images");
		String[] intitules_images = repertoire.list();
		JLabel[] tabLabels = new JLabel[intitules_images.length];
		JPanel panImg = new JPanel();
		
		
		for (int i = 0; i < intitules_images.length; i++) 
			tabLabels[i] = new JLabel(new ImageIcon("images" + File.separator + intitules_images[i]));
		
		
		/*FIN DES COMPOSANTS DE DIAPO EVENT*/
		intituleFrise.setHorizontalAlignment(SwingConstants.CENTER);
		intituleFrise.setVerticalAlignment(SwingConstants.CENTER);
		
		
		
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(frise, BorderLayout.SOUTH);
		
		
		
		
		/**/
		
	}
}
