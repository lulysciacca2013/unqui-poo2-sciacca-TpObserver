package ar.edu.unq.poo.Concurso;

public class EsperandoParticipantes extends EstadoDePartida {

	public EsperandoParticipantes(Sistema sistema) {
		super(sistema);
		
	}

	@Override
	public void procesarSolicitud(Participante participante) {
		if (this.getSistema().getParticipantes().size()  < 4 ) {
			this.getSistema().agregarParticipante(participante);
		}
		else{
			this.getSistema().agregarParticipante(participante);
			this.getSistema().iniciarPartida();
		}
	}

	@Override
	protected void procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception {
		throw new Exception("Accion no permitida"); 
		
	}

}