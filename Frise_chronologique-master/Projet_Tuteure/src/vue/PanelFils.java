package vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.Date;
import modele.Evenement;
import modele.Frise;


@SuppressWarnings("serial")
public class PanelFils extends JPanel implements ActionListener {
	String[] intitule_cartes = {"Creation","Affichage","?"};
	CardLayout gestionnaireDeCartes;
	
	public PanelFils(){
		
		Frise maFrise = new Frise("la vie de baptiste", 2000, 2018);
		
		Evenement evt1 = new Evenement(new Date(), "titre", "description", 2);
		Evenement evt2 = new Evenement(new Date(5,8,2018),"titre2","description2",1);
		
		maFrise.ajout(evt1);
		maFrise.ajout(evt2);
		
		System.out.println(maFrise.getEvenementAnnee(2018));
		
		
		
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		PanelCreation creation = new PanelCreation();
		this.add(creation, intitule_cartes[0]);
		
		PanelAffichage affichage = new PanelAffichage();
		this.add(affichage, intitule_cartes[1]);
		gestionnaireDeCartes.show(this, intitule_cartes[0]);

		Controleur controleur = new Controleur(creation, affichage);
	}

	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		if(actionCommand.equals("Creation")){
			gestionnaireDeCartes.show(this, intitule_cartes[0]);
		}
		if(actionCommand.equals("Affichage")){
			gestionnaireDeCartes.show(this, intitule_cartes[1]);
		}
		if(actionCommand.equals("?")){
			JOptionPane.showMessageDialog(null, "Ceci est fait par Castello Nicolas et Aussenac Baptiste");
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
