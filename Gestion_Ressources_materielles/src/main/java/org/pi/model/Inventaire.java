package org.pi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTAIRE")
public class Inventaire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventaireId;
	private String reference;
	private String type;
	private Date dateAcquisition;
	private String local;
	private Date dateSortie;
	private String description;

	public Inventaire() {
		super();
	}

	public int getInventaireId() {
		return inventaireId;
	}

	public void setInventaireId(int inventaireId) {
		this.inventaireId = inventaireId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getDestinataire() {
		return description;
	}

	public void setDestinataire(String destinataire) {
		this.description = destinataire;
	}
}
