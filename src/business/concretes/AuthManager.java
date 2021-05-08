package business.concretes;

import business.abstracts.AuthService;
import core.abstracts.UserValidationService;
import entities.concretes.Auth;
import entities.concretes.User;

public class AuthManager implements AuthService {

	UserValidationService userValidationService;
	
	public AuthManager(UserValidationService userValidationService) {
		
		this.userValidationService = userValidationService;
	}

	public void login(User user) {
		
		if (userValidationService.loginRules(user)) {
			
			System.out.println("Giri� Ba�ar�l�!\n---------------------------------------------------------------------------------------------------------------------------");
			return;
		}		
		System.out.println("Giri� Ba�ar�s�z. L�tfen Email ve Parolan�z� Kontrol Ediniz.\n---------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void login2(Auth auth) {
		
		if (userValidationService.loginRules2(auth)) {
			
			System.out.println("Giri� Ba�ar�l�!\n---------------------------------------------------------------------------------------------------------------------------");
			return;
		}
		
		System.out.println("Giri� Ba�ar�s�z. L�tfen Email ve Parolan�z� Kontrol Ediniz.\n---------------------------------------------------------------------------------------------------------------------------");
	}
}
