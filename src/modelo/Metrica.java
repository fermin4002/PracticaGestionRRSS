package modelo;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;

//***************************
//Muestra del gicherosCSV
//creador_id,plataforma,fecha,contenido,tipo,vistas,me_gusta,comentarios,compartidos
//***************************

public class Metrica {
	
	//********
	//Atributos
	//********
	
	@CsvBindByName(column = "creador_id")
	private int creador_id;
	
	@CsvBindByName(column = "plataforma")
	private String plataforma;

	@CsvBindByName(column = "fecha")
	private /*Date*/String fecha;
	
	@CsvBindByName(column = "contenido")
	private String contenido;
	
	@CsvBindByName(column = "tipo")
	private String tipo;
	
	@CsvBindByName(column = "vistas")
	private int vistas;
	
	@CsvBindByName(column = "me_gusta")
	private int me_gusta;
	
	@CsvBindByName(column = "comentarios")
	private int comentarios;
	
	@CsvBindByName(column = "compartidos")
	private int compartidos;
	
	//***********
	//Constructores
	//***********
	
	public Metrica() {
		
	}

	public Metrica(String plataforma,String tipo) {
		this.plataforma=plataforma;
		this.tipo=tipo;
		this.me_gusta=0;
		this.vistas=0;
		this.comentarios=0;
		this.compartidos=0;
	}
	
	public Metrica(String plataforma) {
		this.plataforma=plataforma;
		this.me_gusta=0;
		this.vistas=0;
		this.comentarios=0;
		this.compartidos=0;
	}
	
	public Metrica(int creador_id, String plataforma, /*Date*/String fecha, String contenido, String tipo, int vistas,
			int me_gusta, int comentarios, int compartidos) {
		this.creador_id = creador_id;
		this.plataforma = plataforma;
		this.fecha = fecha;
		this.contenido = contenido;
		this.tipo = tipo;
		this.vistas = vistas;
		this.me_gusta = me_gusta;
		this.comentarios = comentarios;
		this.compartidos = compartidos;
	}



	//**********
	//Getter And Setter
	//**********
	public int getCreador_id() {
		return creador_id;
	}


	public void setCreador_id(int creador_id) {
		this.creador_id = creador_id;
	}


	public String getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	public /*Date*/String getFecha() {
		return fecha;
	}


	public void setFecha(/*Date*/String fecha) {
		this.fecha = fecha;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getVistas() {
		return vistas;
	}


	public void setVistas(int vistas) {
		this.vistas = vistas;
	}


	public int getMe_gusta() {
		return me_gusta;
	}


	public void setMe_gusta(int me_gusta) {
		this.me_gusta = me_gusta;
	}


	public int getComentarios() {
		return comentarios;
	}


	public void setComentarios(int comentarios) {
		this.comentarios = comentarios;
	}


	public int getCompartidos() {
		return compartidos;
	}


	public void setCompartidos(int compartidos) {
		this.compartidos = compartidos;
	}

	//*********
	//Metodos Propios
	//*********
	
	
	

}
