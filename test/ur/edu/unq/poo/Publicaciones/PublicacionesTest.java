package ur.edu.unq.poo.Publicaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo.Concurso.Sistema;
import ar.edu.unq.poo.Publicaciones.Articulo;
import ar.edu.unq.poo.Publicaciones.Investigador;
import ar.edu.unq.poo.Publicaciones.Sistema2;

public class PublicacionesTest {
	
	private Sistema2 sistema;
	private Articulo articulo;
	private Investigador investigador;
	
	@BeforeEach																																		
	public void setUp() {
		sistema = new Sistema2();
		articulo = new Articulo("CyberSecurity en Argentina",Arrays.asList("Alvarez","Navarro"), "Universidad", "Investigacion", "xxx", Arrays.asList("CyberSecurity","xxx"));
		investigador = new Investigador();
		investigador.agregarInteres("CyberSecurity en Argentina");
		investigador.suscribir(sistema);
	}	
	
	@Test
	public void testNotificar() {
		assertTrue(investigador.esTemaDeInteres(articulo));
	}
	
	@Test
	public void testNotificarSuscriptor() {
		sistema.ingresarArticulo(articulo);
	}
	
}

