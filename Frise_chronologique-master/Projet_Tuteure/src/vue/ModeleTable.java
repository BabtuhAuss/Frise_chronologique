package vue;
import java.util.Collection;

import modele.*;

import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel{
	public ModeleTable(Date parDate){
		this.setColumnCount(7);
		this.setRowCount(15);
		String [] abrJour = {"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
		
		
		
		this.setColumnIdentifiers(abrJour); 
		//Les evenements de la semaine 
	/*	Collection <Evenement> evtsSemaine=parAgenda.getEvenementSemaine(parDate); // A check
		
		if (evtsSemaine != null){
			for (Evenement evt : evtsSemaine){
				ajoutEvenement(evt); // 
			}
		}*/
	}//constructeur

	
	
	public void ajoutEvenement(Evenement parEvt) {
		int indiceColonne = 2;
		int indiceLigne = 0;
		while (indiceLigne<15 && getValueAt(indiceLigne, indiceColonne)!= null){
			indiceLigne++;
		}
		setValueAt(parEvt,indiceLigne, indiceColonne);
	}//ajoutEvenement
	
	public Class getColumnClass(int indice){
		return Evenement.class;
	}
}//Classe
