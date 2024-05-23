package ej;

import java.util.LinkedHashSet;
import java.util.Set;

public class Kit {

	private Set<Bloc> blocs = new LinkedHashSet<Bloc>();
	private Set<String> motsCles = new LinkedHashSet<String>();

	public Kit() throws IllegalBlocException {

		blocs.add(new Mur(3, 2, 2, true));
		blocs.add(new Mur(3, 2, 2, true));
		blocs.add(new Mur(2, 1, 2, false));
		blocs.add(new Mur(2, 1, 2, false));
		blocs.add(new Porte(1, 2, 2, true));

		motsCles.add("Cabane");
		motsCles.add("Muraille");
	}

	public void afficherKit() {
		System.out.println("Nombre de blocs dans le kit : " + blocs.size());
		System.out.print("Liste des mots clés du kit : ");
		for (String motCle : motsCles) {
			System.out.print(motCle + " ");
		}
	}

}
