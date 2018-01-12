package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Colis implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom,destination;
	private float poids;
	@ManyToOne
	private Client client;
	private ModePaiement modePaiement;

	
	public enum ModePaiement{
		A_LA_LIVRAISON,EN_LIGNE
	}


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


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public float getPoids() {
		return poids;
	}


	public void setPoids(float poids) {
		this.poids = poids;
	}


	public ModePaiement getModePaiement() {
		return modePaiement;
	}


	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}


	public Colis(String nom, String destination, float poids, ModePaiement modePaiement) {
		super();
		this.nom = nom;
		this.destination = destination;
		this.poids = poids;
		this.modePaiement = modePaiement;
	}


	public Colis() {
		super();
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
}
