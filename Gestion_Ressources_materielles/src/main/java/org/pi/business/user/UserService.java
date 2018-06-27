package org.pi.business.user;

import org.pi.model.User;

public interface UserService {
	public User ajouterUser(User user);
	public User editerUser(User user);
	public void supprimerUser(Integer userId);	
	public User chercherUser(String email);
}