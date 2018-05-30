package modele;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
	private int jour;
	private int mois;
	private int annee;
	
	public Date (int parJour, int parMois, int parAnnee)   {   
		jour = parJour;
		mois = parMois;
		annee = parAnnee; 
		GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);			
	  }
	
	public String toString () {
	    String chaine = new String();
		chaine =jour + " ";
		switch (mois) {
			 case 1: chaine += "janvier"; break;
			 case 2: chaine += "f�vrier"; break;
			 case 3: chaine += "mars"; break;
			 case 4: chaine += "avril"; break;
			 case 5: chaine += "mai"; break;
			 case 6: chaine += "juin"; break;
			 case 7: chaine += "juillet"; break;
			 case 8: chaine += "ao�t"; break;
			 case 9: chaine += "septembre"; break;
			 case 10: chaine += "octobre"; break;
			 case 11: chaine += "novembre"; break;
			 case 12: chaine += "d�cembre"+" "; break;
			}
		chaine +=annee;
		return chaine;
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
