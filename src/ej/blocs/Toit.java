package ej.blocs;

import ej.exceptions.IllegalBlocException;

public class Toit extends Bloc {

	public Toit(final int longueur, final int largeur, final int hauteur) throws IllegalBlocException {
		super(longueur, largeur, hauteur, Couleur.MARRON);
	}	

}
