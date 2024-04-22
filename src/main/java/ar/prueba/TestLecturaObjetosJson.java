package ar.prueba;

import java.io.FileReader;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;

public class TestLecturaObjetosJson {

	public static void main(String[] args) {
		//1) 
			
			//leerObjetoJson();
		//2)
			
			//leerArrayJsonObjetosJson();
		
		//3) Si NO SÉ Si me viene un Obj json ó una coleccion (Array)  
			
			leerObjOArrJson_loQueVengaJson();
		
		
	}

	private static void leerObjetoJson() {
		try (JsonReader lectorJson = Json.createReader(new FileReader("articulo.json"))){
			JsonObject jsonObj=lectorJson.readObject();
			System.out.println(jsonObj.toString());
			
			System.out.println("o tambien:");
				System.out.println(jsonObj.getString("clave"));
				System.out.println(jsonObj.getInt("costo"));
				System.out.println(jsonObj.getString("descripcion"));
				System.out.println(jsonObj.getInt("existencia"));
				System.out.println(jsonObj.getString("nombre"));
				//System.out.println(Float.parseFloat(jsonObj.getString("precio"))==0.0?"vacio":"valuado");
				//System.out.println(jsonObj.get("precio").toString());
				System.out.println(jsonObj.getJsonNumber("precio").doubleValue());//xa q lo lea como float
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void leerArrayJsonObjetosJson() {
		try (JsonReader lectorJson = Json.createReader(new FileReader("articulos.json"))){
			JsonArray arrayArticulosJson= lectorJson.readArray();
			for (Iterator iterator = arrayArticulosJson.iterator(); iterator.hasNext();) {
				JsonValue jsonValue = (JsonValue) iterator.next();
				System.out.println(jsonValue.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void leerObjOArrJson_loQueVengaJson(){
		try (JsonReader lectorJson = // le puedo poner cualquiera de los 2 files..
					Json.createReader(new FileReader(//"articulo.json"))){
													  "articulos.json"))){
			JsonStructure estructuraJson= lectorJson.read(); //Array()//Object();
			
			ValueType tipoEntradaJson=estructuraJson.getValueType();
			if(tipoEntradaJson==ValueType.OBJECT) {
				leerObjetoJson(); //estoy reabriendo alpedo elfile, solo esun ej..
			}else if (tipoEntradaJson==ValueType.ARRAY) {
				leerArrayJsonObjetosJson();//estoy reabriendo alpedo elfile.. 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
