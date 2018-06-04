package vue;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controleur.Controleur;
import modele.*;


/** Ce panel est la deuxième Frame importante, qui affiche les informations de la frise et qui possède donc le nom de la frise, la table et le diapo
 * 
 */
public class PanelAffichage extends JPanel {
	
	
	/*champs de la table */
	private ModeleTable modele;
	private JTable tableAnneeEvt;
	
	private Date today;
	private Frise frise;
	
	
	private String labelBouton[]={"<",">"};
	private JButton bouton[]= new JButton[2];
	
	private JLabel labelImg;
	private JLabel labelDescription;
	private String[] intitules_images;
	
	
	private JPanel listeDiapo;
	private ArrayList <String>intitule_titre_evenement;
	
	private CardLayout GestionnaireDeCarte = new CardLayout(5,5);
	
	public PanelAffichage(Frise parFrise){
		
		frise = parFrise;
		this.setLayout(new BorderLayout(20,20));
		
		JLabel intituleFrise = new JLabel("<html><h1>"+parFrise.toString()+ "</h1></html>");
		intituleFrise.setHorizontalAlignment(SwingConstants.CENTER);
		intituleFrise.setVerticalAlignment(SwingConstants.CENTER);
		
		
		listeDiapo = new JPanel();
		listeDiapo.setLayout(GestionnaireDeCarte);
		
		
		JPanel diapoEvent = new JPanel();
		JPanel panelTableFrise = new JPanel();
		/*COMPOSANTS POUR LE DIAPO EVENT*/
		
		File repertoire = new File("images");
		intitules_images = repertoire.list();
		labelImg = new JLabel();
		
		
		
		
		for(Evenement evt : frise.getEvenements()) {
			JPanel panelDiapo = new JPanel();
			
			labelDescription = new JLabel(	"<html>"+ "<h1>"+evt.getTitre()+"</h1>"+"<h2>-- Le : "+evt.getDate()+"</h2></br></br>"+"<i>"+evt.getDescription()+"</i>"+"</html>");
			panelDiapo.add(labelDescription);
			
			for(int i = 0; i< intitules_images.length; i++) {
				if(evt.getNom_image().compareTo(intitules_images[i]) ==0) {
					labelImg = new JLabel(new ImageIcon(new ImageIcon("images" + File.separator + intitules_images[i]).getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT)));
				}
			}
			
			panelDiapo.add(labelImg);
			String s = evt.getTitre() + evt.getPoid() + evt.getDate() + evt.getDescription();
			listeDiapo.add(panelDiapo, s);
			
		}
		
		
		
		
		
		
		diapoEvent.add(listeDiapo);
		for(int i =0; i < labelBouton.length; i++) {
			bouton[i] = new JButton(labelBouton[i]);
			diapoEvent.add(bouton[i]);
		}
		/*PARTIE AFFICHAGE DE LA TABLE, ON LA DEFINI ICI POUR PERMETTRE DE DYNAMISER L'AFFICHAGE*/
		
		
		frise = parFrise;
		modele = new ModeleTable(frise.getPeriode(), frise);
		
		tableAnneeEvt = new JTable(modele);
		
		tableAnneeEvt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tableAnneeEvt.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent evt){
				JTable table = (JTable)evt.getSource();
				ModeleTable modele = (ModeleTable)table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				Evenement event = (Evenement) modele.getValueAt(rowIndex, colIndex);
				String s = event.getTitre() + event.getPoid() + event.getDate() + event.getDescription();
				GestionnaireDeCarte.show(listeDiapo,s);

			}

		});
		tableAnneeEvt.setDefaultRenderer(Evenement.class, new CelluleRenderer());
		JScrollPane scroll = new JScrollPane(tableAnneeEvt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );

		scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 25));
		
		
		scroll.setPreferredSize(new Dimension(1000,450));
		
		//panelTableFrise.add(tableAnneeEvt);
		panelTableFrise.add(scroll);
		
		tableAnneeEvt.setRowHeight(100);
	
		/*FIN DE LA TABLE*/
		

		//ajout des trois panels dans la classe PanelAffichage
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(panelTableFrise, BorderLayout.SOUTH);
		
		
	}//fin du constructeur



	public void setFrise(Frise frise2) {
		tableAnneeEvt.setModel(new ModeleTable(frise2.getPeriode(), frise2));		
	}
	
	public void enregistreEcouteur(Controleur parC) {
		for(int i = 0; i < labelBouton.length; i++ ) {
			bouton[i].addActionListener(parC);
			bouton[i].setActionCommand(labelBouton[i]);
		}
	}
	
	public void evenement_suivant() {
		GestionnaireDeCarte.next(listeDiapo);
	}
	public void evenement_precedent() {
		GestionnaireDeCarte.previous(listeDiapo);
	}



	public void ajoutPanel(Evenement evt) {
		//ajoute dans le diapo l'eveneemnt en question
		
		JPanel panelDiapo = new JPanel();
		
		labelDescription = new JLabel(	"<html>"+ "<h1>"+evt.getTitre()+"</h1>"+"<h2>-- Le : "+evt.getDate()+"</h2></br></br>"+"<i>"+evt.getDescription()+"</i>"+"</html>");
		panelDiapo.add(labelDescription);
		
		for(int i = 0; i< intitules_images.length; i++) {
			if(evt.getNom_image().compareTo(intitules_images[i]) ==0) {
				labelImg = new JLabel(new ImageIcon(new ImageIcon("images" + File.separator + intitules_images[i]).getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT)));
			}
		}
		
		panelDiapo.add(labelImg);
		String s = evt.getTitre() + evt.getPoid() + evt.getDate() + evt.getDescription();
		listeDiapo.add(panelDiapo, s);
		
	}
	

	
	
}
