package vue;
import java.awt.*;
import java.util.GregorianCalendar;

import javax.swing.*;

import controleur.Controleur;
import modele.*;

//le formulaire contien 6 ligne, 5 colone, le premier gridx=0 gridy=0 le deusiemme gridx=0 et gridy=5, les zones de textes sont sur
//plusieur ligne, aucun element sont sur plusieur colone.

public class PanelCreation extends JPanel{
	public final String NOM_BOUTON="+";
	JButton boutonAjout = new JButton(NOM_BOUTON);	
	Date dateFormulaire = new Date(30,05,2018);
	JTextField fieldTitre = new JTextField(10);
	JTextField fieldLieu= new JTextField(10);
	JLabel labelDate = new JLabel(dateFormulaire.toString());
	JTextArea area = new JTextArea("",5,10);
	
	String choix_poid[] = {"1","2","3","4","5"};
	JLabel labelPoid = new JLabel("Poid");
	JTextField fieldPoid= new JTextField(10);
	JComboBox choixPoid;
	
	
	JTextField fieldImage =  new JTextField(10);
	
	public PanelCreation(){
		choixPoid = new JComboBox(choix_poid);
		setLayout (new GridBagLayout());
		JLabel labelTitre = new JLabel("Titre");
		JLabel labelLieu = new JLabel("Lieu");
		JLabel labelDebut = new JLabel("Date");
		JLabel labelDescription = new JLabel("Description");
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets=new Insets(5,5,5,5);

		//premiere ligne
		contrainte.gridx=4 ; contrainte.gridy=1 ;
		contrainte.gridwidth=4;
		add(fieldTitre, contrainte);
		
		contrainte.gridx=4 ; contrainte.gridy=2 ;
		contrainte.gridwidth=4;
		add(fieldLieu, contrainte);
		
		contrainte.gridx=4 ; contrainte.gridy=0 ;
		contrainte.gridwidth=4;
		add(boutonAjout, contrainte);
		
		contrainte.gridx=4 ; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		this.add(fieldPoid, contrainte);
		
		
		
		//deusiemme ligne (marche un peut)
		contrainte.gridx=2 ; contrainte.gridy=2 ;
		contrainte.gridwidth=2;
		this.add(labelDate, contrainte);
		
		//premier colone
		contrainte.gridx=0 ; contrainte.gridy=0 ;
		contrainte.gridwidth=1;
		this.add(labelDate, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=1 ;
		contrainte.gridwidth=1;
		this.add(labelTitre, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=2 ;
		contrainte.gridwidth=1;
		this.add(labelLieu, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		this.add(labelDebut, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		this.add(labelPoid, contrainte);
		

		
		contrainte.gridx=0 ; contrainte.gridy=5 ;
		contrainte.gridwidth=1;
		this.add(labelDescription, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=5 ;
		contrainte.gridwidth=0;
		contrainte.gridheight=5;
		this.add(area, contrainte);
		
		
		
	}
	
	public Evenement getEvenement(){
		return new Evenement(getDate(),fieldTitre.getText(),fieldLieu.getText(), 0, fieldImage.getText());
	}
	public Date getDate(){
		return	dateFormulaire;
	}
	
	public void setDate(Date parDate){
		dateFormulaire = parDate;
		labelDate.setText(dateFormulaire.toString());
	}
	
	public void enregistreEcouteur(Controleur parC){
		boutonAjout.addActionListener(parC);
	}

	public void reset() {
		fieldTitre.setText(new String());
		fieldLieu.setText(new String());
		area.setText(new String());
		
		GregorianCalendar calendar = new GregorianCalendar();
		fieldTitre.requestFocus();
	}
	
}























/*package vue;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCreation extends JPanel{
	//Date dateFormulaire = new Date();
	public final String NOM_BOUTON="+";
	JButton boutonAjout = new JButton(NOM_BOUTON);
	JTextField fieldTitre = new JTextField(10);
	JTextArea description = new JTextArea("",5,10);
	JTextField poid = new JTextField(10);
	
	public PanelCreation(){
		setLayout (new GridLayout(4,2,8,8));
		JLabel labelTitre = new JLabel("Titre");
		JLabel labelDescription = new JLabel("Description");
		JLabel labelPoid = new JLabel("Poid");
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets=new Insets(5,5,5,5);

		add(labelTitre);
		add(fieldTitre);
		
		add(labelDescription);
		add(description);
		
		add(labelPoid);
		add(poid);
		
		add(boutonAjout);
		
	}
}*/
