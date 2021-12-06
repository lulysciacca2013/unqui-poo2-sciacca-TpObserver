package ar.edu.unq.poo.EncuentrosDeportivos;

import java.util.List;

public class Partido {
	
	private String deporte;
	private List<String> contrincantes;
	private String resultado;
	
	public Partido(String deporte, List<String> contrincantes, String resultado) {
		super();
		this.deporte = deporte;
		this.contrincantes = contrincantes;
		this.resultado = resultado;
	}

	public String getDeporte() {
		return deporte;
	}

	public List<String> getContrincantes() {
		return contrincantes;
	}

	public String getResultado() {
		return resultado;
	}
	
	@Override
	public String toString() {
		return "El partido de:" + this.getContrincantes().get(0) + " - " 
				+ this.getContrincantes().get(1) + " termino " + this.getResultado();
	}
}