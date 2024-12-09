package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import vista.*;
import modelo.*;

public class Controlador implements ActionListener,KeyListener {
	
	private Vista vista;
	//Control de ficheros
	private  ObjectMapper mapa;
	private  JsonNode rootNode;
	private  ArrayNode arrayCreadores;
	private  List<Metrica> metricas;
	
	private ButtonGroup estado;
	private int esta;
	//Menu
	
	//DefaultModel
	DefaultTableModel modeloTablaE1,modeloTablaE9,modeloTablaE5;
	//Control de variables
	private ArrayList<String> nombreCreadores;
	//******************
	
	public Controlador(Vista vista) throws Exception {
		//Configuracion
		redirigirSalidas();
		//Variables-Constructores
		nombreCreadores=new ArrayList<String>();
		this.mapa=new ObjectMapper();
		
		abrirJson("ficheros/creadores.json");
		
		//Revisar Date/String
		try {
			this.metricas=abrirCSV("ficheros/metricas_contenido.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//redesSociales=cargarRRSS();
		
		
		//Modelos
		modeloTablaE1=new DefaultTableModel();
		modeloTablaE1.addColumn("Colaborador");
		modeloTablaE1.addColumn("Tematica");
		modeloTablaE1.addColumn("Fecha inicio");
		modeloTablaE1.addColumn("Fecha fin");
		modeloTablaE1.addColumn("Tipo");
		modeloTablaE1.addColumn("Estado");
		
		modeloTablaE9=new DefaultTableModel();
		modeloTablaE9.addColumn("Tipo");
		modeloTablaE9.addColumn("Promedio vistas");
		modeloTablaE9.addColumn(" Promedio me gustas");

		modeloTablaE5=new DefaultTableModel();
		modeloTablaE5.addColumn("id");
		modeloTablaE5.addColumn("plataforma");
		modeloTablaE5.addColumn("fecha");
		modeloTablaE5.addColumn("contenido");
		modeloTablaE5.addColumn("tipo");
		modeloTablaE5.addColumn("vistas");
		modeloTablaE5.addColumn("Me gusta");
		modeloTablaE5.addColumn("Comentarios");
		modeloTablaE5.addColumn("Compartidos");
		//modeloTablaE1=new
		
	
		
		//Vista
		this.vista=vista;
		
		//TextFields
		vista.e5ComentariosRellenar.addKeyListener(this);
		vista.e5MeGustaRellenar.addKeyListener(this);
		vista.e5VistasRellenar.addKeyListener(this);
		vista.e5CompartidosRellenar.addKeyListener(this);
		vista.e5Cantidad.addKeyListener(this);
		//Barra de navegacion
		vista.e1.setActionCommand("ir vista general");
		vista.e1.addActionListener(this);
		vista.e2E7E9.setActionCommand("ir a analisis");
		vista.e2E7E9.addActionListener(this);
		vista.exportar.setActionCommand("ir a exportar");
		vista.exportar.addActionListener(this);
		vista.e3.setActionCommand("ir crear colaboracion");
		vista.e3.addActionListener(this);
		vista.e5E11.setActionCommand("ir gestion publicacion");
		vista.e5E11.addActionListener(this);
		vista.itemMetricas.setActionCommand("guardar metricas");
		vista.itemMetricas.addActionListener(this);
		vista.intemCreadores.setActionCommand("guardar creadores");
		vista.intemCreadores.addActionListener(this);
		
		//Botones
		//ej3
		vista.btnE3CrearColaboracion.setActionCommand("crear colaboracion");
		vista.btnE3CrearColaboracion.addActionListener(this);
		vista.e3Activa.setActionCommand("activa");
		vista.e3Activa.addActionListener(this);
		vista.e3Finalizada.setActionCommand("finalizada");
		vista.e3Finalizada.addActionListener(this);
		
		//ej4
		vista.btnE4.setActionCommand("e4");
		vista.btnE4.addActionListener(this);
		
		//ej5//ej11
		vista.btnE5FiltroCreador.setActionCommand("e5FiltrarCreador");
		vista.btnE5FiltroCreador.addActionListener(this);
		vista.btnE5FiltroPlataforma.setActionCommand("e5FiltrarPlataforma");
		vista.btnE5FiltroPlataforma.addActionListener(this);
		vista.btnE5MostrarTodas.setActionCommand("e5MostrarTodas");
		vista.btnE5MostrarTodas.addActionListener(this);
		vista.btnE5MostrarMetrica.setActionCommand("e5MostrarMetrica");
		vista.btnE5MostrarMetrica.addActionListener(this);
		vista.btnE5CrearPublicacion.setActionCommand("crear publicacion");
		vista.btnE5CrearPublicacion.addActionListener(this);
		vista.btnE5EditarPublicacion.setActionCommand("editar publicacion");
		vista.btnE5EditarPublicacion.addActionListener(this);
		vista.btnE5EliminarTodas.setActionCommand("eliminar todas");
		vista.btnE5EliminarTodas.addActionListener(this);
		vista.btnE5EliminarActual.setActionCommand("eliminar actual");
		vista.btnE5EliminarActual.addActionListener(this);
		
		//ej6
		vista.btnE6.setActionCommand("e6");
		vista.btnE6.addActionListener(this);
		//ej8
		vista.btnE8.setActionCommand("e8");
		vista.btnE8.addActionListener(this);
		//ej10
		vista.btnE10.setActionCommand("e10");
		vista.btnE10.addActionListener(this);
		//ej12
		vista.btnE12.setActionCommand("e12");
		vista.btnE12.addActionListener(this);
	
		
		//ComboBox
		//ej1
		vista.e1Creadores.addActionListener(this);
		vista.e1Creadores.setActionCommand("e1Cambiar");
		vista.e1RedSocial.addActionListener(this);
		vista.e1RedSocial.setActionCommand("e1CambiarPlataforma");
		vista.e1Historico.addActionListener(this);
		vista.e1Historico.setActionCommand("e1CambiarHistorico");
		//ej2//ej7//ej9
		vista.e2Creadores.addActionListener(this);
		vista.e2Creadores.setActionCommand("e2CambiarCreador");
		vista.e2RedSocial.addActionListener(this);
		vista.e2RedSocial.setActionCommand("e2CambiarPlataforma");	
		//e3
		vista.e3Creador1.addActionListener(this);
		vista.e3Creador1.setActionCommand("e3ActualizarColabos");
		vista.e3Creador2.addActionListener(this);
		vista.e3Creador2.setActionCommand("e3ActualizarColabos");	
		
		//ej5//ej11
		vista.e5Creadores.addActionListener(this);
		vista.e5Creadores.setActionCommand("e5ActualizarRedes");
		vista.e5Contenido.addActionListener(this);
		vista.e5Contenido.setActionCommand("cargar contenido");
		

		
		//asignarModelos
		vista.e1TablaColaboraciones.setModel(modeloTablaE1);
		vista.e9Tabla.setModel(modeloTablaE9);
		vista.e3Tabla.setModel(modeloTablaE1);
		vista.e5Tabla.setModel(modeloTablaE5);
		estado=new ButtonGroup();
		estado.add(vista.e3Activa);
		estado.add(vista.e3Finalizada);
		
		cargarIdNombreCreador(nombreCreadores);
		cargarComboBox(vista.e1Creadores, nombreCreadores);
		cargarComboBox(vista.e2Creadores,nombreCreadores);
		cargarComboBox(vista.e3Creador1,nombreCreadores);
		cargarComboBox(vista.e3Creador2,nombreCreadores);
		cargarComboBox(vista.e5Creadores,nombreCreadores);
		cargarComboBox(vista.e5Contenido, new AnalizadorMetricas(metricas).extraerContenidos());
		String id=nombreCreadores.get(0).split("-")[0];
		extraerInformacionCreador(Integer.parseInt(id));
		List<String> parametros=new ArrayList<String>();
		parametros.add("vistas");
		parametros.add("me_gusta");
		parametros.add("comentarios");
		parametros.add("compartidos");
		cargarComboBox(vista.e5Parametro,parametros );
	}

	//******************************************************
	//Control Botones
	//******************************************************
	@Override
	public void actionPerformed(ActionEvent e) {
		String id;
		AnalizadorMetricas analizador=new AnalizadorMetricas();
		switch(e.getActionCommand()) {
			//movimiento entre menus
			case "ir vista general":
				irVistaGeneral();
				id=nombreCreadores.get(0).split("-")[0];
				extraerInformacionCreador(Integer.parseInt(id));
			break;
		
			case "ir a analisis":
				irVistaAnalisis();
				id=nombreCreadores.get(0).split("-")[0];
				analizarCambioCreador(Integer.parseInt(id));
			break;
			case "ir a exportar":
				irVistaExportar();
				
			break;
			case "ir crear colaboracion":
				cargarColaboracionesE3();
				irCrearColaboraciones();
			break;
			case "ir gestion publicacion":
				cargarMetricasTabla(modeloTablaE5, metricas);
				irGestionarPublicaciones();
				id=String.valueOf(vista.e5Contenido.getSelectedItem());
				cargarContenidoE5(id);
			break;
			case "guardar metricas":
				try {
					crearMetricaCSV(metricas, "ficherosSalida/metricas.csv");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			break;
			case "guardar creadores":
				try {
					guardarJson("ficherosSalida/creadores.json", rootNode);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			break;
		
			//e1
			case "menu":
			System.out.println("Funciona");
			break;
			case "e1Cambiar":
				id=String.valueOf(vista.e1Creadores.getSelectedItem()).split("-")[0];
				extraerInformacionCreador(Integer.parseInt(id));
				System.out.println("Creador e1 Cambiado");
			break;
			case "e1CambiarPlataforma":
				id=String.valueOf(vista.e1Creadores.getSelectedItem()).split("-")[0];
				extraerInformacionPlataforma(Integer.parseInt(id));
				System.out.println("Plataforma e1 Cambiada");
			break;
			case "e1CambiarHistorico":
				id=String.valueOf(vista.e1Creadores.getSelectedItem()).split("-")[0];
				extraerInformacionHistorico(Integer.parseInt(id));
				System.out.println("Historico e1 Cambiado");
			break;
			
			//e2-e7-e9
			case "e2CambiarCreador":
				id=String.valueOf(vista.e2Creadores.getSelectedItem()).split("-")[0];
				analizarCambioCreador(Integer.parseInt(id));
				System.out.println("Creador e2 Cambiado");
			break;
			case "e2CambiarPlataforma":
				id=String.valueOf(vista.e2Creadores.getSelectedItem()).split("-")[0];
				analizarMetricas(Integer.parseInt(id));
				System.out.println("Plataforma e2 Cambiada");
			break;
			
			//e3
			case "e3ActualizarColabos":
				cargarColaboracionesE3();
				break;
			case "crear colaboracion":
				crearColaboracion();
				cargarColaboracionesE3();
				System.out.println("Colaboracion e3 Creada");
			break;
			case "activa":
				esta=1;
				System.out.println("Colaboracion e3 Creada");
			break;
			case "finalizada":
				esta=0;
				System.out.println("Colaboracion e3 Creada");
			break;
			//e5-e11
			case "e5ActualizarRedes":
				
				id=String.valueOf(vista.e5Creadores.getSelectedItem()).split("-")[0];
				
				cargarRed(Integer.parseInt(id));
				System.out.println("Redes actualizadas");
			break;
			case "e5FiltrarCreador":
				analizador.setMetricas(metricas);
				id=String.valueOf(vista.e5Creadores.getSelectedItem()).split("-")[0];
				if(null!=id) {
					cargarMetricasTabla(modeloTablaE5, analizador.filtrarPorId(Integer.parseInt(id)));
				}			

			break;
			case "e5FiltrarPlataforma":
				analizador.setMetricas(metricas);
				String plataforma=String.valueOf(vista.e5Plataforma.getSelectedItem());
				if(null!=plataforma) {
					cargarMetricasTabla(modeloTablaE5, analizador.filtrarPorPlataforma(plataforma));
				}

			break;
			case"e5MostrarMetrica":
				String publicacion=String.valueOf(vista.e5Contenido.getSelectedItem());
				analizador.setMetricas(metricas);
				modeloTablaE5.setRowCount(0);
				Metrica metrica=analizador.extraerMetrica(publicacion);
				modeloTablaE5.addRow(new String[] {String.valueOf(metrica.getCreador_id()),metrica.getPlataforma(),metrica.getFecha(),
						metrica.getContenido(),metrica.getTipo(),String.valueOf(metrica.getVistas()),
						String.valueOf(metrica.getMe_gusta()),String.valueOf(metrica.getComentarios()),String.valueOf(metrica.getCompartidos())});
				
			break;
			
			case"e5MostrarTodas":
				cargarMetricasTabla(modeloTablaE5, metricas);
			break;
			
			case "cargar contenido":
				id=String.valueOf(vista.e5Contenido.getSelectedItem());
				cargarContenidoE5(id);
			break;
			
			case"crear publicacion":
				id=crearPublicacion();
				cargarComboBox(vista.e5Contenido, new AnalizadorMetricas(metricas).extraerContenidos());
				cargarContenidoE5(id);
				vista.e5Contenido.setSelectedItem(id);
			break;
			
			case "editar publicacion":
				editarPublicacion();
				id=String.valueOf(vista.e5Contenido.getSelectedItem());
				cargarMetricasTabla(modeloTablaE5, metricas);
				cargarContenidoE5(id);
				vista.e5Contenido.setSelectedItem(id);
			break;
			case "eliminar todas":
				eliminarPublicacion(Integer.parseInt(vista.e5Cantidad.getText()),String.valueOf(vista.e5Parametro.getSelectedItem()));
				cargarComboBox(vista.e5Contenido, new AnalizadorMetricas(metricas).extraerContenidos());
				id=String.valueOf(vista.e5Contenido.getSelectedItem());
				cargarMetricasTabla(modeloTablaE5, metricas);
				cargarContenidoE5(id);
				vista.e5Contenido.setSelectedItem(id);
			break;
			
			case "eliminar actual":
				analizador.setMetricas(metricas);
				Metrica metrica2=analizador.extraerMetrica(String.valueOf(vista.e5Contenido.getSelectedItem()));
				metricas.remove(metrica2);
				cargarComboBox(vista.e5Contenido, new AnalizadorMetricas(metricas).extraerContenidos());
				id=String.valueOf(vista.e5Contenido.getSelectedItem());
				cargarMetricasTabla(modeloTablaE5, metricas);
				cargarContenidoE5(id);
				vista.e5Contenido.setSelectedItem(id);
			break;
			
			//e4
			case "e4":
				exportarColaboracionesCSV();
				System.out.println("Exportar COlaboraciones csv");
			break;	
					
			//e6
			case "e6":
				crearInformeCreadoresJson("ficherosSalida/reporte_creadores.json");
				System.out.println("Informe json creado  ");
			break;

			//e8
			case "e8":
				crearInformeColaboracionesCSV();
				System.out.println("Informe csv creado ");
			break;	
		
			//e10
			case "e10":
				añadirPlataformasPreferentes();
				System.out.println("Plataformas preferentes añadidas");
			break;	
			

			//e12
			case "e12":
				exportarColaboracionesJson();
				System.out.println("COlaboraciones.json creado");
			break;	
			//
			default:
				System.out.println("Evento "+e.getActionCommand()+" no encontrado");
			break;
		}	
	}
	
	//******************************************************
	//Control Teclas
	//******************************************************
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		char c = e.getKeyChar();
        if (!Character.isDigit(c)) { // Verifica si no es un dígito
            e.consume(); // Ignora el carácter
        }
	}
	//******************************************************
	//Configuracion
	//******************************************************
	public  void redirigirSalidas() {
		
		try {
			File ficheroSalida=new File("salidasConsola/errores.log");
			PrintStream salida=new PrintStream(ficheroSalida);
			System.setErr(salida);
			
			ficheroSalida=new File("salidasConsola/terminal.txt");
			salida=new PrintStream(ficheroSalida);	
			System.setOut(salida);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> cargarRRSS() {
		ArrayList<String> salida=new ArrayList<String>();
		
		for(Metrica clave:metricas) {
			if(!salida.contains(clave.getPlataforma())) {
				salida.add(clave.getPlataforma());
			}
		}
		
		return salida;
	}
	
	//******************************************************
	//Apertura y cierre de CSV
	//******************************************************
	public List<Metrica> abrirCSV(String rutaCSV) throws Exception{
		List<Metrica> nombreObjeto = null;
		try  {
			FileReader reader = new FileReader(rutaCSV);
			
			CsvToBeanBuilder<Metrica> csvBuilder = new CsvToBeanBuilder<Metrica>(reader);
			CsvToBean<Metrica> csv = csvBuilder.withType(Metrica.class).withIgnoreLeadingWhiteSpace(true).build();

			nombreObjeto = csv.parse();
			System.out.println("fichero CSV encontrado");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("fichero CSV no encontrado");
            throw e;
        }
		
		return nombreObjeto;
	}//fin abrirCSV
	
	public void crearMetricaCSV(List<Metrica> nombreObjeto, String rutaCSV) throws Exception{
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<Metrica> beanToCsv = new StatefulBeanToCsvBuilder<Metrica>(fw).build();
            beanToCsv.write(nombreObjeto);
            fw.flush();
            System.out.println("fichero CSV creado");
		}catch (Exception e) {
            e.printStackTrace();
            System.err.println("fichero CSV no creado");
            throw e;
        }
	}//fin crearCSV
	
	public void crearColabCSV(List<Colaboracion> nombreObjeto, String rutaCSV) throws Exception{
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<Colaboracion> beanToCsv = new StatefulBeanToCsvBuilder<Colaboracion>(fw).build();
            beanToCsv.write(nombreObjeto);
            fw.flush();
            System.out.println("fichero CSV creado");
		}catch (Exception e) {
            e.printStackTrace();
            System.err.println("fichero CSV no creado");
            throw e;
        }
	}//fin crearCSV
	
	public void crearColabReporteCSV(List<ColaboracionReporte> nombreObjeto, String rutaCSV) throws Exception{
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<ColaboracionReporte> beanToCsv = new StatefulBeanToCsvBuilder<ColaboracionReporte>(fw).build();
            beanToCsv.write(nombreObjeto);
            fw.flush();
            System.out.println("fichero CSV creado");
		}catch (Exception e) {
            e.printStackTrace();
            System.err.println("fichero CSV no creado");
            throw e;
        }
	}//fin crearCSV
	
	//******************************************************
	//Apertura y cierre de Json
	//******************************************************
	public void abrirJson(String ficheroJson) throws Exception{
		@SuppressWarnings("unused")
		File jsonFile = new File(ficheroJson);
		try {
			rootNode = mapa.readTree(new File(ficheroJson));
			
			arrayCreadores=(ArrayNode) rootNode.get("creadores");
			System.out.println("fichero JSON encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("fichero JSON no encontrado");
			throw e;
		} 
	}//fin abrirJson
	
	public void guardarJson(String rutaJson, JsonNode rootNode)throws Exception {
		try {
			mapa.writeValue(new File(rutaJson), rootNode);
			System.out.println("fichero JSON creado");
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("fichero JSON no creado");
			throw e;
		}
		
	}//fin guardarJson
	
	//******************************************************
	//Metodos Propios
	//******************************************************
	
	//******************************************************
	//Movimiento entre menus 
	//******************************************************
	public void irVistaGeneral() {
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(true);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(false);
		vista.pE5E11.setVisible(false);
	}
	
	public void irVistaAnalisis() {
		vista.pE2E7.setVisible(true);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(false);
		vista.pE5E11.setVisible(false);
	}
	
	public void irVistaExportar() {
		vista.exportando.setText("");
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(true);
		vista.pE5E11.setVisible(false);
	}
	
	public void irCrearColaboraciones() {
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(true);
		vista.pExportar.setVisible(false);
		vista.pE5E11.setVisible(false);
	}
	
	public void irGestionarPublicaciones() {
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(false);
		vista.pE5E11.setVisible(true);
	}
	//******************************************************
	//Ejercicios  
	//******************************************************
	//EJ1
	public void extraerInformacionCreador(int idCreador) {
		JsonNode creador=buscarCreador(idCreador);
		AnalizadorCreador analizador=new AnalizadorCreador(creador);
		
		
		cargarComboBox(vista.e1RedSocial, analizador.extraerRedes());
		
		vista.e1Pais.setText("País: "+analizador.getPais());
		vista.e1Tematica.setText("Tematica: "+analizador.getTematica());
		vista.e1SeguidoresTotales.setText("Seguidores totales: "+String.valueOf(analizador.getSeguidores_totales()));
		
		vista.e1InteracionesTotales.setText("Interacciones totales: "+String.valueOf(analizador.getInteraccionesTotales()));
		vista.e1PromedioVisitas.setText("Promedio vistas mensuales: "+String.valueOf(analizador.getPromedioVistasMensuales()));
		vista.e1TasaCrecimiento.setText("Tasa de crecimiento de seguidores: "+String.valueOf(analizador.getTasaCrecimientoSeguidores()));
		
		cargarTablas(modeloTablaE1,analizador.getColaboraciones());
		
		
		extraerInformacionPlataforma(idCreador);
		
		extraerInformacionHistorico( idCreador);
		
		
	}
	
	public void extraerInformacionPlataforma(int idCreador) {
		JsonNode creador=buscarCreador(idCreador);
		AnalizadorCreador analizador=new AnalizadorCreador(creador);
		
		
		String plataforma=String.valueOf(vista.e1RedSocial.getSelectedItem());
		//ArrayList<String>historico=
		cargarComboBox(vista.e1Historico, analizador.extraerFechasHistorico(plataforma));
		
		vista.e1Usuario.setText("Usuario: "+analizador.getUsurioPlataforma(plataforma));
		vista.e1Seguidores.setText("Seguidores: "+analizador.getSeguidoresPlataforma(plataforma));
		vista.e1FechaCreacion.setText("Fecha creacion: "+analizador.getFechaCreacionPlataforma(plataforma));
		
		extraerInformacionHistorico( idCreador);
	
	}
	
	public void extraerInformacionHistorico(int idCreador) {
		JsonNode creador=buscarCreador(idCreador);
		AnalizadorCreador analizador=new AnalizadorCreador(creador);
		
		String plataforma=String.valueOf(vista.e1RedSocial.getSelectedItem());
		String fecha=String.valueOf(vista.e1Historico.getSelectedItem());
		//RevisarAqui
		vista.e1SeguidoresNuevos.setText("Nuevos seguidores: "+analizador.getNuevosseguidores(plataforma, fecha));
		vista.e1Interacciones.setText("Interacciones: "+analizador.getInteraciones(plataforma, fecha));
		
	}
	
	
	//EJ2//EJ7//EJ9
	public void analizarCambioCreador(int id ) {
		
		
		//Creacion analizador
		AnalizadorCreador analizador=new AnalizadorCreador(buscarCreador(id));
		
		cargarComboBox(vista.e2RedSocial, analizador.extraerRedes());
		
		analizarMetricas(id);
	}
	
	public void analizarMetricas(int id ) {

		String plataforma=String.valueOf(vista.e2RedSocial.getSelectedItem());
		String creador=String.valueOf(vista.e2Creadores.getSelectedItem()).split("-")[1];
		
		analizarCreadorE2(creador,plataforma,id);
		
		analizarCreadorE7(creador,plataforma,id);
		
		analizarPlataformaE9(creador, plataforma, id);
		
		//ej7
		
		
		vista.e2Logo.setIcon(new ImageIcon("recursosImg\\"+plataforma+".png"));
		
		System.out.println("Metricas Analizadas");
		
	}
	
	//Ej2
	public void analizarCreadorE2(String creador ,String plataforma,int id) {
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		List<Metrica> metricasTemp=analizador.filtrarPorId(id);
		analizador.setMetricas(metricasTemp);
		
		//ej2
		double meGusta,vistas;
		String mejorTipoPersona;
		
		metricasTemp=analizador.filtrarPorPlataforma(plataforma);
		
		analizador.setMetricas(metricasTemp);
		
		meGusta=analizador.promedioMe_gusta();
		vistas=analizador.promedioVistas();
		 
		meGusta=(double)((int)(meGusta*100))/100;
		vistas=(double)((int)(vistas*100))/100;
		
		mejorTipoPersona=analizador.mejorRendimientoTipo();
		
		vista.e2PromedioMeGusta.setText("Promedio me gustas "+creador+": "+meGusta);
		vista.e2PromedioVistas.setText("Promedio vistas "+creador+": "+vistas);
		
		vista.e2ContenidoCreador.setText("Contenido que mejor funciona a "+creador+":");
		vista.e2MejorContenidoCreador.setText(mejorTipoPersona);
		
	}

	//Ej7
	public void analizarCreadorE7(String creador ,String plataforma,int id) {
		//(V.Final-V.inicial)/V.inicial (*100 si muestras en %)
		
		AnalizadorCreador analizadorCreador=new AnalizadorCreador(buscarCreador(id));
		ArrayNode historico=analizadorCreador.extraerHistorico(plataforma);			
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaMin=LocalDate.parse("2022-12-31", formato);
		LocalDate fechaMax=LocalDate.parse("2023-04-01", formato);
		LocalDate fechaTemp;
		
		double total=0;
		double totalFin=analizadorCreador.getSeguidoresPlataforma(plataforma);
		
		for(JsonNode clave:historico) {
			fechaTemp=LocalDate.parse(clave.get("fecha").asText(), formato);	
			
			if(fechaTemp.isBefore(fechaMax)&&fechaTemp.isAfter(fechaMin)) {
				
				total=total+clave.get("nuevos_seguidores").asDouble();
			}
			
		}
		
		double totalIni=totalFin-total;
			
		double crecimiento=(totalFin-totalIni)/totalIni;
		crecimiento=(double)((int)(crecimiento*10000))/100;
		
		vista.e2TasaCrecimiento.setText("Tasa de crecimiento 1º trimestre:"+crecimiento+"%");
		
	}
	
	//Ej9
	public void analizarPlataformaE9(String creador ,String plataforma,int id) {
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		List<Metrica> metricasTemp=analizador.filtrarPorPlataforma(plataforma);
		analizador.setMetricas(metricasTemp);
		
		
		String mejorTipoPlataforma=analizador.mejorRendimientoTipo() ;
		
		List<String> tipos=analizador.tiposExistentes();
		
		double meGustaTemp;
		double vistasTemp;
		AnalizadorMetricas analizadorTemp;
		
		modeloTablaE9.setRowCount(0);
		for(String clave:tipos) {
			analizadorTemp=new AnalizadorMetricas(analizador.filtrarPorTipo(clave));		
			meGustaTemp=analizadorTemp.promedioMe_gusta();
			vistasTemp=analizadorTemp.promedioVistas();
			 
			meGustaTemp=(double)((int)(meGustaTemp*100))/100;
			vistasTemp=(double)((int)(vistasTemp*100))/100;
			
			modeloTablaE9.addRow(new String[] {clave,String.valueOf(vistasTemp),String.valueOf(meGustaTemp)});
		}
		
		vista.e2ContenidoPlataforma.setText("Contenido que mejor funciona en "+plataforma+":");
		vista.e2MejorContenidoPlataforma.setText(mejorTipoPlataforma);
	}

	
	
	//EJ3
	public void crearColaboracion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		int id1=Integer.parseInt(String.valueOf(vista.e3Creador1.getSelectedItem()).split("-")[0]);
		int id2=Integer.parseInt(String.valueOf(vista.e3Creador2.getSelectedItem()).split("-")[0]);
		
		LocalDate fechaInicio=null;
		LocalDate fechaFin=null;
		try {
			fechaInicio=LocalDate.parse(String.valueOf(vista.e3FechaInicio.getText()),formato);
			fechaFin=LocalDate.parse(String.valueOf(vista.e3FechaFin.getText()),formato);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ha oasad");
		String colaborador1=String.valueOf(vista.e3Creador1.getSelectedItem()).split("-")[1];
		String colaborador2=String.valueOf(vista.e3Creador2.getSelectedItem()).split("-")[1];
		String tematica=String.valueOf(vista.e3Tematica.getText());
		String tipo=String.valueOf(vista.e3Tipo.getText());
		String estadoFin=null;
		esta=-1;
		
		if(esta==1) {
			estadoFin="Activa";
		}else if(esta==0) {
			estadoFin="Finalizada";
		}
		AnalizadorCreador analizador=new AnalizadorCreador();
		if(id1!=id2) {
			if(fechaInicio!=null&&fechaFin!=null&&tematica!=null&&tipo!=null&&esta==-1&&fechaInicio.isBefore(fechaFin)) {
				
				String fecha=fechaInicio.format(formato);
				String fecha2=fechaFin.format(formato);
				
				ObjectNode colaboracion=mapa.createObjectNode();
				colaboracion.put("colaborador", colaborador2);
				colaboracion.put("tematica", tematica);
				colaboracion.put("fecha_inicio", fecha);
				colaboracion.put("fecha_fin", fecha2);
				colaboracion.put("tipo", tipo);
				colaboracion.put("estado", estadoFin);
				
				ObjectNode colaboracion2=mapa.createObjectNode();
				colaboracion2.put("colaborador", colaborador1);
				colaboracion2.put("tematica", tematica);
				colaboracion2.put("fecha_inicio", fecha);
				colaboracion2.put("fecha_fin", fecha2);
				colaboracion2.put("tipo", tipo);
				colaboracion2.put("estado", estadoFin);
				
				
				analizador.setCreador(buscarCreador(id1));
				analizador.insertarColaboracion(colaboracion);
				
				analizador.setCreador(buscarCreador(id2));
				analizador.insertarColaboracion(colaboracion2);
	
				
			}else {
				vista.e3Error.setText("<html>Debes rellenar todos los campos,<br> sigue el formato de la fecha<html>");
			}
			
		}else {
			vista.e3Error.setText("Los colaboradores no pueden ser el mismo");
		}
		
		
		
	}
	
	public void cargarColaboracionesE3() {
		String id1=String.valueOf(vista.e3Creador1.getSelectedItem()).split("-")[0];
		String id2=String.valueOf(vista.e3Creador2.getSelectedItem()).split("-")[0];
		String colaborador1=String.valueOf(vista.e3Creador1.getSelectedItem()).split("-")[1];
		String colaborador2=String.valueOf(vista.e3Creador2.getSelectedItem()).split("-")[1];
		
		List<String[]> lista=new ArrayList<String[]>();
		AnalizadorCreador analizador=new AnalizadorCreador(buscarCreador(Integer.parseInt(id1)));
		//cargarTablas(modeloTablaE1,analizador.getColaboraciones());6
		lista.add(new String[] {id1+"-",colaborador1,"----","----","----","----"});
		extraerColab(lista, analizador.getColaboraciones());
		lista.add(new String[] {id2+"-",colaborador2,"----","----","----","----"});
		analizador.setCreador(buscarCreador(Integer.parseInt(id2)));
		extraerColab(lista, analizador.getColaboraciones());
		
		modeloTablaE1.setRowCount(0);
		for(String[] clave:lista) {
			modeloTablaE1.addRow(clave);
		}
		
		
	}
	
	
	//EJ5//EJ11
	public String crearPublicacion() {
		int tamano=metricas.size();
		tamano++;
		String nombre="Contenido "+tamano;
		int id=Integer.parseInt(String.valueOf(vista.e5Creadores.getSelectedItem()).split("-")[0]);
		String plataforma=String.valueOf(vista.e5Plataforma.getSelectedItem());
		
		while(existePublicacion(nombre)) {
			tamano++;
			nombre="Contenido "+tamano;
		}
		
		metricas.add(new Metrica(id,plataforma,nombre));
		cargarMetricasTabla(modeloTablaE5, metricas);
		return nombre;
	}
	
	public void cargarRed(int idCreador) {
		JsonNode creador=buscarCreador(idCreador);
		AnalizadorCreador analizador=new AnalizadorCreador(creador);
		cargarComboBox(vista.e5Plataforma, analizador.extraerRedes());
		
	}
	
	public void cargarContenidoE5(String publicacion) {
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		Metrica metrica=analizador.extraerMetrica(publicacion);
		
		vista.e5Creadores.setSelectedIndex(metrica.getCreador_id());
		vista.e5Plataforma.setSelectedItem(metrica.getPlataforma());
		
		vista.e5Fecha.setText("<html>(aaaa-MM-dd)Fecha:<br>"+metrica.getFecha()+"<html>");
		vista.e5FechaRellenar.setText(String.valueOf(metrica.getFecha()));
		
		
		vista.e5Tipo.setText("Tipo:"+metrica.getMe_gusta());
		vista.e5TipoRellenar.setText(String.valueOf(metrica.getTipo()));
		
		vista.e5Vistas.setText("Vistas:"+metrica.getVistas());
		vista.e5VistasRellenar.setText(String.valueOf(metrica.getVistas()));
		vista.e5MeGusta.setText("Me gusta:"+metrica.getMe_gusta());
		vista.e5MeGustaRellenar.setText(String.valueOf(metrica.getMe_gusta()));
		vista.e5Comentarios.setText("Comentarios:"+metrica.getComentarios());
		vista.e5ComentariosRellenar.setText(String.valueOf(metrica.getComentarios()));
		vista.e5Compartidos.setText("Compartidos:"+metrica.getCompartidos());
		vista.e5CompartidosRellenar.setText(String.valueOf(metrica.getCompartidos()));
		
		
	}
	public void editarPublicacion() {
		String publicacion =String.valueOf(vista.e5Contenido.getSelectedItem());
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		Metrica metrica=analizador.extraerMetrica(publicacion);
		
		metrica.setTipo(vista.e5TipoRellenar.getText());
		
		
		if(vista.e5TipoRellenar.getText()!=null) {
			metrica.setTipo(vista.e5TipoRellenar.getText());
		}
		
		if(vista.e5FechaRellenar.getText()!=null) {
			metrica.setFecha(vista.e5FechaRellenar.getText());
		}
		
		if(vista.e5VistasRellenar.getText()==null) {
			metrica.setVistas(0);
		}else {
			metrica.setVistas(Integer.parseInt(vista.e5VistasRellenar.getText()));
		}
		
		if(vista.e5CompartidosRellenar.getText()==null) {
			metrica.setCompartidos(0);
		}else {
			metrica.setCompartidos(Integer.parseInt(vista.e5CompartidosRellenar.getText()));
		}
		
		if(vista.e5ComentariosRellenar.getText()==null) {
			metrica.setComentarios(0);
		}else {
			metrica.setComentarios(Integer.parseInt(vista.e5ComentariosRellenar.getText()));
		}
		
		if(vista.e5MeGustaRellenar.getText()==null) {
			metrica.setMe_gusta(0);
		}else {
			metrica.setMe_gusta(Integer.parseInt(vista.e5MeGustaRellenar.getText()));
		}
		
		
	}
	
	public void eliminarPublicacion(int cantidad,String parametro) {
		//vistas,me_gusta,comentarios,compartidos
		for(int i = metricas.size()-1; i >= 0; i--) {
			switch(parametro) {
			
				case "vistas":
					if(metricas.get(i).getVistas()<cantidad) {
						metricas.remove(i);
					}
					break;
				case "me_gusta":
					if(metricas.get(i).getMe_gusta()<cantidad) {
						metricas.remove(i);
					}
					break;
				case "comentarios":
					if(metricas.get(i).getComentarios()<cantidad) {
						metricas.remove(i);
					}
					break;
				case "compartidos":
					if(metricas.get(i).getCompartidos()<cantidad) {
						metricas.remove(i);
					}
					break;
			}
		}
	}
	
	//EJ4
	public void exportarColaboracionesCSV() {
		AnalizadorCreador analizador=new AnalizadorCreador();
		List<ColaboracionReporte> colabo=new ArrayList<ColaboracionReporte>();
		for(JsonNode clave:arrayCreadores) {
			analizador.setCreador(clave);
			
			int impacto=analizador.getInteraccionesTotales();
			int visualizaciones=analizador.getPromedioVistasMensuales();
			int idCreador=analizador.getId();
			String creador=analizador.getNombre();
			
			String fechaIni,fechaFin,colaborador;
			
			for(JsonNode colaboracion:clave.get("colaboraciones")) {
				colaborador=colaboracion.get("colaborador").asText();
				fechaIni=colaboracion.get("fecha_inicio").asText();
				fechaFin=colaboracion.get("fecha_fin").asText();
				
				colabo.add(new ColaboracionReporte(impacto,visualizaciones,idCreador,creador,colaborador,fechaIni,fechaFin));
			}
			
		}
		
		try {
			crearColabReporteCSV(colabo, "ficherosSalida/ colaboraciones.csv");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		vista.exportando.setText("Fichero  colaboraciones.csv creado");
	}
	//EJ6
	public void crearInformeCreadoresJson(String url) {
		ObjectNode rootNode=mapa.createObjectNode();
		ArrayNode arrayCreadores=mapa.createArrayNode();
		double total=0,totalTemp;
		String plataforma="No se dispone de informacion sobre supublicaciones";
		ObjectNode nodo;
		List<Metrica> temporal,temporalPlataforma;
		List<String> redes;
		AnalizadorCreador analizador=new AnalizadorCreador();
		AnalizadorMetricas metricas=new AnalizadorMetricas();
		for(JsonNode clave:this.arrayCreadores) {
			metricas.setMetricas(this.metricas);
			nodo=mapa.createObjectNode();
			analizador.setCreador(clave);
			redes=analizador.extraerRedes();
			plataforma="No se dispone de informacion sobre supublicaciones";
			temporal=metricas.filtrarPorId(analizador.getId());
			
			metricas.setMetricas(temporal);
			total=analizador.extraerTotalSeguidores();
			
			nodo.put("id", analizador.getId());
			nodo.put("nombre", analizador.getNombre());
			nodo.put("total_seguidores", total);
			
			total=-1;
			
			for(String red:redes) {
				totalTemp=0;
				metricas.setMetricas(temporal);
				temporalPlataforma=metricas.filtrarPorPlataforma(red);
				metricas.setMetricas(temporalPlataforma);
				
				totalTemp=metricas.promedioComentarios()+metricas.promedioCompartidos()+metricas.promedioMe_gusta();
				
				if(total<totalTemp) {
					total=totalTemp;
					plataforma=red;
				}
				
			}
			
			
			
			nodo.put("plataforma_mas_interaciones", plataforma);
			arrayCreadores.add(nodo);
		}
		
		rootNode.set("creadores", arrayCreadores);
		
		try {
			guardarJson(url, rootNode);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		vista.exportando.setText("Fichero  reporte_creadores.json creado");
		
	}
	//EJ8
	public void crearInformeColaboracionesCSV() {
		List<Colaboracion>colaboracion=new ArrayList<Colaboracion>();
		AnalizadorCreador analizador=new AnalizadorCreador();
		ArrayNode colaboraciones;
		for(JsonNode clave:arrayCreadores) {
			analizador.setCreador(clave);
			colaboraciones=analizador.getColaboraciones();
			analizador.conversionColaboraciones(colaboraciones, colaboracion);
		}
		
		try {
			crearColabCSV(colaboracion, "ficherosSalida/reporte_colaboracione.csv");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		vista.exportando.setText("Fichero colaboraciones.csv creado");
	}
	
	//EJ10
	public void añadirPlataformasPreferentes() {
		AnalizadorCreador analizador=new AnalizadorCreador();
		AnalizadorMetricas metricas=new AnalizadorMetricas();
		
		for(JsonNode clave:arrayCreadores) {
			
			analizador.setCreador(clave);
			metricas.setMetricas(this.metricas);
			
			List<String> redes=analizador.extraerRedes();
			List<Metrica>temporalPlataforma,temporal;
			
			int totalInteraciones=-1,totalVistas=-1,totalTemp;
			String plataformaInteracciones="No disponemos de metricas sobre sus publicaciones";
			String plataformaVistas="No disponemos de metricas sobre sus publicaciones";
			
			
			temporal=metricas.filtrarPorId(analizador.getId());
			metricas.setMetricas(temporal);
			
			for(String red:redes) {
				totalTemp=0;
				metricas.setMetricas(temporal);
				temporalPlataforma=metricas.filtrarPorPlataforma(red);
				metricas.setMetricas(temporalPlataforma);
				
				totalTemp=metricas.totalComentarios()+metricas.totalCompartidos()+metricas.totalMe_gusta();
				
				if(totalInteraciones<totalTemp) {
					totalInteraciones=totalTemp;
					plataformaInteracciones=red;
				}
				
				totalTemp=metricas.totalVistas();
				
				if(totalVistas<totalTemp) {
					totalVistas=totalTemp;
					plataformaVistas=red;
				}
			}
			
			ObjectNode nodo=mapa.createObjectNode();
			nodo.put("plataforma_mas_vistas", plataformaVistas);
			nodo.put("plataforma_mas_interacciones", plataformaInteracciones);
			
			ObjectNode nodoCreador=(ObjectNode)clave;
			nodoCreador.set("plataformas_preferentes", nodo);
		}
		vista.exportando.setText("Plataformas añadidas ");
	}
	//EJ12
	public void exportarColaboracionesJson() {
		AnalizadorCreador analizador=new AnalizadorCreador();
		ObjectNode rootNode=mapa.createObjectNode();
		ArrayNode arrayCreadores=mapa.createArrayNode();
		
		ObjectNode creador,colabora;
		ArrayNode colaboraciones;
		for(JsonNode clave:this.arrayCreadores) {
			analizador.setCreador(clave);
			creador=mapa.createObjectNode();
			int impacto=analizador.getInteraccionesTotales();
			int visualizaciones=analizador.getPromedioVistasMensuales();
			int idCreador=analizador.getId();
			String nombreCreador=analizador.getNombre();
			
			creador.put("id_creador", idCreador);
			creador.put("nombre_creador", nombreCreador);
			creador.put("impacto_seguidores", impacto);
			creador.put("visualizaciones", visualizaciones);
			
			String fechaIni,fechaFin,colaborador;
			colaboraciones=mapa.createArrayNode();
			for(JsonNode colaboracion:clave.get("colaboraciones")) {
				colabora=mapa.createObjectNode();
				colaborador=colaboracion.get("colaborador").asText();
				fechaIni=colaboracion.get("fecha_inicio").asText();
				fechaFin=colaboracion.get("fecha_fin").asText();
				
				colabora.put("colaborador",colaborador);
				colabora.put("fecha_inicio",fechaIni);
				colabora.put("fecha_fin",fechaFin);
				
				colaboraciones.add(colabora);
			}
			creador.set("colaboraciones", colaboraciones);
			
			arrayCreadores.add(creador);
		}
		rootNode.set("creadores", arrayCreadores);
		
		try {
			guardarJson("ficherosSalida/colaboraciones.json",rootNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vista.exportando.setText("Fichero colaboraciones.json creado");
	}
	
	//******************************************************
	//Metodos Auxiliares
	//******************************************************
	public JsonNode buscarCreador(String nombre) {
		JsonNode salida=null;
		for(JsonNode clave:arrayCreadores) {
			if(clave.get("nombre").asText().equalsIgnoreCase(nombre)) {
				salida=clave;
			}
		}
		return salida;
	}
	
	public  void cargarComboBox(JComboBox<String> box ,List<String> list){
		
		DefaultComboBoxModel<String> modelo=new DefaultComboBoxModel<String>();
		
		for(String clave:list) {
			modelo.addElement(clave);
		}
		box.setModel(modelo);
		
	}
	
	public void cargarTablas(DefaultTableModel modelo,ArrayNode colaboraciones) {
		
		String colaborador,tematica,fecha_inicio,fecha_fin,tipo,estado;
		
		modelo.setRowCount(0);
		
		for(JsonNode clave:colaboraciones) {
			colaborador=clave.get("colaborador").asText();
			tematica=clave.get("tematica").asText();
			fecha_inicio=clave.get("fecha_inicio").asText();
			fecha_fin=clave.get("fecha_fin").asText();
			tipo=clave.get("tipo").asText();
			estado=clave.get("estado").asText();
			
			modelo.addRow(new String[] {colaborador,tematica,fecha_inicio,fecha_fin,tipo,estado});
		}
		
		
	}
	
	public List<String[]> extraerColab(List<String[]> lista,ArrayNode colaboraciones) {
		
		String colaborador,tematica,fecha_inicio,fecha_fin,tipo,estado;

		for(JsonNode clave:colaboraciones) {
			colaborador=clave.get("colaborador").asText();
			tematica=clave.get("tematica").asText();
			fecha_inicio=clave.get("fecha_inicio").asText();
			fecha_fin=clave.get("fecha_fin").asText();
			tipo=clave.get("tipo").asText();
			estado=clave.get("estado").asText();
			
			lista.add(new String[] {colaborador,tematica,fecha_inicio,fecha_fin,tipo,estado});
		}
		
		return lista;
	}
	
	public void cargarMetricasTabla(DefaultTableModel modelo,List<Metrica> metricas) {
		//creador_id,plataforma,fecha,contenido,tipo,vistas,me_gusta,comentarios,compartidos
		
		String creador_id,plataforma,fecha,contenido,tipo,vistas,me_gusta,comentarios,compartidos;
		
		
		
		modelo.setRowCount(0);
		for(Metrica clave:metricas) {
			
			creador_id=String.valueOf(clave.getCreador_id());
			plataforma=clave.getPlataforma();
			fecha=clave.getFecha();
			contenido=clave.getContenido();
			tipo=clave.getTipo();
			vistas=String.valueOf(clave.getVistas());
			me_gusta=String.valueOf(clave.getMe_gusta());
			comentarios=String.valueOf(clave.getComentarios());
			compartidos=String.valueOf(clave.getCompartidos());
			
			modelo.addRow(new String[] {creador_id,plataforma,fecha,contenido,tipo,vistas,me_gusta,comentarios,compartidos});
		}
		
		
	}
	
	public JsonNode buscarCreador(int idCreador) {
		JsonNode salida=null;
		
		for(JsonNode clave:arrayCreadores) {
			if(clave.get("id").asInt()==idCreador) {
				salida=clave;
				System.out.println("Creador encontrado");
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarMetricasId(int creadorId){
		List<Metrica> metricasId=new ArrayList<Metrica>();
		
		for(Metrica valor:metricas) {
			if(valor.getCreador_id()==creadorId) {
				metricasId.add(valor);
			}
			
		}
		System.out.println("Mtricas totales de creadorId "+creadorId+" son:"+metricasId.size());
		return metricasId;
	}
	
	
	
	public void cargarIdNombreCreador(ArrayList<String> creadores) {
		String nombre;
		for(JsonNode clave: arrayCreadores) {
			nombre=clave.get("id").asText()+"-"+clave.get("nombre").asText();
			creadores.add(nombre);
		}
	}
	
	public boolean existePublicacion(String publi) {
		boolean salida=false;
		for(Metrica clave:metricas) {
			if(clave.getContenido().equalsIgnoreCase(publi)) {
				salida=true;
			}
		}
		return salida;
	}

	
	
	
	
}//Fin Class
