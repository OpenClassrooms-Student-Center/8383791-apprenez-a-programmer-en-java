package ej.blocs;

import ej.IllegalBlocException;

public class Mur extends Bloc {

	private boolean porteur;

	public Mur(final int longueur, final int largeur, final int hauteur, final boolean porteur)
			throws IllegalBlocException {
		super(longueur, largeur, hauteur);
		this.porteur = porteur;
		this.couleur = Couleur.GRIS;
	}

	public boolean estTraversable() {
		return !porteur;
	}

}