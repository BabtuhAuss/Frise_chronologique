package vue;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class FenetreMere extends JFrame{
	
	public FenetreMere (String parTitre){
		super(parTitre);
		PanelFils contentPane = new PanelFils();
		
		//barre des menus
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//ajout d'un item à la barre des menus
		JMenuItem interfaceCreation = new JMenuItem("Creation");
		interfaceCreation.addActionListener(contentPane);
		interfaceCreation.setActionCommand("Creation");
		
		JMenuItem interfaceAffichage = new JMenuItem("Affichage");
		interfaceAffichage.addActionListener(contentPane);
		interfaceAffichage.setActionCommand("Affichage");
		
		JMenu menuFrise = new JMenu("Frise...");
		menuFrise.addActionListener(contentPane);
		JMenuItem itmMenuOuvrFrise = new JMenuItem("Ouvrire une frise");
		JMenuItem itmMenuCreeFrise = new JMenuItem("Nouvelle frise");
		itmMenuOuvrFrise.setActionCommand("Ouvrire une frise");
		itmMenuOuvrFrise.addActionListener(contentPane);
		itmMenuCreeFrise.setActionCommand("Nouvelle frise");
		itmMenuCreeFrise.addActionListener(contentPane);
		menuFrise.add(itmMenuOuvrFrise);
		menuFrise.add(itmMenuCreeFrise);
		//menuFrise.setActionCommand("Frise");
		
		JMenuItem popUpAboutUs = new JMenuItem("?");
		popUpAboutUs.addActionListener(contentPane);
		popUpAboutUs.setActionCommand("?");
		
		JMenuItem itemFermer = new JMenuItem("Fermer");
		itemFermer.addActionListener(contentPane);
		itemFermer.setActionCommand("Fermer");
		
		menuBar.add(interfaceCreation);
		menuBar.add(interfaceAffichage);
		menuBar.add(popUpAboutUs);
		menuBar.add(menuFrise);
		menuBar.add(itemFermer);
		
		setContentPane(contentPane);
		
		contentPane.setBackground(new Color(255,255,255));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200,900);
		setVisible(true);
		setLocation(50,50);
		
	}
	
	public static void main(String []args){
		new FenetreMere("FenetreMere");
	}
}
