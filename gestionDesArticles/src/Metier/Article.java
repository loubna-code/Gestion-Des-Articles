package Metier;

public class Article implements Comparable<Article>{
	private Integer ID;
	private String libele;
	private Float Prix;
	private Integer Quantite;

	public Article() {
		super();

	}

	public Article(Integer iD, String libele, Float prix, Integer quantite) {
		super();
		this.libele = libele;
		ID = iD;
		Prix = prix;
		Quantite = quantite;
	}

	public boolean isDisponible() {
		return Quantite > 0;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Float getPrix() {
		return Prix;
	}

	public void setPrix(Float prix) {
		Prix = prix;
	}

	public Integer getQuantite() {
		return Quantite;
	}

	public void setQuantite(Integer quantite) {
		Quantite = quantite;
	}

	@Override
	public String toString() {
		return "Article [" + ID + ", " + libele + ", Prix=" + Prix + ", Qte=" + Quantite + "]";
	}

	public Object get(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return getID();
		case 1:
			return getLibele();
		case 2:
			return getPrix();
		case 3:
			return getQuantite();
		}
		return null;
	}

	@Override
	public int compareTo(Article o) {
		return ID.compareTo(o.ID);
	}

	
	
}
