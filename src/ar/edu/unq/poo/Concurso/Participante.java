package ar.edu.unq.poo.Concurso;


public class Participante {
	
	private String nombre;
	private Sistema sistema;
	
	public Participante(String nombre,Sistema sistema) {
		super();
		this.nombre = nombre;
		this.sistema = sistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public void solicitarSumarse() throws Exception {
		this.getSistema().procesarSolicitud(this);
	}



	
	public void contestarPregunta(String pregunta, String respuesta) throws Exception {
		this.getSistema().procesarRespuesta(pregunta, respuesta, this);
	}

	
	
	
	
}