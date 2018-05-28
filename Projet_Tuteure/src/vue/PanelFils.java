package vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Controleur;


@SuppressWarnings("serial")
public class PanelFils extends JPanel implements ActionListener {
	String[] intitule_cartes = {"Calendrier","Formulaire","AgendaSemaine"};
	CardLayout gestionnaireDeCartes;
	
	public PanelFils(){
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		PanelCreation creation = new PanelCreation();
		this.add(creation, intitule_cartes[0]);
		
		PanelAffichage affichage = new PanelAffichage();
		this.add(affichage, intitule_cartes[1]);
		
		Controleur controleur = new Controleur(creation, affichage);
	}

	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		if(actionCommand.equals("Calendrier")){
			gestionnaireDeCartes.show(this, intitule_cartes[0]);
		}
		if(actionCommand.equals("Formulaire")){
			gestionnaireDeCartes.show(this, intitule_cartes[1]);
		}
		if(actionCommand.equals("AgendaSemaine")){
			gestionnaireDeCartes.show(this, intitule_cartes[2]);
		}
		if(actionCommand.equals("Fermer")){
			int saisi = JOptionPane.showConfirmDialog(this,"veux-tu vraiment quitter ca petit ?", "QUITTER ?",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			switch(saisi){
			case JOptionPane.CLOSED_OPTION:
				break;
			case JOptionPane.OK_OPTION:
				System.exit(0); break;
			case JOptionPane.CANCEL_OPTION:
				break;
			
			}
			
		}		
	}
}
