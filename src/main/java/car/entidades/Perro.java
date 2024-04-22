package car.entidades;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Perro {

	private String idPerro;
	private String nombre;
	private float peso;
	private LocalDate fechaNacimiento;
	
	private List<Vacuna> vacunas;
	
	public void agregarVacuna(Vacuna vacuna) {
		this.vacunas.add(vacuna);
	}
	
	public Perro() {
		super();
		// TODO Auto-generated constructor stub
		this.vacunas = new ArrayList<Vacuna>();
	}
	
	public Perro(String idPerro, String nombre, float peso, LocalDate fechaNacimiento) {
		super();
		this.idPerro = idPerro;
		this.nombre = nombre;
		this.peso = peso;
		this.fechaNacimiento = fechaNacimiento;
		
		this.vacunas = new ArrayList<Vacuna>();
	}
	
	public String getIdPerro() {
		return idPerro;
	}
	
	public void setIdPerro(String idPerro) {
		this.idPerro = idPerro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public List<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	@Override
	public String toString() {
		/*
		 * String dogStr = "Perro [idPerro=" + idPerro + ", nombre=" + nombre +
		 * ", peso=" + peso + ", fechaNacimiento=" + fechaNacimiento + "]";
		 * 
		 * for (Vacuna vacuna : vacunas) { dogStr=dogStr+vacuna.getNumVacuna()+
		 * "-"+vacuna.getNombre() +"-" + vacuna.getFechaAplicacion().toString(); }
		 * return dogStr;
		 */
		return "";
	}	

	// toJason: --
	public String toJason() {
		
		JsonObjectBuilder joBuilder = Json.createObjectBuilder();
 		joBuilder.add("idPerro", idPerro);
		joBuilder.add("nombre", nombre);
		joBuilder.add("peso", peso);
		
		/* Las fechas secrean como un obj json mas(interno) obj anidado(**)
		 * DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		joBuilder.add("peso", peso).add("fechaNacimiento", dtFormatter.format(fechaNacimiento));
		*/
		
		//(**)Objeto interno json anidado ( para fecha ):
		JsonObjectBuilder joBuilder2 = Json.createObjectBuilder();
	 		joBuilder2.add("dia", fechaNacimiento.getDayOfMonth());
			joBuilder2.add("mes", fechaNacimiento.getMonthValue());
			joBuilder2.add("anio", fechaNacimiento.getYear());
			
			JsonObject joInternoFechaNac = joBuilder2.build();
			
		joBuilder.add("fechaNacimiento", joInternoFechaNac);
		
		JsonArrayBuilder jsonArrayBuilderObj = Json.createArrayBuilder();
		
		for (Vacuna vacuna : vacunas) {
			jsonArrayBuilderObj.add(vacuna.toJsonObject());//(vacuna.toJason());	
		}
		
		joBuilder.add("vacunas", jsonArrayBuilderObj.build());
		
		
		return joBuilder.build().toString();
	}
	
}
