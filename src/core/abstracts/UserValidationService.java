package core.abstracts;

import entities.concretes.Auth;
import entities.concretes.User;

public interface UserValidationService {
	
	
	Boolean checkEmail(User user);

	Boolean checkPassword(User user);

	Boolean checkFirstName(User user);

	Boolean checkLastName(User user);
	
	Boolean compareEmails(User user);
	
	Boolean loginRules(User user);
	
	Boolean loginRules2(Auth auth);
	
	Boolean CheckAll(Boolean...args);
	
	Boolean CheckDoðrulamakodu(int dogrumalaKodu , int input);

	
}
