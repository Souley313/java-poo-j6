package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.BigException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'un département
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationDepartementService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws BigException {
		
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		
		List<Ville> villes = rec.getVilles();
		int somme = 0;
		for (Ville ville: villes){
			if(!ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				throw new BigException("Cet D�partement est inconnu");
			}
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
			}
		}
		
		System.out.println("Population du département "+choix+" : "+ somme);
		
	}

}
