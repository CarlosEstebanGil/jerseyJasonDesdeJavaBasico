package car.entidades;

import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Vacuna {
	private int numVacuna;
	private LocalDate fechaAplicacion;
	private String nombre;
	
	public int getNumVacuna() {
		return numVacuna;
	}

	public void setNumVacuna(int numVacuna) {
		this.numVacuna = numVacuna;
	}

	public LocalDate getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(LocalDate fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vacuna(int numVacuna, LocalDate fechaAplicacion, String nombre) {
		super();
		this.numVacuna = numVacuna;
		this.fechaAplicacion = fechaAplicacion;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "";//return "Vacuna [numVacuna=" + numVacuna + ", fechaAplicacion=" + fechaAplicacion + ", nombre=" + nombre + "]";
	}
	
	//public String toJason() {
	public JsonObject toJsonObject() {
		JsonObjectBuilder joBuilder = Json.createObjectBuilder();
		joBuilder.add("num", numVacuna);
		
		JsonObjectBuilder joBuilder2 = Json.createObjectBuilder();
		joBuilder2.add("dia", fechaAplicacion.getDayOfMonth())
				  .add("mes", fechaAplicacion.getMonthValue())
				  .add("ano",fechaAplicacion.getYear());
		
		joBuilder.add("fechaAplicacion", joBuilder2.build());
		joBuilder.add("vacuna", nombre);
		return joBuilder.build(); //.toString();
	}
}
