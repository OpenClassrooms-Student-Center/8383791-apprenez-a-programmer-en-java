package ej.blocs;

import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ej.exceptions.IllegalBlocException;
import ej.exceptions.PorteVerrouilleException;

public class Porte extends Bloc {
	
	private static Logger logger = LogManager.getLogger(Porte.class);

	private boolean verrouillee;

	public Porte(final int longueur, final int largeur, final int hauteur, final boolean verrouillee)
			throws IllegalBlocException {
		super(longueur, largeur, hauteur, Couleur.BLEU);
		this.verrouillee = verrouillee;
	}

	public boolean estVerrouillee() {
		return verrouillee;
	}

	public void verrouiller() throws PorteVerrouilleException {
		if (verrouillee) {
			logger.error("La porte ne peut pas être verouillée car c'est déjà le cas.");
			throw new PorteVerrouilleException();
		} else {
			verrouillee = true;
		}
	}
	
	public void forcerSerrure(Predicate<String> fonction) {
		String cleSecrete = "#secret123";
		if(this.verrouillee) {
			if(fonction.test(cleSecrete)) {
				this.verrouillee = false;
			} 
		}
	}
	
}