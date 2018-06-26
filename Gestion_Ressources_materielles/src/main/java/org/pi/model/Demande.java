package org.pi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DEMANDE")
public class Demande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int demandeId;
	private String typeCategorie;
	private String type;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateDemande;
	private String demandeur;
	private String emailDemandeur;
	private Integer quantite;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateSouhaitee;
	private String description;
	private String etat;
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDemandeId() {
		return demandeId;
	}
	public void setDemandeId(int demandeId) {
		this.demandeId = demandeId;
	}
	public String getTypeCategorie() {
		return typeCategorie;
	}
	public void setTypeCategorie(String typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(String demandeur) {
		this.demandeur = demandeur;
	}
	public String getEmailDemandeur() {
		return emailDemandeur;
	}
	public void setEmailDemandeur(String emailDemandeur) {
		this.emailDemandeur = emailDemandeur;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Date getDateSouhaitee() {
		return dateSouhaitee;
	}
	public void setDateSouhaitee(Date dateSouhaitee) {
		this.dateSouhaitee = dateSouhaitee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
