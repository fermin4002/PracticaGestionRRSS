package modelo;

import com.opencsv.bean.CsvBindByName;

/*
 "colaborador" : "Pedro Gonzalez",
			"tematica" : "Tecnologia",
			"fecha_inicio" : "2023-07-01",
			"fecha_fin" : "2023-03-30",
			"tipo" : "Patrocinado",
			"estado" : "Activa"
 * */
public class Colaboracion {
	
	@CsvBindByName(column = "creador_id")
	private int creador_id;
	
	@CsvBindByName(column = "creador")
	private String creador;
	
	@CsvBindByName(column = "colaborador")
	private String colaborador;
	
	@CsvBindByName(column = "tematica")
	private String tematica;
	
	@CsvBindByName(column = "fecha_inicio")
	private String fecha_inicio;
	
	@CsvBindByName(column = "fecha_fin")
	private String fecha_fin;

	
	@CsvBindByName(column = "tipo")
	private String tipo;
	
	@CsvBindByName(column = "estado")
	private String estado;

	public Colaboracion(int creador_id, String creador, String colaborador, String fecha_inicio, String fecha_fin,
			String tipo, String estado,String tematica) {

		this.creador_id = creador_id;
		this.creador = creador;
		this.colaborador = colaborador;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tipo = tipo;
		this.estado = estado;
		this.tematica=tematica;
	}

	public int getCreador_id() {
		return creador_id;
	}

	public void setCreador_id(int creador_id) {
		this.creador_id = creador_id;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	@Override
	public String toString() {
		return "Colaboracion [creador_id=" + creador_id + ", creador=" + creador + ", colaborador=" + colaborador
				+ ", tematica=" + tematica + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", tipo="
				+ tipo + ", estado=" + estado + "]";
	}

	
	
	
	
	

	
	
	
	
}
