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
			
			System.out.println("Giriþ Baþarýlý!\n---------------------------------------------------------------------------------------------------------------------------");
			return;
		}		
		System.out.println("Giriþ Baþarýsýz. Lütfen Email ve Parolanýzý Kontrol Ediniz.\n---------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void login2(Auth auth) {
		
		if (userValidationService.loginRules2(auth)) {
			
			System.out.println("Giriþ Baþarýlý!\n---------------------------------------------------------------------------------------------------------------------------");
			return;
		}
		
		System.out.println("Giriþ Baþarýsýz. Lütfen Email ve Parolanýzý Kontrol Ediniz.\n---------------------------------------------------------------------------------------------------------------------------");
	}
}
