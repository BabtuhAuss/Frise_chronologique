package modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeSet;

public class Frise {
	
	
	
	//besoin d'un hash map pour trier en fonction d'une annÃ©e
	private HashMap <Integer, TreeSet<Evenement> > Hash_evt;
	//ce String est le nom de la frise qui est donné en parametre dans le constructeur.
	private String intituler;
	int anneeDebut;
	int anneeFin;
	
	//cette variable sert a afficher par période les années sur le modele table. si on a 5, alors, on écrira alors une année sur 5
	int periode;
	
	public Frise(String parIntitule, int parAnneeDebut, int parAnneeFin, int parPeriode) {
		Hash_evt = new HashMap <Integer, TreeSet<Evenement>>();
		intituler = parIntitule;
		anneeDebut = parAnneeDebut;
		anneeFin = parAnneeFin;
		
		
		//création d'une ArrayList pour pouvoir ecrire les dates dans la jtable aisement dans la JTABLE aisement
		periode = parPeriode;		
	}
	
	
	
	
	/*-----------------------------ACCESSEURS-----------------------------*/
	public int getAnneeDebut() {
		return anneeDebut;
	}

	public void setAnneeDebut(int anneeDebut) {
		this.anneeDebut = anneeDebut;
	}

	public int getAnneeFin() {
		return anneeFin;
	}

	public void setAnneeFin(int anneeFin) {
		this.anneeFin = anneeFin;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	
	
	
	
	
	public void ajout(Evenement parEvt){
		
		Date date = parEvt.getDate();
		int annee_evt = date.getAnnee();
		
		if(Hash_evt.containsKey(annee_evt)) {
			Hash_evt.get(annee_evt).add(parEvt);
		}
		else {
			TreeSet <Evenement> liste = new TreeSet <Evenement>();
			liste.add(parEvt);
			Hash_evt.put(annee_evt, liste);
		}
	}
	
	public String toString() {
		return "nom de la frise : "+intituler;
	}

	
	public Collection<Evenement> getEvenementAnnee(int numAnnee) {
		return Hash_evt.get(numAnnee);
	}
	
	
	public Collection<Evenement> getEvenementSemaine(Date date) {
		int numSemaine = date.getAnnee();
		return Hash_evt.get(numSemaine);
	}
}
