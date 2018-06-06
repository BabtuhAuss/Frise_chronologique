package vue;

import java.util.Collection;

import modele.*;

import javax.swing.table.DefaultTableModel;


/**Modele de la table, qui va definir la présentation de la JTable d'annee
 * 
 * @author Baptiste
 *
 */
public class ModeleTable extends DefaultTableModel {

	private String val_annee[];
	
	public ModeleTable(int periode, Frise parFrise) {

		int duree_frise = parFrise.getAnneeFin() - parFrise.getAnneeDebut();

		this.setColumnCount(duree_frise);
		this.setRowCount(4);

		val_annee = new String[duree_frise];

		for (int i = 0; parFrise.getAnneeDebut() + i < parFrise.getAnneeFin(); i++) {
			if (i % periode == 0) {
				val_annee[i] = "" + (parFrise.getAnneeDebut() + i);
			} else {
				val_annee[i] = " ";
			}

		}
		this.setColumnIdentifiers(val_annee);
		// Ajout des evenements dans la table
		for (int i = 0; i < val_annee.length; i++) {
			Collection<Evenement> evtsAnnee = parFrise.getEvenementAnnee(parFrise.getAnneeDebut() + i);
			if (evtsAnnee != null) {
				for (Evenement evt : evtsAnnee)
					ajoutEvenement(evt, i);
			}

		}

	}// constructeur

	
	/**methode qui permet d'ajouter un evenement sur la JTable
	 * 
	 * @param evt l'evenement a ajouter 
	 * @param i l'annee en question, ou l'on va rajouter l'evenement
	 */
	public void ajoutEvenement(Evenement evt, int i) {
		int indiceColonne = i;
		int indiceLigne = 0;
		while (indiceLigne < 5 && getValueAt(indiceLigne, indiceColonne) != null) {
			indiceLigne++;
		}
		setValueAt(evt, indiceLigne, indiceColonne);
	}// ajoutEvenement

	public Class getColumnClass(int indice) {
		return Evenement.class;
	}
}// Classe
