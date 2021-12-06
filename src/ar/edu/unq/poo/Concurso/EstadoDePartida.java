package ar.edu.unq.poo.Concurso;

public abstract class EstadoDePartida {
	
	protected Sistema sistema;

	public EstadoDePartida(Sistema sistema) {
		super();
		this.sistema = sistema;
	}

	public abstract void procesarSolicitud(Participante participante) throws Exception ;

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	protected abstract void procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception;
	
	
	
}