package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/** Classe qui va avoir tout les evenements rangés par année et triés par valeur de l'evenement
 * @author Baptiste
 *
 */
public class Frise implements Serializable {

	private static final long serialVersionUID = 1L;
	// besoin d'un hash map pour trier en fonction d'une annÃ©e
	private HashMap<Integer, TreeSet<Evenement>> Hash_evt;
	// ce String est le nom de la frise qui est donné en parametre dans le
	// constructeur.
	private String intituler;
	int anneeDebut;
	int anneeFin;

	// cette variable sert a afficher par période les années sur le modele table. si
	// on a 5, alors, on écrira alors une année sur 5
	int periode;

	public Frise(String parIntitule, int parAnneeDebut, int parAnneeFin, int parPeriode) {
		Hash_evt = new HashMap<Integer, TreeSet<Evenement>>();
		intituler = parIntitule;
		anneeDebut = parAnneeDebut;
		anneeFin = parAnneeFin;

		// création d'une ArrayList pour pouvoir ecrire les dates dans la jtable
		// aisement dans la JTABLE aisement
		periode = parPeriode;
	}

	/*-----------------------------ACCESSEURS-----------------------------*/
	/**
	 * 
	 * @return l'annee de debut de la chronologie
	 */
	public int getAnneeDebut() {
		return anneeDebut;
	}

	/**
	 * 
	 * @return l'annee de fin de la chronologie
	 */
	public int getAnneeFin() {
		return anneeFin;
	}

	/**
	 * 
	 * @return le nombre d'annee que l'on souhaite afficher sur la table
	 */
	public int getPeriode() {
		return periode;
	}

	/** methode qui permet <strong> d'ajouter dans le bon ordre </strong> l'evenement
	 * dans la frise.
	 * 
	 * <p> les evenements sont triés par ordre du poid </p>
	 * 
	 *<p> <i>si, dans le hashmap, l'annee de l'evenement n'est pas présente<br>
	 *  alors on en creer une autre</i></p>
	 * 
	 *
	 * 
	 * 
	 * @param parEvt qui est l'évenement <i>à ajouter</i>
	 */
	public void ajout(Evenement parEvt) {

		Date date = parEvt.getDate();
		int annee_evt = date.getAnnee();

		if (Hash_evt.containsKey(annee_evt)) {
			Hash_evt.get(annee_evt).add(parEvt);
		}

		else {
			TreeSet<Evenement> liste = new TreeSet<Evenement>();
			liste.add(parEvt);
			Hash_evt.put(annee_evt, liste);
		}
	}

	/**renvoie simplement le nom de la frise
	 * 
	 */
	public String toString() {
		return intituler;
	}

	/** La methode transforme le hashmap en arrayList
	 * 
	 * @return la liste de touts les evenements sans clé, <br>
	 * utilisé dans le gestionnaire de cartes du panelAffichage
	 */
	public ArrayList<Evenement> getEvenements() {
		Collection<TreeSet<Evenement>> evts;
		evts = Hash_evt.values();
		ArrayList<Evenement> e = new ArrayList<Evenement>();

		for (TreeSet <Evenement> ev : evts) {
			Iterator <Evenement> iter = ev.iterator();
			while (iter.hasNext()) {
				e.add((Evenement) iter.next());
			}
		}

		return e;

	}

	/** renvoie une collection d'evenement d'une annee
	 * 
	 * @param numAnnee l'année où l'on veut tout les evenements
	 * @return tout les evenmeents de l'annee numAnnee
	 */
	public Collection<Evenement> getEvenementAnnee(int numAnnee) {
		return Hash_evt.get(numAnnee);
	}

}
