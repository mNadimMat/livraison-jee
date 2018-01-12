package persistence;

import javax.persistence.Entity;

@Entity

public class Facteur extends Client {
	private String cin,num;

	public Facteur(String nom, String prenom, String mail, String pwd, String cin, String num) {
		super(nom, prenom, mail, pwd);
		this.cin = cin;
		this.num = num;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Facteur(String nom, String prenom, String mail, String pwd) {
		super(nom, prenom, mail, pwd);
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Facteur() {
		super();
	}
	
	

}
