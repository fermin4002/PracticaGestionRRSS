package modelo;

import com.fasterxml.jackson.databind.JsonNode;

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
	
	
}
