package vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.Date;
import modele.Evenement;
import modele.Frise;
import modele.LectureEcriture;

@SuppressWarnings("serial")
public class PanelFils extends JPanel implements ActionListener {

	String[] intitule_cartes = { "Creation", "Affichage", "?", "Frise" };
	CardLayout gestionnaireDeCartes;
	Frise maFrise;
	PanelCreation creation;
	PanelAffichage affichage;
	Controleur controleur;

	public PanelFils() {

		int taille_dossier = new File("Frises").listFiles().length;
		if (taille_dossier != 0) {
			try {
				maFrise = (Frise) LectureEcriture.lecture(new File("Frises").listFiles()[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			nouvelleFrise();

		this.removeAll();
		creation = new PanelCreation(maFrise);
		affichage = new PanelAffichage(maFrise);

		gestionnaireDeCartes = new CardLayout(5, 5);
		this.setLayout(gestionnaireDeCartes);

		this.add(creation, intitule_cartes[0]);

		this.add(affichage, intitule_cartes[1]);

		controleur = new Controleur(maFrise, creation, affichage);
	}

	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		if (actionCommand.equals("Creation")) {
			gestionnaireDeCartes.show(this, intitule_cartes[0]);
		}
		if (actionCommand.equals("Affichage")) {
			gestionnaireDeCartes.show(this, intitule_cartes[1]);
		}
		if (actionCommand.equals("?")) {
			JOptionPane.showMessageDialog(null, "Ceci est fait par Castello Nicolas et Aussenac Baptiste");
		}
		if (actionCommand.equals("ouvrir une frise")) {

			
			
			JFileChooser ouvrirFrise = new JFileChooser();
			int resultatOuverture = ouvrirFrise.showOpenDialog(this); //Alors on demande à l'utilisateur d'ouvrir le fichier correspondant

			if (resultatOuverture == JFileChooser.APPROVE_OPTION) { //Si l'utilisateur a sélectionné un fichier

				File monFichier = ouvrirFrise.getSelectedFile(); //On récupère ce fichier
				
				boolean erreur = false;
				
				try {
					Frise maFriseTmp = (Frise) LectureEcriture.lecture(monFichier); //On déserialise ce fichier
					maFrise =  new Frise(maFriseTmp.toString(), maFriseTmp.getAnneeDebut(), maFriseTmp.getAnneeFin(), maFriseTmp.getPeriode(), maFriseTmp.getHashMapEvts(), ouvrirFrise.getSelectedFile().getPath()); //Et on le retourne d�serialis�
				}
				catch (FileNotFoundException e) { //Erreur si le fichier est inexistant
					e.printStackTrace();
					erreur = true;
				} 
				catch (IOException e) { //Erreur si le fichier est invalide
					e.printStackTrace();
					erreur = true;
				}
				finally {
					if (erreur) //Si il y a eu une erreur alors on affiche un message 
						JOptionPane.showMessageDialog(this, "Une erreur est survenue lors de l'ouverture du fichier !", "Erreur", JOptionPane.ERROR_MESSAGE);
					else //Sinon on sort de la boucle pour continuer le programme
						;
				}

			} //if
			
			
			
			/*String nomFrise = JOptionPane.showInputDialog(null, "Nom de la frise.ser:", "ouvrir une frise",
					JOptionPane.QUESTION_MESSAGE);

			File monFichier = new File("Frises" + File.separator + nomFrise);
			if (monFichier.length() != 0) {
				try {
					maFrise = (Frise) LectureEcriture.lecture(monFichier);
					affichage.setTitreAffichage(maFrise.toString());
					affichage.setFrise(maFrise);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}*/
			
			
			
			affichage = new PanelAffichage(maFrise);
			creation = new PanelCreation(maFrise);
			this.removeAll();
			this.add(creation, intitule_cartes[0]);

			this.add(affichage, intitule_cartes[1]);
			controleur = new Controleur(maFrise, creation, affichage);
		}

		if (actionCommand.equals("Nouvelle frise")) {
			nouvelleFrise();
		}

		if (actionCommand.equals("Fermer")) {
			int saisi = JOptionPane.showConfirmDialog(this, "veux-tu vraiment quitter ca petit ?", "QUITTER ?",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch (saisi) {
			case JOptionPane.CLOSED_OPTION:
				break;
			case JOptionPane.OK_OPTION:
				System.exit(0);
				break;
			case JOptionPane.CANCEL_OPTION:
				break;

			}

		}
	}

	public void nouvelleFrise() {
		boolean fini = true;
		String nom = JOptionPane.showInputDialog(null, "Titre de la frise:", "Nouvelle frise",
				JOptionPane.QUESTION_MESSAGE);

		while (fini) {
			if (nom.isEmpty()) {
				JOptionPane.showMessageDialog(null, JOptionPane.QUESTION_MESSAGE, "le nom est vide !", 0);
				nom = JOptionPane.showInputDialog(null, "Titre de la frise:", "Nouvelle frise",
						JOptionPane.QUESTION_MESSAGE);
				fini = true;
			} else {
				fini = false;
			}
		}

		String debut = JOptionPane.showInputDialog(null, "Annee de debut de la frise:", "Nouvelle frise",
				JOptionPane.QUESTION_MESSAGE);
		String fin = JOptionPane.showInputDialog(null, "Annee de fin de la frise:", "Nouvelle frise",
				JOptionPane.QUESTION_MESSAGE);
		String intervale = JOptionPane.showInputDialog(null, "Annee a aficher:", "Nouvelle frise",
				JOptionPane.QUESTION_MESSAGE);

		maFrise = new Frise(nom, Integer.parseInt(debut), Integer.parseInt(fin), Integer.parseInt(intervale));
		File monFichier = new File("Frises" + File.separator + nom + ".ser");
		try {
			LectureEcriture.ecriture(monFichier, maFrise);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		affichage = new PanelAffichage(maFrise);
		creation = new PanelCreation(maFrise);
		this.removeAll();
		this.add(creation, intitule_cartes[0]);

		this.add(affichage, intitule_cartes[1]);
		controleur = new Controleur(maFrise, creation, affichage);

	}
}
