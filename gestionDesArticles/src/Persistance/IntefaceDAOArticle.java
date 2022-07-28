package Persistance;

import java.util.ArrayList;

import Metier.Article;

public interface IntefaceDAOArticle {
	boolean add(Article a);
	boolean delete(Article a);
	ArrayList<Article> getAll();
	boolean update(Article a);
}
