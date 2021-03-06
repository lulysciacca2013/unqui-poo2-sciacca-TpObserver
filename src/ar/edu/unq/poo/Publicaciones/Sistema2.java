package ar.edu.unq.poo.Publicaciones;

import java.util.ArrayList;
import java.util.Observable;

public class Sistema2 extends Observable {
	
	private ArrayList <Articulo> articulo;
	private ArrayList <Investigador> investigador;
	
	public Sistema2() {
		
		articulo = new ArrayList<Articulo>();
	}

	public void suscribirInvestigador(Investigador investigador) {
		this.investigador.add(investigador);
	}
	
	public void desuscribirInvestigador(Investigador investigador) {
		this.investigador.remove(investigador);
	}
	
	

	public void ingresarArticulo(Articulo articulo) {
		this.getArticulo().add(articulo);
		this.notificar(articulo);
	}


	private void notificar(Articulo articulo) {
		this.setChanged();
		this.notifyObservers(articulo);
	}

	
	
	public ArrayList<Articulo> getArticulo() {
		return articulo;
	}

	public void setArticulo(ArrayList<Articulo> articulo) {
		this.articulo = articulo;
	}

	public ArrayList<Investigador> getInvestigador() {
		return investigador;
	}

	public void setInvestigador(ArrayList<Investigador> investigador) {
		this.investigador = investigador;
	}
	
	
	
}
