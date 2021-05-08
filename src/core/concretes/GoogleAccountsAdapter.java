package core.concretes;

import GoogleAccounts.GoogleAccount;
import business.abstracts.UserService;
import core.abstracts.UserValidationService;
import dataAccess.concretes.UserLists;
import entities.concretes.User;

public class GoogleAccountsAdapter implements UserService {

	UserValidationService userValidationServices;
	GoogleAccount googleAccount = new GoogleAccount();

	public GoogleAccountsAdapter(UserValidationService userValidationServices) {
		super();
		this.userValidationServices = userValidationServices;
	}

	@Override
	public void register(User[] users) {
		for (User user : users) {

			if (userValidationServices.compareEmails(user) && userValidationServices.checkEmail(user)
					&& userValidationServices.checkPassword(user) && userValidationServices.checkFirstName(user)
					&& userValidationServices.checkLastName(user)) {
				googleAccount.register();
				System.out.println(user.getFirstName() + " kullanýcýsý baþarýyla kayýt olunmuþtur. " + user.getEmail()
						+ " adresine doðrulama E-postasý gönderilmiþtir.");
				UserLists.Liste.add(user);
			}
		}
	}

	@Override
	public void uptade(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

}
