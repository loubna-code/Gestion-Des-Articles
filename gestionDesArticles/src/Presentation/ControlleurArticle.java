package Presentation;

import java.util.ArrayList;
import java.util.Collections;

import Metier.Article;
import Metier.GestionnaireArticle;
import Persistance.DAOArticle;

public class ControlleurArticle {
	private DAOArticle dao;
	private GestionnaireArticle gestionnaire;
	private ArrayList<Article> array;
	private MaFenetre f;
	private AjoutArticle aj;
	
	
	public ControlleurArticle() {
		super();
		dao = new DAOArticle();
		gestionnaire = new GestionnaireArticle();
		array = dao.getAll();
	}
	
	public void demarrer() {
		f = new MaFenetre(array,this);
		f.setVisible(true);
	}
	
	public void supprimerLigne(int ligne) {

		
		if(gestionnaire.delete(array.get(ligne)))
        	array.remove(ligne);
		
		f.repaint();
	}
	
	public void ajouterFormulaire() {
		f.dispose();
		aj = new AjoutArticle(this);
		aj.setVisible(true); 
	}
	
	public void validerAjoute(String Libele,Float Prix, Integer Quantite) {
		aj.dispose();
		int IDvide = 0;
	
		//Trouver un ID vide
		for(Article a : array)
			if(a.getID() == IDvide) IDvide++;
		
		Article a = new Article(IDvide, Libele, Prix, Quantite);
		array.add(a);
		Collections.sort(array);
		
		//BD
		gestionnaire.addArticle(a);

		f.setVisible(true);
		f.repaint();
	}
	
	public void modifieTable(int rowIndex) {
		gestionnaire.update(array.get(rowIndex));
	}
	
}
