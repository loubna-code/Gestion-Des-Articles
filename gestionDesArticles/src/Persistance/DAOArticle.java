package Persistance;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Article;

public class DAOArticle implements IntefaceDAOArticle {
	Connection conn;

	public DAOArticle() {
		try {
			conn = ConnexionDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Article> getAll() {
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet resultat = null;
		try {
			resultat = this.conn.createStatement().executeQuery("SELECT * FROM Article");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Integer ID = 0;
		String libele = "";
		float prix = 0F;
		Integer quantite = 0;

		try {
			while (resultat.next()) {

				ID = resultat.getInt("ID");
				libele = resultat.getString("libele");
				prix = resultat.getFloat("prix");
				quantite = resultat.getInt("quantite");

				list.add(new Article(ID, libele, prix, quantite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean add(Article a) {

		try {

			PreparedStatement ps = this.conn
					.prepareStatement("INSERT INTO Article(ID, libele, prix, quantite) VALUES(?,?,?,?)");
			ps.setInt(1, a.getID());
			ps.setString(2, a.getLibele());
			ps.setFloat(3, a.getPrix());
			ps.setInt(4, a.getQuantite());
			ps.executeUpdate();
			
			
			
			ps.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

	@Override
	public boolean delete(Article a) {

		try {

			PreparedStatement ps = this.conn.prepareStatement("DELETE FROM Article WHERE ID = ?");
			ps.setInt(1, a.getID());
			ps.executeUpdate();

			ps.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

	@Override
	public boolean update(Article a) {
		try {

			PreparedStatement ps = this.conn
					.prepareStatement("UPDATE Article SET libele = ?, prix = ?, quantite = ? WHERE ID = ?");
			ps.setString(1, a.getLibele());
			ps.setFloat(2, a.getPrix());
			ps.setInt(3, a.getQuantite());
			ps.setInt(4, a.getID());
			
			ps.executeUpdate();
			
			
			ps.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

}
