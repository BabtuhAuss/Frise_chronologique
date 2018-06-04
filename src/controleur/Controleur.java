package controleur;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vue.*;
import modele.*;

public class Controleur implements ActionListener{
	Frise frise;
	PanelCreation panelCreation;
	PanelAffichage panelAffichage;
	/** Constructeur
	 * 
	 * @param creation
	 * @param affichage
	 */
	public Controleur(Frise parFrise, PanelCreation parCreation, PanelAffichage parAffichage) {
		frise = parFrise;
		panelCreation = parCreation;
		panelAffichage = parAffichage;
		
		panelCreation.enregistreEcouteur(this);
		panelAffichage.enregistreEcouteur(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("+")) {
			frise.ajout(panelCreation.getEvenement());
			File monFichier = new File("Frises" + File.separator + "frise_1.ser");
			try {
				LectureEcriture.ecriture(monFichier, frise);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			panelAffichage.setFrise(frise);
		}
		else if(arg0.getActionCommand().equals("<")) {
			panelAffichage.evenement_precedent();
		}
		else if(arg0.getActionCommand().equals(">")) {
			panelAffichage.evenement_suivant();
		}
	}
}
