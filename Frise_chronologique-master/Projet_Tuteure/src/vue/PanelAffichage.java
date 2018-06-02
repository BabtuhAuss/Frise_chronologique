package vue;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import modele.*;

public class PanelAffichage extends JPanel {
	
	
	/*champs de la table */
	private ModeleTable modele;
	private JTable tableAnneeEvt;
	private Date today;
	private Frise frise;

	private JLabel labelImg;
	
	
	
	public PanelAffichage(Frise parFrise){
		
		
		this.setLayout(new BorderLayout(20,20));
		
		JLabel intituleFrise = new JLabel("<html><h1>"+parFrise.toString()+ "</h1></html>");
		intituleFrise.setHorizontalAlignment(SwingConstants.CENTER);
		intituleFrise.setVerticalAlignment(SwingConstants.CENTER);
		
		
		
		JPanel diapoEvent = new JPanel();
		JPanel panelTableFrise = new JPanel();
		/*COMPOSANTS POUR LE DIAPO EVENT*/
		
		File repertoire = new File("images");
		String[] intitules_images = repertoire.list();
		labelImg = new JLabel();
		
		
		ImageIcon icon = new ImageIcon(new ImageIcon("images" + File.separator + "image_vide.jpg").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
		labelImg= new JLabel(icon);
//			tabLabels[i] = new JLabel(new ImageIcon("images" + File.separator + intitules_images[i]));

		Evenement evt_vide = new Evenement(new Date(),"Aucun Evenement séléctionné","Veuillez séléctionner un evenement pour voir sa déscription",5, intitules_images[0]);
		JLabel labelDescription = new JLabel(
				"<html>"+ "<h1>"+evt_vide.getTitre()+"</h1></br></br>"+"<i>"+evt_vide.getDescription()+"</i>"+"</html>"
		);
		
		
		
		diapoEvent.add(labelImg);
		diapoEvent.add(labelDescription);
		
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
				
				this.setDiapo((Evenement) modele.getValueAt(rowIndex, colIndex));
				
			}

			private void setDiapo(Evenement evt) {
				labelDescription.setText(	"<html>"+ "<h1>"+evt.getTitre()+"</h1>"+"<h2>-- Le : "+evt.getDate()+"</h2></br></br>"+"<i>"+evt.getDescription()+"</i>"+"</html>");
				ImageIcon icon_modiv;
				//parcourt de toutes les images dans le fichier
				
				for(int i = 0; i< intitules_images.length; i++) {
					System.out.println(intitules_images[i]);
					if(evt.getNom_image().compareTo(intitules_images[i]) ==0) {
						icon_modiv = new ImageIcon(new ImageIcon("images" + File.separator + intitules_images[i]).getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
						labelImg = new JLabel(icon_modiv);
					}
				}
				
				diapoEvent.removeAll();
				diapoEvent.add(labelImg);
				diapoEvent.add(labelDescription);
				;
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
		
		
		

		
		
		this.add(intituleFrise, BorderLayout.NORTH);
		this.add(diapoEvent, BorderLayout.CENTER);
		this.add(panelTableFrise, BorderLayout.SOUTH);
		
		
	}
	


}
