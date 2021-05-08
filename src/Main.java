import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.concretes.GoogleAccountsAdapter;
import core.concretes.UserValidation;
import entities.concretes.Auth;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "Arif", "Yýldýz", "arif@elzemwax.com", "123456");
		
		User user2 = new User(2, "Arif", "Yýldýz", "arifelzemwax.com", "1233242");

		User user3 = new User(3, "Arif", "Yýldýz", "arif4@elzemwax.com", "123");
		
		User user4 = new User(4, "Ar", "Yýldýz", "arif2@elzemwax.com", "1233242");
		
		User user5 = new User(5, "Arif", "Yý", "arif2@elzemwax.com", "1233242"); //googleAccount için
		
		User user6 = new User(6, "Arif", "Yýldýz", "arif@elzemwax.com", "123456"); //googleAccount için
		
		User[] users1 = new User[] { user1, user2 };		
		User[] users2 = new User[] { user3, user4 };
		User[] users3 = new User[] { user5, user6 };
		
		Auth auth1 = new Auth("arif@elzemwax.com", "123456");
		
		Auth auth2 = new Auth("arif@elzemwax.c", "123456");

		UserManager userManager = new UserManager(new UserValidation());
	
		userManager.register(users1);
		userManager.register(users2);
		
		AuthManager authManager = new AuthManager(new UserValidation());

		System.out.println("\n--------------------------------------------GOOGLE ACCOUNT ÝÇÝN------------------------------------------------------------");
		GoogleAccountsAdapter googleUserManager = new GoogleAccountsAdapter(new UserValidation());
				
		googleUserManager.register(users3);
		
		
		authManager.login2(auth1);
		authManager.login2(auth2);
		
	}

}
