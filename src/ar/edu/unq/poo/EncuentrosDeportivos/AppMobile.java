package ar.edu.unq.poo.EncuentrosDeportivos;

import java.util.Observer;
import java.util.Observable;

public class AppMobile implements Observer {

	private String deporteInteresado;
	private String equipoInteresado;
	private Aplicacion miAplicacion;



	public AppMobile(Aplicacion aplicacion,String deporteInteresado,String equipoInteresado) {
		this.miAplicacion= aplicacion;
		this.deporteInteresado= deporteInteresado;
		this.equipoInteresado = equipoInteresado;
		this.miAplicacion.addObserver(this);
	}
	
	


	public String getDeporteInteresado() {
		return deporteInteresado;
	}



	public String getEquipoInteresado() {
		return equipoInteresado;
	}
	
	



	public void setDeporteInteresado(String deporteInteresado) {
		this.deporteInteresado = deporteInteresado;
	}




	public void setEquipoInteresado(String equipoInteresado) {
		this.equipoInteresado = equipoInteresado;
	}




	@Override
	public  void update(Observable o, Object arg) {
		Partido partido = (Partido) arg;
		if (partido.getDeporte().equals(this.getDeporteInteresado()) || 
				partido.getContrincantes().contains(this.getEquipoInteresado())) {
			System.out.print(partido.toString());
		}
	}

}