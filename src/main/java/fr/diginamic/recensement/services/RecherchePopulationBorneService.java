package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.exemple.exceptions.BigException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
//import fr.diginamic.testexceptions.PaysNullException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws BigException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		if (!NumberUtils.isCreatable(saisieMin)) {

			throw new BigException("Veuillez mettre un chiffre");
		}

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();

		if (!NumberUtils.isCreatable(saisieMax)) {

			throw new BigException("Veuillez mettre un chiffre");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		if (min<0 || max<0) {

			throw new BigException("les bornes doivent etre positives");
		
		}else if (min>max){
			
			throw new BigException("Le Minimum doit etre inf�rieur au Maximum");
		}

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if(!ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				throw new BigException("Cette D�partement n'existe pas");
			}
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
