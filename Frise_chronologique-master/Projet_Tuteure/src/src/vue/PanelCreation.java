package vue;
import java.awt.*;
import javax.swing.*;

import controleur.Controleur;
import modele.*;


@SuppressWarnings("serial")
public class PanelCreation extends JPanel{
	
	public final String NOM_BOUTON="+";
	public final String CHOISIR_PHOTO="Choisir";
	
	private JButton boutonPhoto = new JButton(CHOISIR_PHOTO);
	private JButton boutonAjout = new JButton(NOM_BOUTON);	
	private JTextField fieldTitre = new JTextField(14);
	private JLabel labelFieldImage= new JLabel();
	private JTextArea area = new JTextArea(10,15);
	
	private JComboBox choixPoids;
	private JComboBox choixJour;
	private JComboBox choixMois;
	private JComboBox choixAnnee;
	
	
	public PanelCreation(Frise frise){
	
		//a enlever peutaitre
		/*GregorianCalendar dateAuj = new GregorianCalendar ();
		int anneeActuelle = dateAuj.get (Calendar.YEAR);*/
		int totaleAnnee = frise.getAnneeFin()-frise.getAnneeDebut()+1;//(anneeActuelle - 1582)+1;
		
		JLabel labelPoids = new JLabel("Poids");
		String choix_jour[] = new String [31];
		String choix_mois[] = new String [12];
		String choix_annee[]= new String[totaleAnnee];
		String choix_poids[] = {"0","1","2","3"};
		
		for(int jour=1;jour<=31;jour++) {
			choix_jour[jour-1]=""+jour;
		}
		
		for(int mois=1;mois<=12;mois++) {
			choix_mois[mois-1]=""+mois;
		}
		
		//int annee=anneeActuelle;
		int annee=frise.getAnneeFin();
		for(int i=0;i<totaleAnnee;i++) {
			choix_annee[i]=""+annee;
			annee=annee-1;
		}
		
		choixPoids = new JComboBox(choix_poids);
		choixJour = new JComboBox(choix_jour);
		choixMois = new JComboBox(choix_mois);
		choixAnnee = new JComboBox(choix_annee);
		setLayout (new GridBagLayout());
		JLabel labelTitre = new JLabel("Titre");
		JLabel labelImage = new JLabel("Nom de l'image.format");
		JLabel labelDate = new JLabel("Date");
		JLabel labelJour = new JLabel("Jour");
		JLabel labelMois = new JLabel("Mois");
		JLabel labelAnnee = new JLabel("Annee");
		JLabel labelFrise = new JLabel("Nouvelle evenement");
		JLabel labelDescription = new JLabel("Description");
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets=new Insets(5,5,5,5);

		//premiere ligne
		contrainte.gridx=1 ; contrainte.gridy=1 ;
		contrainte.gridwidth=2;
		labelTitre.setLabelFor(fieldTitre);
		add(fieldTitre, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=2 ;
		contrainte.gridwidth=2;
		labelImage.setLabelFor(labelFieldImage);
		add(boutonPhoto, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=0 ;
		contrainte.gridwidth=2;
		labelFrise.setLabelFor(boutonAjout);
		add(boutonAjout, contrainte);
		boutonAjout.setActionCommand(NOM_BOUTON);
		
		
		//deusiemme ligne (marche un peut)
		/*contrainte.gridx=2 ; contrainte.gridy=2 ;
		contrainte.gridwidth=2;
		this.add(labelDate, contrainte);*/
		
		
		//premier colone
		contrainte.gridx=0 ; contrainte.gridy=0 ;
		contrainte.gridwidth=1;
		labelFrise.setDisplayedMnemonic('N');
		this.add(labelFrise, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=1 ;
		contrainte.gridwidth=1;
		labelTitre.setDisplayedMnemonic('T');
		this.add(labelTitre, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=2 ;
		contrainte.gridwidth=1;
		labelImage.setDisplayedMnemonic('O');
		this.add(labelImage, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		this.add(labelDate,contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		labelJour.setDisplayedMnemonic('J');
		this.add(labelJour, contrainte);
		
		contrainte.gridx=2 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		labelMois.setDisplayedMnemonic('M');
		this.add(labelMois, contrainte);
		
		contrainte.gridx=3 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		labelAnnee.setDisplayedMnemonic('A');
		this.add(labelAnnee, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		labelJour.setLabelFor(choixJour);
		this.add(choixJour, contrainte);
		
		contrainte.gridx=2 ; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		labelMois.setLabelFor(choixMois);
		this.add(choixMois, contrainte);

		contrainte.gridx=3; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		labelAnnee.setLabelFor(choixAnnee);
		this.add(choixAnnee, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=5 ;
		contrainte.gridwidth=1;
		labelPoids.setDisplayedMnemonic('P');
		this.add(labelPoids, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=5 ;
		contrainte.gridwidth=1;
		labelPoids.setLabelFor(choixPoids);
		this.add(choixPoids, contrainte);
		

		
		contrainte.gridx=0 ; contrainte.gridy=6 ;
		contrainte.gridwidth=1;
		labelDescription.setDisplayedMnemonic('D');
		this.add(labelDescription, contrainte);
		
		
		
		
		
		contrainte.gridx=1 ; contrainte.gridy=6 ;
		contrainte.gridwidth=2;
		//contrainte.gridheight=2;
		labelDescription.setLabelFor(area);
		JScrollPane scrollPane = new JScrollPane(area);
		this.add(scrollPane,contrainte);		
		
			
	}
	

	
	public Evenement getEvenement(){
		return new Evenement(getDate(),fieldTitre.getText(),area.getText(), Integer.parseInt((String)choixPoids.getSelectedItem()), labelFieldImage.getText());
	}
	public Date getDate(){
		Date date = new Date(Integer.parseInt((String)choixJour.getSelectedItem()),Integer.parseInt((String)choixMois.getSelectedItem()),Integer.parseInt((String)choixAnnee.getSelectedItem()));
		return	date;
	}
	
	public void enregistreEcouteur(Controleur parC){
		boutonPhoto.addActionListener(parC);
		boutonAjout.addActionListener(parC);
		
	}

	public void reset() {
		fieldTitre.setText(new String());
		labelFieldImage.setText(new String());
		area.setText(new String());
		choixJour.setSelectedItem("1");
		choixMois.setSelectedItem("1");
		choixPoids.setSelectedItem("0");
		fieldTitre.requestFocus();
	}
	public JLabel getFieldImage() {
		return labelFieldImage;
	}
}