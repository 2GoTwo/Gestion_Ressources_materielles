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
@Table(name = "SERVICE")
public class Service implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	private String demandeur;
	private String emailDemandeur;
	private String type;
	private String object;
	private String description;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateDemandeService = new Date();
	private Date dateSouhaitee;
	private String etat;
	private String departement;
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDemandeService() {
		return dateDemandeService;
	}
	public void setDateDemandeService(Date dateDemandeService) {
		this.dateDemandeService = dateDemandeService;
	}
	public Date getDateSouhaitee() {
		return dateSouhaitee;
	}
	public void setDateSouhaitee(Date dateSouhaitee) {
		this.dateSouhaitee = dateSouhaitee;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	
}
