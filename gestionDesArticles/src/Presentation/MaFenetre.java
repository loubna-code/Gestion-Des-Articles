package Presentation;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Metier.Article;

@SuppressWarnings("serial")
public class MaFenetre extends JFrame {
	private JTable articleTable;
	private JButton buttonAjouter;
	private JButton buttonSupprimer;
	
	public MaFenetre(ArrayList<Article> list,ControlleurArticle control) {
		this.setTitle("Acceuil");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiser(list);
		this.dessiner();
		this.executer(control);
	}
	
	private void initialiser(ArrayList<Article> list) {
		articleTable = new JTable(new ModelArticle(list));
		buttonAjouter = new JButton("Ajouter");
		buttonSupprimer = new JButton("Supprimer");
		articleTable.setPreferredScrollableViewportSize(new Dimension(500,200));
	}
	
	private void dessiner() {
		JPanel southPanel = new JPanel();
		
		add(new JScrollPane(articleTable),BorderLayout.NORTH);
		southPanel.add(buttonAjouter);
		southPanel.add(buttonSupprimer);
		add(southPanel,BorderLayout.SOUTH);
		this.pack();
	}
	
	private void executer(ControlleurArticle control) {
		buttonSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.supprimerLigne(articleTable.getSelectedRow());
			}
		});
		
		buttonAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				control.ajouterFormulaire();
			}
		});
		
		articleTable.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				control.modifieTable(e.getLastRow());
			}
		});
		
	}
}
