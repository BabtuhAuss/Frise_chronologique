package modele;

public class Evenement implements Comparable <Evenement> {

	private Date date;
	private int poid;
	private String titre;
	private String description;
	private String nom_image;
	
	/**
	 * @return the nom_image
	 */
	public String getNom_image() {
		return nom_image;
	}

	/**
	 * @param nom_image the nom_image to set
	 */
	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}

	/**
	 * @return the poid
	 */
	public int getPoid() {
		return poid;
	}

	/**
	 * @param poid the poid to set
	 */
	public void setPoid(int poid) {
		this.poid = poid;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	
	
	public Evenement(Date date, String titre, String description, int poid, String photo) {
		this.date = date;
		this.titre = titre;
		this.description = description;
		this.poid = poid;
		this.nom_image = photo;
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
		return titre;
	}

	public Evenement getEvt(){
		return this;
	}

	public Date getDate() {
		return date;
	}
	
	
}
