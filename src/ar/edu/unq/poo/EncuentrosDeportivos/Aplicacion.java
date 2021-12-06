package ar.edu.unq.poo.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Aplicacion extends Observable {

	private List<Partido> partidos;

	public Aplicacion() {
		partidos = new ArrayList<Partido>();
	}
	
	public List<Partido> getPartidos() {
		return partidos;
	}

	
	public void agregarPartido(Partido partido) {
		this.getPartidos().add(partido);
		this.notificar(partido);
	}
	
	public void notificar(Partido partido) {
		this.setChanged();
		this.notifyObservers(partido);
	}
	
}