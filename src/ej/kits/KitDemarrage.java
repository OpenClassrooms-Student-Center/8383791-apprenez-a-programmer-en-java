package ej.kits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ej.blocs.IBloc;
import ej.exceptions.IllegalBlocException;

public class KitDemarrage {
	
	private Logger logger = LogManager.getLogger(KitDemarrage.class);

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
		motsCles.forEach(System.out::println);
	}
	
	public void sauvegarder() {
		StringBuilder builder = new StringBuilder();
		builder.append("Kit de démarrage\n");
		motsCles.forEach((motCle) -> builder.append(motCle + " "));
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("kit.txt"));
			writer.write(builder.toString());
			writer.close();
		} catch (IOException e) {
			logger.error("Impossible d'écrire dans le fichier");
		}
		
	}	

}