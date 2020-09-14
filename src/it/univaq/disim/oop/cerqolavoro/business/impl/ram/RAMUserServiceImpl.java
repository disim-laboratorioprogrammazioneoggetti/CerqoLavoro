package it.univaq.disim.oop.cerqolavoro.business.impl.ram;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.domain.Employer;
import it.univaq.disim.oop.cerqolavoro.domain.User;

public class RAMUserServiceImpl implements UserService {
	
	private UserService userService;
	
	public RAMUserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User authenticate(String email, String password) throws BusinessException {
		if ("worker".equalsIgnoreCase(email)) {
			Worker worker = new Worker();
			worker.setEmail(email);
			worker.setPassword(password);
			return worker;
		} 
		if ("employer".equalsIgnoreCase(email)) {
			Employer employer = new Employer();
			employer.setEmail(email);
			employer.setPassword(password);
			return employer;
		}
		throw new UserNotFoundException();
	}

}

