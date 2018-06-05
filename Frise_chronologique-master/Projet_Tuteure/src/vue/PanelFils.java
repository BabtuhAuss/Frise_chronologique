package vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.Date;
import modele.Evenement;
import modele.Frise;
import modele.LectureEcriture;


@SuppressWarnings("serial")
public class PanelFils extends JPanel implements ActionListener {
	
	String[] intitule_cartes = {"Creation","Affichage","?", "Frise"};
	CardLayout gestionnaireDeCartes;
	Frise maFrise = new Frise("la vie de baptiste", 2000, 2020, 5);
	PanelCreation creation = new PanelCreation();
	PanelAffichage affichage = new PanelAffichage(maFrise);
	
	public PanelFils(){
				
		System.out.println("evenements de début");
		System.out.println(maFrise.getEvenements());
		
		
		
		File monFichier = new File("Frises" + File.separator + "frise_1.ser");
		
		if (monFichier.length() != 0) {
			try {
				maFrise = (Frise) LectureEcriture.lecture(monFichier);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		this.add(creation, intitule_cartes[0]);
		
		this.add(affichage, intitule_cartes[1]);
		gestionnaireDeCartes.show(this, intitule_cartes[0]);

		Controleur controleur = new Controleur(maFrise, creation, affichage);
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
		if(actionCommand.equals("Ouvrire une frise")) {
			String nomFrise = JOptionPane.showInputDialog(null, "Nom de la frise:", "Ouvrire une frise", JOptionPane.QUESTION_MESSAGE);
		}
		
		if(actionCommand.equals("Nouvelle frise")) {
			String nom = JOptionPane.showInputDialog(null, "Titre de la frise:", "Nouvelle frise", JOptionPane.QUESTION_MESSAGE);
			String debut = JOptionPane.showInputDialog(null, "Annee de debut de la frise:", "Nouvelle frise", JOptionPane.QUESTION_MESSAGE);
			String fin = JOptionPane.showInputDialog(null, "Annee de fin de la frise:", "Nouvelle frise", JOptionPane.QUESTION_MESSAGE);
			String intervale = JOptionPane.showInputDialog(null, "Annee a aficher:", "Nouvelle frise", JOptionPane.QUESTION_MESSAGE);
			
			maFrise = new Frise(nom,Integer.parseInt(debut),Integer.parseInt(fin),Integer.parseInt(intervale));
			File monFichier = new File("Frises" + File.separator + nom+".ser");
			try {
				LectureEcriture.ecriture(monFichier, maFrise);
				affichage.setTitreAffichage(nom);
				affichage.setFrise(maFrise);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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
