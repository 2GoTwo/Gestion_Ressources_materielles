package org.pi.business.service;

import org.pi.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
	public Page<Service> getAllService(Pageable pageable);
	public Service ajouterService(Service service);
	public Service editerService(Service service);
	public void supprimerService(Integer serviceId);	
	public Service chercherService(Integer serviceId);
	
}