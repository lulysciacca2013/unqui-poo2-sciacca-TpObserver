package ar.edu.unq.poo.Publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
	private String titulo;
	private List <String> autores;
	private String filiacion;
	private String tipo;
	private String lugar;
	private List <String> palabrasClave;
	
	public Articulo(String titulo,List <String> autores,String filiacion,String tipo,String lugar,List <String> palabras) {
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

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
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

	public List<String> getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(List<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
	
}
