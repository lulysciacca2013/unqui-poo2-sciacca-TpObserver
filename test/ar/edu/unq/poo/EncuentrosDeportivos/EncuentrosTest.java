package ar.edu.unq.poo.EncuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncuentrosTest {

	private Aplicacion aplicacion;
	private Partido partido;
	private Servidor servidor;
	private AppMobile app;
	
	@BeforeEach																																		
	public void setUp() {
		aplicacion = new Aplicacion();
		partido = new Partido("Futbol", Arrays.asList("Boca","River"), "2-2");
		servidor = new Servidor(Arrays.asList("Futbol","Basquet"), aplicacion);
		app = new AppMobile(aplicacion,"Futbol", "Boca");
	}
	
	@Test
	public void testDeAplicacion() {
		aplicacion.agregarPartido(partido);
		assertFalse(aplicacion.getPartidos().isEmpty());
	}
	
	@Test
	public void testDeServidor() {
		aplicacion.agregarPartido(partido);
		assertFalse(servidor.getPartidos().isEmpty());
	}
}
