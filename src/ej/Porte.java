package ej;

public class Porte extends Bloc {

	private boolean verrouillee;

	public Porte(final int longueur, final int largeur, final int hauteur, final boolean verrouillee)
			throws IllegalBlocException {
		super(longueur, largeur, hauteur);
		this.verrouillee = verrouillee;
		this.couleur = Couleur.BLEU;
	}

	public boolean estVerrouillee() {
		return verrouillee;
	}

	public void verrouiller() throws PorteVerrouilleException {
		if (verrouillee) {
			throw new PorteVerrouilleException();
		} else {
			verrouillee = true;
		}
	}

}
