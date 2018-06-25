package org.pi.business.inventaire;

import org.pi.model.Inventaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventaireServiceImpl implements InventaireService{
	@Autowired
	private org.pi.consumer.InventaireRepository inventaireRepository;

	@Override
	public Page<Inventaire> getAllInventaire(Pageable pageable) {
		return inventaireRepository.findAll(pageable);
	}

	@Override
	public Inventaire ajouterInventaire(Inventaire inventaire) {
		return inventaireRepository.save(inventaire);
	}

	@Override
	public Inventaire editerInventaire(Inventaire inventaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerInventaire(Integer inventaireId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventaire chercherInventaire(String reference) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
