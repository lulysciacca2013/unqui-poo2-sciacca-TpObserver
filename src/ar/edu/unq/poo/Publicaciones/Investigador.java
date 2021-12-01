package ar.edu.unq.poo.Publicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public   class Investigador implements Observer{
	
	private ArrayList<String> temaDeInteres;
	private Sistema sistema;

	public Investigador() {
		this.temaDeInteres= getTemaDeInteres();
	}

	
	public ArrayList<String> getTemaDeInteres() {
		return temaDeInteres;
	}

	public void setTemasDeInteres(ArrayList<String> temasDeInteres) {
		this.temaDeInteres = temasDeInteres;
	}
	
	public void agregarInteres(String temas) {
		this.getTemaDeInteres().add(temas);
	}
	
	public void suscribir (Sistema sistema) {
		sistema.addObserver(this);
	}
	
	
	
	public boolean esTemaDeInteres(Articulo articulo) {
		return this.temaDeInteres.contains(articulo.getTitulo()) ||
		!Collections.disjoint(temaDeInteres, articulo.getAutores())||
		this.temaDeInteres.contains(articulo.getFiliacion())||
		this.temaDeInteres.contains(articulo.getTipo()) ||
		this.temaDeInteres.contains(articulo.getLugar())||
		!Collections.disjoint(temaDeInteres, articulo.getPalabrasClave());
	}


	@Override
	public void update(Observable o, Object arg) {
		Articulo articulo = (Articulo) arg;
		if (this.esTemaDeInteres(articulo)) {
			System.out.println("Hay un nuevo articulo");
		
		}
	
	}
}
	
	


