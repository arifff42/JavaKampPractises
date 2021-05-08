package business.abstracts;

import entities.concretes.User;

public interface UserService {

	void register(User[] users);
	void uptade(User user);
	void delete(User user);
}
