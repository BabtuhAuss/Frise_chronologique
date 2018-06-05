package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import modele.Evenement;

/**
 * C'est une classe qui va permettre de rendre plus attrayant la table
 */
public class CelluleRenderer extends JLabel implements TableCellRenderer {

	public CelluleRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(new java.awt.Color(180, 100, 40));
	}

	/**
	 * mets en jaune toutes les cases qui ont des evenements
	 * 
	 */
	
	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne,
			boolean aLeFocus, int ligne, int colonne) {
		if (valeur == null) {
			setText("");
			setBackground(new Color(255, 255, 255));
		} else {
			Evenement valeurS = (Evenement) valeur;
			this.setText(valeurS.toString());
			this.setFont(new Font("Calibri", Font.BOLD, 15));
			this.setBackground(new Color(255, 255, 0));
		}

		return this;
	}

}
