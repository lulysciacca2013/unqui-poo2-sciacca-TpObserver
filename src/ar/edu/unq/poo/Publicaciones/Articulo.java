package ar.edu.unq.poo.Publicaciones;

import java.util.ArrayList;

public class Articulo {
	private String titulo;
	private ArrayList <String> autores;
	private String filiacion;
	private String tipo;
	private String lugar;
	private ArrayList <String> palabrasClave;
	
	public Articulo(String titulo,ArrayList <String> autores,String filiacion,String tipo,String lugar,ArrayList <String> palabras) {
		this.titulo= titulo;
		this.autores= autores;
		this.filiacion=filiacion;
		this.tipo=tipo;
		this.lugar=lugar;
		this.palabrasClave=palabras;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public String getFiliacion() {
		return filiacion;
	}

	public void setFiliacion(String filiacion) {
		this.filiacion = filiacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public ArrayList<String> getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(ArrayList<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
	
}
