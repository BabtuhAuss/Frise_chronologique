package modele;

public class Evenement {

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
	
	public String toString(){
		return "Titre :"+ titre+"\nDescription :"+description+"\n à la date:"+date+"\nPoid :"+poid;
	}

	public Evenement getEvt(){
		return this;
	}
	public int getPoid(){
		return this.poid;
	}
}
