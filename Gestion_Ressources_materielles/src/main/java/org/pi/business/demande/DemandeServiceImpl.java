package org.pi.business.demande;

import org.pi.consumer.DemandeRepository;
import org.pi.model.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DemandeServiceImpl implements DemandeService{
	@Autowired
	private DemandeRepository demandeRepository;

	@Override
	public Page<Demande> getAllDemande(Pageable pageable) {
		return demandeRepository.findAll(pageable);
	}

	@Override
	public Demande ajouterDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public Demande editerDemande(Demande demande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerDemande(Integer demandeId) {
		demandeRepository.deleteById(demandeId);
	}

	@Override
	public Demande chercherDemande(String reference) {
		// TODO Auto-generated method stub
		return null;
	}
}