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
				System.out.println(user.getFirstName() + " kullan�c�s� ba�ar�yla kay�t olunmu�tur. " + user.getEmail()
						+ " adresine do�rulama E-postas� g�nderilmi�tir.\nDo�rulama Kodu: " + dogrumalaKodu
						+ "\n---------------------------------------------------------------------------------------------------------------------------");

				System.out.println("L�tfen Do�rulama Kodunu Giriniz: ");
				girilenDogrulamaKodu = in.nextLine();

				if (userValidationServices.CheckDo�rulamakodu(dogrumalaKodu,
						Integer.parseInt(girilenDogrulamaKodu)) == false) {
					return;

				}
				UserLists.Liste.add(user);
			}

		}
	}

	@Override
	public void uptade(User user) {
		System.out.println("Kullan�c� G�ncellendi");

	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� Silindi");
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
 * " kullan�c�s� ba�ar�yla kay�t olunmu�tur. " + user.getEmail() +
 * " adresine do�rulama E-postas� g�nderilmi�tir.");
 * 
 * UserLists.Liste.add(user); }
 */