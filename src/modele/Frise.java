package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Frise implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//besoin d'un hash map pour trier en fonction d'une année
	private HashMap <Integer, TreeSet<Evenement> > Hash_evt;
	//ce String est le nom de la frise qui est donn� en parametre dans le constructeur.
	private String intituler;
	int anneeDebut;
	int anneeFin;
	
	//cette variable sert a afficher par p�riode les ann�es sur le modele table. si on a 5, alors, on �crira alors une ann�e sur 5
	int periode;
	
	public Frise(String parIntitule, int parAnneeDebut, int parAnneeFin, int parPeriode) {
		Hash_evt = new HashMap <Integer, TreeSet<Evenement>>();
		intituler = parIntitule;
		anneeDebut = parAnneeDebut;
		anneeFin = parAnneeFin;
		
		
		//cr�ation d'une ArrayList pour pouvoir ecrire les dates dans la jtable aisement dans la JTABLE aisement
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
		return intituler;
	}

	
	public ArrayList <Evenement> getEvenements(){
		Collection<TreeSet<Evenement>> evts ;
		evts = Hash_evt.values();
		ArrayList<Evenement> e = new ArrayList<Evenement>();
		
		for(TreeSet ev : evts) {
			Iterator iter = ev.iterator();
			while(iter.hasNext()){
				e.add((Evenement) iter.next());
			}
		}
		
		return e;
		
	}
	
	public Collection<Evenement> getEvenementAnnee(int numAnnee) {
		return Hash_evt.get(numAnnee);
	}
	
}
