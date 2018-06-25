package org.pi.business.inventaire;

import org.pi.model.Inventaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventaireService {
	public Page<Inventaire> getAllInventaire(Pageable pageable);
	public Inventaire ajouterInventaire(Inventaire inventaire);
	public Inventaire editerInventaire(Inventaire inventaire);
	public void supprimerInventaire(Integer inventaireId);	
	public Inventaire chercherInventaire(String reference);
	
}