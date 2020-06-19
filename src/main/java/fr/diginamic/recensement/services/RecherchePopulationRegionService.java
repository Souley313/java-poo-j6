package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.BigException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'une région
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationRegionService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws BigException {
		
		System.out.println("Quel est le code de la région recherchée ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		int somme = 0;
		String nom = null;
		for (Ville ville: villes){
			if(!ville.getCodeRegion().equalsIgnoreCase(choix)) {
				throw new BigException("Cette R�gion n'existe pas");
			}
			if (ville.getCodeRegion().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
				nom=ville.getNomRegion();
			}
		}
	
			System.out.println("Population de la région "+nom+" : "+ somme);
		
	}

}
