package ej;

public class Main {

	public static void main(String[] args) {
		int[] tableau = {10, 100, 50, 22, 1080, 27000, 0};
		int cpt = 0;
		for(int i=0; i<7; i++) {
			if(tableau[i] == 0) {
				cpt++;
			}
		}
		System.out.println(cpt);
	}
	
}
