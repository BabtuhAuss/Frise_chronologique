package controleur;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vue.*;
import modele.*;

public class Controleur implements ActionListener {
	
	private Frise frise;
	private PanelCreation panelCreation;
	private PanelAffichage panelAffichage;

	/**
	 * Constructeur
	 * 
	 * @param le formulaire de creation d'un evenement
	 * @param la partie affichage du tableau et des diapos
	 */
	public Controleur(Frise parFrise, PanelCreation parCreation, PanelAffichage parAffichage) {
		frise = parFrise;
		panelCreation = parCreation;
		panelAffichage = parAffichage;

		panelCreation.enregistreEcouteur(this);
		panelAffichage.enregistreEcouteur(this);
	}
	/** methode qui va maintenir le systeme de gestion des actions sur les différents panel (ajout d'evenements)
	 * 
	 * @param l'action qui est ajouté dans les différents bouton sur les panels creation (+) et affichage (< >)
	 *
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("+")) {
			frise.ajout(panelCreation.getEvenement());
			File monFichier = new File("Frises" + File.separator + frise.toString() + ".ser");
			try {
				LectureEcriture.ecriture(monFichier, frise);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			panelAffichage.setFrise(frise);
			panelAffichage.ajoutPanel(panelCreation.getEvenement());
		} else if (arg0.getActionCommand().equals("<")) {
			panelAffichage.evenement_precedent();
		} else if (arg0.getActionCommand().equals(">")) {
			panelAffichage.evenement_suivant();
		}
	}
}
