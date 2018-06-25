package org.pi.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventaireRepository extends JpaRepository<org.pi.model.Inventaire, Integer>{
	
}
