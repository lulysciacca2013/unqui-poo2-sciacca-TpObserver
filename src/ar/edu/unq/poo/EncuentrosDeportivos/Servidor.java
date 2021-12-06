package ar.edu.unq.poo.EncuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

public class Servidor implements Observer {
	
	private List<String> deportesInteresados;
	private List<Partido> partidos;
	private Aplicacion miAplicacion; 
	

	public Servidor( List<String> deportesInteresados, Aplicacion aplicacion) {
		super();
		this.partidos = new ArrayList<Partido>();
		this.deportesInteresados = deportesInteresados;
		this.miAplicacion = aplicacion;
		this.miAplicacion.addObserver(this);
	}


	public List<Partido> getPartidos() {
		return partidos;
	}

	public List<String> getDeportesInteresados() {
		return deportesInteresados;
	}


	@Override
	public void update(Observable o, Object arg) {
		Partido partido = (Partido) arg;
		if  (this.getDeportesInteresados().contains(partido.getDeporte())) {
			this.getPartidos().add(partido);
		}
	}
	
	
}