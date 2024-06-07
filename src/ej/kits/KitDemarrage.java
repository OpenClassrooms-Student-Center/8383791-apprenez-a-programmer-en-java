package ej.kits;

import java.util.LinkedHashSet;
import java.util.Set;

import ej.blocs.IBloc;
import ej.exceptions.IllegalBlocException;

public class KitDemarrage {

	private Set<IBloc> blocs = new LinkedHashSet<IBloc>();
	private Set<String> motsCles = new LinkedHashSet<String>();
	
	public Set<IBloc> getBlocs() {
		return blocs;
	}
	
	public Set<String> getMotsCles() {
		return motsCles;
	}

	public KitDemarrage(final Set<IBloc> blocs) throws IllegalBlocException {
		this.blocs.addAll(blocs);

		motsCles.add("Cabane");
		motsCles.add("Muraille");
		motsCles.add("Maison");
	}

	public void afficherKit() {
		System.out.println("Nombre de blocs dans le kit : " + blocs.size());
		System.out.print("Liste des mots clés du kit : ");
		for (String motCle : motsCles) {
			System.out.print(motCle + " ");
		}
	}

}