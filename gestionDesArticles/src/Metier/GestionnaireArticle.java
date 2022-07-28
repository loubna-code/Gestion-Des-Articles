package Metier;

import java.util.ArrayList;

import Persistance.DAOArticle;

public class GestionnaireArticle {
	DAOArticle daoArticle;
	ArrayList<Article> liste;

	public GestionnaireArticle() {
		super();
		daoArticle = new DAOArticle();
	}
	
	public ArrayList<Article> getAll() {
		ArrayList<Article> tArticles = daoArticle.getAll();
		ArrayList<Article> resultat = new ArrayList<Article>();
		
		for(Article a : tArticles) {
			if(a.getQuantite() > 20)
				resultat.add(a);
		}
		
		return resultat;
	}
	
	public boolean update(Article a) {
		return daoArticle.update(a);
	}
	
	public boolean delete(Article a) {
		if(a.getQuantite() == 0)
			return daoArticle.delete(a);
		
		return false;
	}
	
	public boolean addArticle(Article a) {
		
		// TEST
		
		
		
		
		
		return daoArticle.add(a);
	}

}
