package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@JsonProperty(access=Access.READ_ONLY)
	protected int id;
	protected String nom,prenom,mail;
	
	protected String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Client(String nom, String prenom, String mail, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	

}
