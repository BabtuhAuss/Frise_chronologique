package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	private int jour;
	private int mois;
	private int annee;

	/** Constructeur de Date utilisé pour le formulaire de création d'evenements
	 * 
	 * @param parJour
	 * @param parMois
	 * @param parAnnee
	 */
	public Date(int parJour, int parMois, int parAnnee) {
		jour = parJour;
		mois = parMois;
		annee = parAnnee;
		GregorianCalendar date = new GregorianCalendar(annee, mois - 1, jour);
	}

	public Date() {
		GregorianCalendar dateAuj = new GregorianCalendar();
		annee = dateAuj.get(Calendar.YEAR);
		mois = dateAuj.get(Calendar.MONTH) + 1; // janvier = 0, fevrier = 1...
		jour = dateAuj.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @return une chaine de caractères indiquant quel jour on est
	 */
	public String toString() {
		String chaine = new String();
		chaine = jour + " ";
		switch (mois) {
		case 1:
			chaine += "janvier ";
			break;
		case 2:
			chaine += "février ";
			break;
		case 3:
			chaine += "mars ";
			break;
		case 4:
			chaine += "avril ";
			break;
		case 5:
			chaine += "mai ";
			break;
		case 6:
			chaine += "juin ";
			break;
		case 7:
			chaine += "juillet ";
			break;
		case 8:
			chaine += "août ";
			break;
		case 9:
			chaine += "septembre ";
			break;
		case 10:
			chaine += "octobre ";
			break;
		case 11:
			chaine += "novembre ";
			break;
		case 12:
			chaine += "décembre" + " ";
			break;
		}
		chaine += annee;
		return chaine;
	}

	/** accesseur de la date
	 * 
	 * @return l'annee de la date
	 */
	public int getAnnee() {
		return annee;
	}

	/** accesseur du jour
	 * 
	 * @return le jour
	 */
	public int getJour() {
		return jour;
	}

	/** accesseur du mois
	 * 
	 * @return le mois
	 */
	public int getMois() {
		return mois;
	}

	/** accesseur de la classe
	 * 
	 * @return la date
	 */
	public Date getDate() {
		return this;
	}
}
