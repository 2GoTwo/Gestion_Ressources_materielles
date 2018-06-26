package org.pi.business.service;

import org.pi.consumer.ServiceRepository;
import org.pi.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public Page<Service> getAllService(Pageable pageable) {
		return serviceRepository.findAll(pageable);
	}

	@Override
	public Service ajouterService(Service service) {
		return serviceRepository.save(service);
	}

	@Override
	public Service editerService(Service service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerService(Integer serviceId) {
		serviceRepository.deleteById(serviceId);
	}

	@Override
	public Service chercherService(Integer serviceId) {
		
		return serviceRepository.getOne(serviceId);
	}
}