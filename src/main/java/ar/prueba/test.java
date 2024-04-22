package ar.prueba;

import java.time.LocalDate;
import java.time.LocalDateTime;

import car.entidades.Perro;
import car.entidades.Vacuna;

public class test {

	public static void main(String[] args) {
		Perro pluto = new Perro("Pl01","Pluto",24.5f,LocalDate.now() );
		
		pluto.agregarVacuna(new Vacuna(1, LocalDate.now(), "antirabica"));
		pluto.agregarVacuna(new Vacuna(2, LocalDate.now(), "antiparasitaria"));
		pluto.agregarVacuna(new Vacuna(3, LocalDate.now(), "antiGripal"));
		
		System.out.println(pluto.toJason());
	}

}
