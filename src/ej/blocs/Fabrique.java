package ej.blocs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fabrique {
	
	private static ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
	private static Logger logger = LogManager.getLogger(Fabrique.class);
	
	public static Set<IBloc> creerMur(final int quantite) {
		Callable<IBloc> taskMur = () -> { return new Mur(1, 1, 1, true); };
		return creerBloc(taskMur, quantite);
	}

	public static Set<IBloc> creerPorte(final int quantite) {
		Callable<IBloc> taskPorte = () -> {	return new Porte(1, 1, 1, false); };
		return creerBloc(taskPorte, quantite);
	}

	public static Set<IBloc> creerToit(final int quantite) {
		Callable<IBloc> taskToit = () -> { return new Toit(1, 1, 1); };
		return creerBloc(taskToit, quantite);
	}
	
	private static Set<IBloc> creerBloc(final Callable<IBloc> task, final int quantite) {
		Set<IBloc> blocs = new LinkedHashSet<IBloc>();
		List<Callable<IBloc>> tasks = new ArrayList<Callable<IBloc>>();

		for(int i=0; i<quantite; i++) {			
			tasks.add(task);
		}

		try {
			List<Future<IBloc>> resultats = executorService.invokeAll(tasks);
			resultats.forEach((resultat) -> {
				try {
					blocs.add(resultat.get());
				} catch (InterruptedException | ExecutionException e) {
					logger.error("Erreur lors de la création parallèle des blocs.");
				}
			});
		} catch (InterruptedException e) {
			logger.error("Erreur lors de la création parallèle des blocs.");
		}
		return blocs;
	}

}
