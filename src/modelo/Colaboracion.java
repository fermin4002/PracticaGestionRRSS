package modelo;

import java.sql.Date;

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
	
	@CsvBindByName(column = "fecha_inicio")
	private String fecha_inicio;
	
	@CsvBindByName(column = "creador")
	private String creaodr;
	
	@CsvBindByName(column = "colaborador")
	private String colaborador;
	
	
	@CsvBindByName(column = "vistas_mensuales")
	private int vistas_mensuales;
	
	@CsvBindByName(column = "crecimiento_seguidores")
	private int crecimiento_seguidores;

	public Colaboracion(int creador_id, String fecha_inicio, String creaodr, String colaborador, int vistas_mensuales,
			int crecimiento_seguidores) {
		this.creador_id = creador_id;
		this.fecha_inicio = fecha_inicio;
		this.creaodr = creaodr;
		this.colaborador = colaborador;
		this.vistas_mensuales = vistas_mensuales;
		this.crecimiento_seguidores = crecimiento_seguidores;
	}

	public int getCreador_id() {
		return creador_id;
	}

	public void setCreador_id(int creador_id) {
		this.creador_id = creador_id;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getCreaodr() {
		return creaodr;
	}

	public void setCreaodr(String creaodr) {
		this.creaodr = creaodr;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public int getVistas_mensuales() {
		return vistas_mensuales;
	}

	public void setVistas_mensuales(int vistas_mensuales) {
		this.vistas_mensuales = vistas_mensuales;
	}

	public int getCrecimiento_seguidores() {
		return crecimiento_seguidores;
	}

	public void setCrecimiento_seguidores(int crecimiento_seguidores) {
		this.crecimiento_seguidores = crecimiento_seguidores;
	}

	@Override
	public String toString() {
		return "Colaboracion [creador_id=" + creador_id + ", fecha_inicio=" + fecha_inicio + ", creaodr=" + creaodr
				+ ", colaborador=" + colaborador + ", vistas_mensuales=" + vistas_mensuales
				+ ", crecimiento_seguidores=" + crecimiento_seguidores + "]";
	}
	
	

	
	
	
	
}
