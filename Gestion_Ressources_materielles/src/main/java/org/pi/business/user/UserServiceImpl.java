package org.pi.business.user;

import org.pi.consumer.UserRepository;
import org.pi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User ajouterUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User editerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User chercherUser(String email) {
		return userRepository.findByEmail(email);
	}
}