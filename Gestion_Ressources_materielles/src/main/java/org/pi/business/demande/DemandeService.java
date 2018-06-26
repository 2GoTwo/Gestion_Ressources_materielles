package org.pi.business.demande;

import org.pi.model.Demande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DemandeService {
	public Page<Demande> getAllDemande(Pageable pageable);
	public Demande ajouterDemande(Demande demande);
	public Demande editerDemande(Demande demande);
	public void supprimerDemande(Integer demandeId);	
	public Demande chercherDemande(String reference);
	
}