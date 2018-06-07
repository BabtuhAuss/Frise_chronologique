package controleur;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	/** methode qui va maintenir le systeme de gestion des actions sur les diff�rents panel (ajout d'evenements)
	 * 
	 * @param l'action qui est ajout� dans les diff�rents bouton sur les panels creation (+) et affichage (< >)
	 *
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals(panelCreation.CHOISIR_PHOTO)) { //Si l'on veut choisir une photo pour un �v�nement

			JFileChooser ouvrirPhoto = new JFileChooser();
			FileNameExtensionFilter monFiltre = new FileNameExtensionFilter("Images", "bmp", "gif", "jpg", "jpeg", "png"); //Les extensions accept�es

			ouvrirPhoto.setFileFilter(monFiltre); //On met le filtre
			ouvrirPhoto.setAcceptAllFileFilterUsed(false); //On accepte que les fichiers qui proviennent du filtre
			
			int resultatOuverture = ouvrirPhoto.showOpenDialog(panelCreation); //Alors on demande � l'utilisateur d'ouvrir la photo

			if (resultatOuverture == JFileChooser.APPROVE_OPTION) { //Si l'utilisateur a s�lectionn� un fichier
				panelCreation.getFieldImage().setText(ouvrirPhoto.getSelectedFile().getPath()); //Alors on rajoute au textfield du formulaire le chemin d'acc�s vers la photo
				System.out.print(ouvrirPhoto.getSelectedFile().getPath());
			}

		}
		
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
			panelCreation.reset();
		} else if (arg0.getActionCommand().equals("<")) {
			panelAffichage.evenement_precedent();
		} else if (arg0.getActionCommand().equals(">")) {
			panelAffichage.evenement_suivant();
		}
	}
}
