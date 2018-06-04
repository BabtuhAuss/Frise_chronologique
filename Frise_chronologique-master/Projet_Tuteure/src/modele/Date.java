package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jour;
	private int mois;
	private int annee;
	
	public Date (int parJour, int parMois, int parAnnee)   {   
		jour = parJour;
		mois = parMois;
		annee = parAnnee; 
		GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);			
	  }
	
	  public Date ()   { 
		  GregorianCalendar dateAuj = new GregorianCalendar ();
		  annee = dateAuj.get (Calendar.YEAR);
		  mois = dateAuj.get (Calendar.MONTH)+1; // janvier = 0, fevrier = 1...
		  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  }
	public String toString () {
	    String chaine = new String();
		chaine =jour + " ";
		switch (mois) {
			 case 1: chaine += "janvier"; break;
			 case 2: chaine += "février"; break;
			 case 3: chaine += "mars"; break;
			 case 4: chaine += "avril"; break;
			 case 5: chaine += "mai"; break;
			 case 6: chaine += "juin"; break;
			 case 7: chaine += "juillet"; break;
			 case 8: chaine += "août"; break;
			 case 9: chaine += "septembre"; break;
			 case 10: chaine += "octobre"; break;
			 case 11: chaine += "novembre"; break;
			 case 12: chaine += "décembre"+" "; break;
			}
		chaine +=annee;
		return chaine;
	  } 
	
	public static int dernierJourDuMois(int parMois, int parAnnee) {
		switch(parMois) {
		case 2:
			if(estBissextile(parAnnee)) 
				return 29;
			else
				return 28;
		case 4: case 6: case 9: case 11: return 30;
		default:
			return 31;
		}
	}
	
	private static boolean estBissextile(int parAnnee) {
		return parAnnee % 4 == 0 &&(parAnnee % 100 != 0 || parAnnee % 400 == 0);
	}
	
	public boolean estValide(Date parDate) {
		if(parDate.getJour() <= parDate.dernierJourDuMois(parDate.getMois(),parDate.getAnnee()))
			return true;
		return false;
	}
	
	
	public int getAnnee() { 
		return annee;
	}

	public int getJour() { 
		return jour;
	}

	public int getMois() { 
		return mois;
	}
	
	public Date getDate(){
		return this;
	}
}
