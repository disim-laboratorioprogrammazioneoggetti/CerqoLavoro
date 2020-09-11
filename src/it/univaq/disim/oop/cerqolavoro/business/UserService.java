package it.univaq.disim.oop.cerqolavoro.business;

import it.univaq.disim.oop.cerqolavoro.domain.User;

public interface UserService {

	User authenticate(String email, String password) throws UserNotFoundException, BusinessException;
	
}