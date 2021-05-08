package business.concretes;

import java.util.Scanner;

import business.abstracts.UserService;
import core.abstracts.UserValidationService;
import dataAccess.concretes.UserLists;
import entities.concretes.User;

public class UserManager implements UserService {

	UserValidationService userValidationServices;
	private int dogrumalaKodu = 0;
	private String girilenDogrulamaKodu = "0";

	Scanner in = new Scanner(System.in);

	public UserManager(UserValidationService userValidationServices) {

		this.userValidationServices = userValidationServices;
	}

	@Override
	public void register(User[] users) {

		for (User user : users) {

			dogrumalaKodu = (int) (Math.random() * 10000);

			if (userValidationServices.compareEmails(user) && userValidationServices.checkEmail(user)
					&& userValidationServices.checkPassword(user) && userValidationServices.checkFirstName(user)
					&& userValidationServices.checkLastName(user)) {
				System.out.println(user.getFirstName() + " kullanýcýsý baþarýyla kayýt olunmuþtur. " + user.getEmail()
						+ " adresine doðrulama E-postasý gönderilmiþtir.\nDoðrulama Kodu: " + dogrumalaKodu
						+ "\n---------------------------------------------------------------------------------------------------------------------------");

				System.out.println("Lütfen Doðrulama Kodunu Giriniz: ");
				girilenDogrulamaKodu = in.nextLine();

				if (userValidationServices.CheckDoðrulamakodu(dogrumalaKodu,
						Integer.parseInt(girilenDogrulamaKodu)) == false) {
					return;

				}
				UserLists.Liste.add(user);
			}

		}
	}

	@Override
	public void uptade(User user) {
		System.out.println("Kullanýcý Güncellendi");

	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý Silindi");
	}
}

/*
 * if
 * (userValidationServices.CheckAll(userValidationServices.compareEmails(user),
 * userValidationServices.checkEmail(user),
 * userValidationServices.checkPassword(user),
 * userValidationServices.checkFirstName(user),
 * userValidationServices.checkLastName(user))) {
 * System.out.println(user.getFirstName() +
 * " kullanýcýsý baþarýyla kayýt olunmuþtur. " + user.getEmail() +
 * " adresine doðrulama E-postasý gönderilmiþtir.");
 * 
 * UserLists.Liste.add(user); }
 */