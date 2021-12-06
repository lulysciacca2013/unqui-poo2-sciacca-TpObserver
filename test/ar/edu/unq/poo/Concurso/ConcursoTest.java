package ar.edu.unq.poo.Concurso;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;



public class ConcursoTest {
	
	private Sistema sistema;
	private Map<String, String> preguntasYRespuestas;
	private List <SensorListener> listener;
	private Participante p1;
	private Participante p2;
	private Participante p3;
	private Participante p4;
	private Participante p5;
	private Participante p6;
	
	@BeforeEach
	public void setUp() throws Exception {
		preguntasYRespuestas = new HashMap<String, String>();
		preguntasYRespuestas.put("¿En qué año el hombre pisó la Luna por primera vez?", "1969");
		preguntasYRespuestas.put("¿Cuál es el monte más alto del mundo?", "Everest");
		preguntasYRespuestas.put("¿Cuál es la capital de Brasil?", "Brasilia");
		preguntasYRespuestas.put("¿Quién escribió la Ilíada y la Odisea?", "Homero");
		preguntasYRespuestas.put("¿Quién pintó el “Guernica”?", "Picasso");
		
		sistema = new Sistema(preguntasYRespuestas);
		listener= new ArrayList <SensorListener>();
		
		
		p1 = new Participante("Juan",sistema);
		p2 = new Participante("Ezequiel",sistema);
		p3 = new Participante("Nicolas",sistema);
		p4 = new Participante("Carlos",sistema);
		p5 = new Participante("Pedro",sistema);
		p6 = new Participante("Pablo",sistema);
		
		sistema.addSensorListener(p1);
		sistema.addSensorListener(p2);
		sistema.addSensorListener(p3);
		sistema.addSensorListener(p4);
		sistema.addSensorListener(p5);
		sistema.addSensorListener(p6);
		
		
		
		
		p1 = Mockito.spy(p1);
		p2 = Mockito.spy(p2);
	}
	
	
	@Test
	public void elSistemaEstaEsperandoParticipantes() {
		assertTrue(sistema.getEstado() instanceof EsperandoParticipantes);
	}
	
	@Test
	public void testAgregarParticipantes() throws Exception {
		p1.solicitarSumarse();
		assertEquals(sistema.getParticipantes().size(), 1);
	}
	
	@Test
	public void alAnotarse5ParticipantesSeLeNotifica() throws Exception {
		p1.solicitarSumarse();
		p2.solicitarSumarse();
		p3.solicitarSumarse();
		p4.solicitarSumarse();
		p5.solicitarSumarse();
		assertTrue(sistema.getEstado() instanceof PartidaComenzada);
		//Mockito.verify(sistema).notificarJugadoresDeInicioDePartida( sistema, preguntasYRespuestas );
	}
	
	@Test
	public void participanteContestaCorrectamente() throws Exception {
		p1.solicitarSumarse();
		p2.solicitarSumarse();
		p3.solicitarSumarse();
		p4.solicitarSumarse();
		p5.solicitarSumarse();
		
		p1.contestarPregunta("¿En qué año el hombre pisó la Luna por primera vez?", "1969");
	//	Mockito.verify(p1).notificacionDeRespuestaCorrecta();
	//	Mockito.verify(p2).notificarDeParticipanteRespondioCorrectamente("Juan", "¿En qué año el hombre pisó la Luna por primera vez?");
	}
	
	@Test
	public void participanteContestaTodasLasPreguntas() throws Exception {
		p1.solicitarSumarse();
		p2.solicitarSumarse();
		p3.solicitarSumarse();
		p4.solicitarSumarse();
		p5.solicitarSumarse();
		
		p1.contestarPregunta("¿En qué año el hombre pisó la Luna por primera vez?", "1969");
		p1.contestarPregunta("¿Cuál es el monte más alto del mundo?", "Everest");
		p1.contestarPregunta("¿Cuál es la capital de Brasil?", "Brasilia");
		p1.contestarPregunta("¿Quién escribió la Ilíada y la Odisea?", "Homero");
		p1.contestarPregunta("¿Quién pintó el “Guernica”?", "Picasso");
		
		//Mockito.verify(p2).notificarGanador("Juan");
		
		assertTrue(sistema.getEstado() instanceof EsperandoParticipantes);
	}
	
	@Test
	public void seisParticipantesNoPuedenUnirse() throws Exception {
		p1.solicitarSumarse();
		p2.solicitarSumarse();
		p3.solicitarSumarse();
		p4.solicitarSumarse();
		p5.solicitarSumarse();
		
		assertThrows(Exception.class, () -> p6.solicitarSumarse(), "Accion no permitida" );
	}
	
	@Test
	public void participanteNoPuedeContestarSinSerNotificado() throws Exception {
		p1.solicitarSumarse();
		assertThrows(Exception.class, () -> p1.contestarPregunta("¿Cuál es la capital de Brasil?", "Brasilia"), "Accion no permitida" );
	}
	
}