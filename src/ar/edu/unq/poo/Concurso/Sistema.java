package ar.edu.unq.poo.Concurso;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Sistema {
	private EstadoDePartida estado;
	private Set<Participante> participantes;
	private Map<String, String> preguntasYRespuestas;
	private Map<Participante,Set<String>> respuestasCorrectas;
	private List<SensorListener> listeners;

	
	
	
	public Sistema(Map<String, String> preguntas) {
		super();
		this.preguntasYRespuestas = preguntas;
		this.participantes = new HashSet<Participante>();
		this.estado = new EsperandoParticipantes(this);
		this.respuestasCorrectas = new HashMap<Participante, Set<String> >();
	}
	
	public void procesarSolicitud(Participante participante) throws Exception {
		this.getEstado().procesarSolicitud(participante);
	}
	
	public EstadoDePartida getEstado() {
		return estado;
	}

	public void setEstado(EstadoDePartida estado) {
		this.estado = estado;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public Map<String, String> getPreguntasYRespuestas() {
		return this.preguntasYRespuestas;
	}

	public void setPreguntasYRespuestas(Map<String, String> preguntas) {
		this.preguntasYRespuestas = preguntas;
	}

	public Map<Participante, Set<String>> getRespuestaCorrectas() {
		return respuestasCorrectas;
	}

	public void setRespuestaCorrectas(Map<Participante, Set<String>> respuestaCorrectas) {
		this.respuestasCorrectas = respuestaCorrectas;
	}
	
	public void addSensorListener(Participante participante) {
		
			this.addSensorListener(participante);
		
	}
	
	public void removeSensorListener(Participante participante) {
		
			this.removeSensorListener(participante);
		
	}
	
	
	
	public void agregarParticipante(Participante participante) {
		this.getParticipantes().add(participante);
		this.getRespuestaCorrectas().put(participante, new HashSet<String>());
	}

	public void iniciarPartida() {
		this.setEstado(new PartidaComenzada(this));
		this.notificarJugadoresDeInicioDePartida();
	}

	private void notificarJugadoresDeInicioDePartida() {
		for(SensorListener listener: this.listeners) {
			listener.notificarJugadoresDeNuevoInicioDePartida(this, this.getPreguntasYRespuestas());
		}
		//this.getParticipantes().stream().forEach(p -> p.recibirNotificacionDeInicio(this.getPreguntasYRespuestas()) );
	}
	
	public void  procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception {
		this.getEstado().procesarRespuesta(pregunta,respuesta, participante);
	}

	public void verificarRespuesta(String pregunta, String respuesta, Participante participante) {
		if (this.getPreguntasYRespuestas().get(pregunta).equals(respuesta)  ) {
			this.participanteRespondioCorrectamente(pregunta, respuesta,participante);
		}
		else {
			this.participanteRespondioIncorrectamente(pregunta,participante);
		}
		
	}

	private void participanteRespondioIncorrectamente(String pregunta, Participante participante) {
		
		this.notificacionDeRespuestaIncorrecta(pregunta, participante);
	}

	private void participanteRespondioCorrectamente(String pregunta,String respuesta, Participante participante) {
		// TODO Auto-generated method stub
		this.getRespuestaCorrectas().get(participante).add(respuesta);
		if (this.getRespuestaCorrectas().get(participante).size() == 5) {
			this.finalizarPartida(participante);
		}
		else {
			this.notificarDeRespuestaCorrecta(pregunta,participante);
		}
	}
	
	private void notificacionDeRespuestaIncorrecta(String pregunta, Participante participante) {
		for(SensorListener listener: this.listeners) {
			listener.notificacionNuevaDeRespuestaIncorrecta(pregunta,participante);
		}
	}

	private void notificarDeRespuestaCorrecta(String pregunta, Participante participante) {
		for(SensorListener listener: this.listeners) {
			listener.notificarNuevaDeRespuestaCorrecta(pregunta,participante);
		}
		
		/*participante.notificacionDeRespuestaCorrecta();
		this.getParticipantes().stream().forEach(p -> p.notificarDeParticipanteRespondioCorrectamente(participante.getNombre(), pregunta));
		*/
	}

	private void finalizarPartida(Participante participante) {
		
		this.notificarGanador(participante);
		this.setEstado(new EsperandoParticipantes(this));
	}
	
	private void notificarGanador(Participante participante) {
		for(SensorListener listener: this.listeners) {
			listener.notificarNuevoGanador(participante);
		}
	}

	protected void notificarNoExistePregunta(String pregunta, Participante participante) {
		for(SensorListener listener: this.listeners) {
			listener.notificarNoExistePregunta(pregunta,participante);
		}
		
		
	}
}