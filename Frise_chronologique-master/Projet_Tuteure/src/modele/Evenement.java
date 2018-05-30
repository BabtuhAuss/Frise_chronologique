package modele;

public class Evenement implements Comparable <Evenement> {

	private Date date;
	private int poid;
	private String titre;
	private String description;
	
	public Evenement(Date date, String titre, String description, int poid) {
		this.date = date;
		this.titre = titre;
		this.description = description;
		this.poid = poid;
	}
	
	public int compareTo(Evenement evt){
		if(poid < evt.poid)
			return -1;
		else if(poid > evt.poid)
			return 1;
		else
			return 0;
	}
	
	public String toString(){
		return "Titre :"+ titre+"\nDescription :"+description+"\n à la date:"+date+"\nPoid :"+poid;
	}

	public Evenement getEvt(){
		return this;
	}
}
