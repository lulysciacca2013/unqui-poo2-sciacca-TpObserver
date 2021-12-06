package ar.edu.unq.poo.Concurso;

import java.util.Map;

public interface SensorListener {
	
	public void notificarJugadoresDeNuevoInicioDePartida(Sistema sistema, Map<String, String> preguntasYRespuestas );
	public void notificacionNuevaDeRespuestaIncorrecta(String pregunta, Participante participante);
	public void notificarNuevaDeRespuestaCorrecta(String pregunta, Participante participante);
	public void notificarNuevoGanador(Participante participante);
	public void notificarNoExistePregunta(String pregunta, Participante participante);
	

}
