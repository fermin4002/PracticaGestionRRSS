package modelo;

import com.opencsv.bean.CsvBindByName;

public class ColaboracionReporte  {
	
	@CsvBindByName(column = "impacto_seguidores")
	private int impacto_seguidores;
	
	@CsvBindByName(column = "visualizaciones")
	private int visualizaciones;
	
	@CsvBindByName(column = "creador_id")
	private int creador_id;
	
	@CsvBindByName(column = "creador")
	private String creador;
	
	@CsvBindByName(column = "colaborador")
	private String colaborador;

	@CsvBindByName(column = "fecha_inicio")
	private String fecha_inicio;
	
	@CsvBindByName(column = "fecha_fin")
	private String fecha_fin;

	

	public ColaboracionReporte(int impacto_seguidores, int visualizaciones, int creador_id, String creador, String colaborador,
			String fecha_inicio, String fecha_fin) {
		
		this.impacto_seguidores = impacto_seguidores;
		this.visualizaciones = visualizaciones;
		this.creador_id = creador_id;
		this.creador = creador;
		this.colaborador = colaborador;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public int getimpacto_seguidores() {
		return impacto_seguidores;
	}

	public void setimpacto_seguidores(int impacto_seguidores) {
		this.impacto_seguidores = impacto_seguidores;
	}

	public int getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
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

	@Override
	public String toString() {
		return "ColaboracionReporte [impacto_seguidores=" + impacto_seguidores + ", visualizaciones=" + visualizaciones + ", creador_id="
				+ creador_id + ", creador=" + creador + ", colaborador=" + colaborador + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + "]";
	}

	
	
	
}
