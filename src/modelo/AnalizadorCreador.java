package modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class AnalizadorCreador {
	
	private JsonNode creador;
	
	public AnalizadorCreador() {
		
		this.creador=null;
		
	}

	public AnalizadorCreador(JsonNode creador) {
		
		this.creador = creador;
	}

	public JsonNode getCreador() {
		return creador;
	}

	public void setCreador(JsonNode creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "AnalizadorCreador [creador=" + creador + "]";
	}
	
	
	//Metodos Propios
	//Extraer Campos
	
	public int getId() {
		int salida=creador.get("id").asInt();
		return salida;
	}
	
	public String getNombre() {
		String salida=creador.get("nombre").asText();
		return salida;
	}
	
	
	public String getPais() {
		String salida=creador.get("pais").asText();
		return salida;
	}
	
	public String getTematica() {
		String salida=creador.get("tematica").asText();
		return salida;
	}
	
	public int getSeguidores_totales() {
		int salida=creador.get("seguidores_totales").asInt();
		return salida;
	}
	
	public JsonNode getEstadisticas() {
		JsonNode salida=null;
		salida=creador.get("estadisticas");
		
		return salida;
	}

	public int getInteraccionesTotales( ) {
		
		JsonNode nodo=getEstadisticas();
		int salida;
		salida=nodo.get("interacciones_totales").asInt();
		
		return salida;
		
	}
	
	public int getPromedioVistasMensuales( ) {
		
		JsonNode nodo=getEstadisticas();
		int salida;
		salida=nodo.get("promedio_vistas_mensuales").asInt();
		
		return salida;
		
	}

	public int getTasaCrecimientoSeguidores( ) {
	
	JsonNode nodo=getEstadisticas();
	int salida;
	salida=nodo.get("tasa_crecimiento_seguidores").asInt();
	
	return salida;
	
	}
	
	
	public ArrayNode getColaboraciones() {
		ArrayNode colaboracionesSalida=null;
		colaboracionesSalida=(ArrayNode) creador.get("colaboraciones");
		return colaboracionesSalida;
	}
	
	/*"colaborador" : "Pedro Gonzalez",
	"tematica" : "Tecnologia",
	"fecha_inicio" : "2023-07-01",
	"fecha_fin" : "2023-03-30",
	"tipo" : "Patrocinado",
	"estado" : "Activa"*/
	public void conversionColaboraciones(ArrayNode colaboracionesJson, List<Colaboracion> colaboracionesCsv) {
		int id=getId();
		String creador=getNombre();
		String colaborador,tipo,estado,tematica;
		String fecha_inicio,fecha_fin;
		//int vistas_mensuales=getPromedioVistasMensuales();
		//int crecimiento=getTasaCrecimientoSeguidores();
		
		for(JsonNode clave:colaboracionesJson) {
			colaborador=clave.get("colaborador").asText();
			fecha_inicio=clave.get("fecha_inicio").asText();
			fecha_fin=clave.get("fecha_fin").asText();
			estado=clave.get("estado").asText();
			tipo=clave.get("tipo").asText();
			tematica=clave.get("tematica").asText();
			colaboracionesCsv.add(new Colaboracion(id,creador,colaborador,fecha_inicio,fecha_fin,tipo,estado,tematica));
		}
		
		
	}
	
	
	public ArrayList<String> extraerRedes(){
		ArrayList<String> redes=new ArrayList<String>();
		
		for(JsonNode clave: creador.get("plataformas")) {
			redes.add(clave.get("nombre").asText());
		}
		
		return redes;
	}
	
	public JsonNode extraerPlataforma(String plataforma) {
		JsonNode plata=null;
		
		for(JsonNode clave: creador.get("plataformas")) {
			if(clave.get("nombre").asText().equalsIgnoreCase(plataforma)) {
				plata=clave;
			}
		}
		
		
		return plata;
	}
	
	public String getUsurioPlataforma(String plataforma) {
		
		JsonNode temp=extraerPlataforma(plataforma);
		
		return temp.get("usuario").asText();
	}
	
	public int getSeguidoresPlataforma(String plataforma) {
		
		JsonNode temp=extraerPlataforma(plataforma);
		
		return temp.get("seguidores").asInt();
	}

	public String getFechaCreacionPlataforma(String plataforma) {
	
		JsonNode temp=extraerPlataforma(plataforma);
	
		return temp.get("fecha_creacion").asText();
	}
	
	public JsonNode extraerHistoricoConcreto(String plataforma,String fecha) {
		
		JsonNode temp=extraerPlataforma(plataforma);
		JsonNode salida=null;
		for(JsonNode clave:temp.get("historico")) {
			if(fecha.equalsIgnoreCase(clave.get("fecha").asText())) {
				salida=clave;
			}
		}
		return salida;
	}
	
	
	public int getNuevosseguidores(String plataforma,String fecha) {
		
		JsonNode temp=extraerHistoricoConcreto(plataforma,fecha);
		
		return temp.get("nuevos_seguidores").asInt();
	}
	
	public int getInteraciones(String plataforma,String fecha) {
		
		JsonNode temp=extraerHistoricoConcreto(plataforma,fecha);
		
		return temp.get("interacciones").asInt();
	}
	
	public ArrayList<String> extraerFechasHistorico(String plataforma){
		ArrayList<String> historico=new ArrayList<String>();
		
		for(JsonNode clave:extraerPlataforma(plataforma).get("historico")) {
			historico.add(clave.get("fecha").asText());
		}
		
		return historico;
	}
	
	public ArrayNode extraerHistorico(String plataforma) {
		ArrayNode historico=null;
		for(JsonNode clave:creador.get("plataformas")) {
			if(clave.get("nombre").asText().equalsIgnoreCase(plataforma)) {
				historico=(ArrayNode) clave.get("historico");
			}
		}
		
		return historico;
	}
	
	public int  extraerTotalSeguidores() {
		int total=0;
		
		
		for(JsonNode clave:creador.get("plataformas")) {
			total=total+clave.get("seguidores").asInt();
		}
		
		
		return total;
	}
	
	public void insertarColaboracion(ObjectNode colab) {
		
		ArrayNode temp=(ArrayNode) creador.get("colaboraciones");
		
		temp.add(colab);
		
		//add(colab);
		
	}
	
}
