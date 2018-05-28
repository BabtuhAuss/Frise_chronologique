package vue;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FenetreMere extends JFrame{

	public FenetreMere (String parTitre){
		super(parTitre);
		PanelFils contentPane = new PanelFils();
		
		//barre des menus
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//ajout d'un item à la barre des menus
		JMenuItem interfaceCreation = new JMenuItem("Création d'Évenement");
		interfaceCreation.addActionListener(contentPane);
		interfaceCreation.setActionCommand("CreerEvenement");
		
		JMenuItem interfaceAffichage = new JMenuItem("Affichage Frise");
		interfaceAffichage.addActionListener(contentPane);
		interfaceAffichage.setActionCommand("AgendaSemaine");
		
		JMenuItem popUpAboutUs = new JMenuItem("?");
		popUpAboutUs.addActionListener(contentPane);
		popUpAboutUs.setActionCommand("PlusDInfo");
		
		JMenuItem itemFermer = new JMenuItem("Fermer");
		itemFermer.addActionListener(contentPane);
		itemFermer.setActionCommand("Fermer");
		
		menuBar.add(interfaceCreation);
		menuBar.add(interfaceAffichage);
		menuBar.add(popUpAboutUs);
		menuBar.add(itemFermer);
		
		setContentPane(contentPane);
		contentPane.setBackground(new Color(230,67,98));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		setLocation(200,300);
		
	}
	
	public static void main(String []args){
		new FenetreMere("FenetreMere");
	}
}
