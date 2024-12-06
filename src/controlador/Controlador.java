package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import vista.*;
import modelo.*;

public class Controlador implements ActionListener,MouseListener,FocusListener {
	
	private Vista vista;
	//Control de ficheros
	private  ObjectMapper mapa;
	private  JsonNode rootNode;
	private  ArrayNode arrayCreadores;
	private  List<Metrica> metricas;
	
	//Menu
	
	//DefaultModel
	DefaultTableModel modeloTablaE1;
	//Control de variables
	private ArrayList<String> nombreCreadores;
	//******************
	public Controlador() {
		
	}
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
		//modeloTablaE1=new
		
	
		
		//Vista
		this.vista=vista;
		
		
		//Barra de navegacion
		vista.e1.setActionCommand("ir vista general");
		vista.e1.addActionListener(this);
		vista.e2E7E9.setActionCommand("ir a analisis");
		vista.e2E7E9.addActionListener(this);
		vista.exportar.setActionCommand("ir a exportar");
		vista.exportar.addActionListener(this);
		vista.e3.setActionCommand("ir crear colaboracion");
		vista.e3.addActionListener(this);
		
		//Botones
		//ej1
		//ej2
		//ej3
		//ej4
		vista.btnE4.setActionCommand("e4");
		vista.btnE4.addActionListener(this);
		//ej5
		//ej6
		vista.btnE6.setActionCommand("e6");
		vista.btnE6.addActionListener(this);
		//ej7
		//ej8
		vista.btnE8.setActionCommand("e8");
		vista.btnE8.addActionListener(this);
		//ej9
		//ej10
		vista.btnE10.setActionCommand("e10");
		vista.btnE10.addActionListener(this);
		//ej11
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
		//ej2
		vista.e2Creadores.addActionListener(this);
		vista.e2Creadores.setActionCommand("e2CambiarCreador");
		vista.e2RedSocial.addActionListener(this);
		vista.e2RedSocial.setActionCommand("e2CambiarPlataforma");
		//ej3
		//ej4
		
		//ej5
		//ej6
		
		//ej7
		//ej8
		
		//ej9
		//ej10
		
		//ej11
		//ej12
		
		
		//asignarModelos
		vista.e1TablaColaboraciones.setModel(modeloTablaE1);
		
		
		
		cargarIdNombreCreador(nombreCreadores);
		cargarComboBox(vista.e1Creadores, nombreCreadores);
		cargarComboBox(vista.e2Creadores,nombreCreadores);
		cargarComboBox(vista.e3Creador1,nombreCreadores);
		cargarComboBox(vista.e3Creador2,nombreCreadores);
		String id=nombreCreadores.get(0).split("-")[0];
		extraerInformacionCreador(Integer.parseInt(id));
		
	}
	
	//Pruebas
	/*public static void main(String[]args) throws Exception {
		Controlador lanza=new Controlador();
		lanza.redirigirSalidas();
		
		
		mapa=new ObjectMapper();
		metricas=lanza.abrirCSV("ficheros/metricas_contenido.csv");
		lanza.abrirJson("ficheros/creadores.json");
		
		lanza.exportarColaboraciones();
		
	}*/
	
	
	//******************************************************
	//Control Botones
	//******************************************************
	@Override
	public void actionPerformed(ActionEvent e) {
		String id;
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
				irCrearColaboraciones();
				id=nombreCreadores.get(0).split("-")[0];
				
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
				id=String.valueOf(vista.e1Creadores.getSelectedItem()).split("-")[0];
				analizarCambioCreador(Integer.parseInt(id));
				System.out.println("Creador e2 Cambiado");
			break;
			case "e2CambiarPlataforma":
				id=String.valueOf(vista.e1Creadores.getSelectedItem()).split("-")[0];
				analizarMetricas(Integer.parseInt(id));
				System.out.println("Plataforma e2 Cambiada");
			break;
			
			//e3
			
			//e5-e11
			
			//e4
			case "e4":
				
				System.out.println(" ");
			break;	
					
			//e6
			case "e6":
				
				System.out.println(" ");
			break;

			//e8
			case "e8":
				
				System.out.println(" ");
			break;	
		
			//e10
			case "e10":
				
				System.out.println(" ");
			break;	
			

			//e12
			case "e12":
				
				System.out.println(" ");
			break;	
			//
			default:
				System.out.println("Evento "+e.getActionCommand()+" no encontrado");
			break;
		}	
	}

	//******************************************************
	//Control Raton
	//******************************************************
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	//******************************************************
	//Control Foco
	//******************************************************
	@Override
	public void focusGained(FocusEvent e) {
		
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		
		
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
	}
	
	public void irVistaAnalisis() {
		
		vista.pE2E7.setVisible(true);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(false);
	}
	
	public void irVistaExportar() {
	
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(false);
		vista.pExportar.setVisible(true);
	}
	
	public void irCrearColaboraciones() {
		
		vista.pE2E7.setVisible(false);
		vista.pE1.setVisible(false);
		vista.pE3.setVisible(true);
		vista.pExportar.setVisible(false);
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
		cargarComboBox(vista.e1Historico, analizador.extraerHistorico(plataforma));
		
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
		List<Metrica> metricas=buscarMetricas(id);
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		
		String plataforma=String.valueOf(vista.e2RedSocial.getSelectedItem());
		String creador=String.valueOf(vista.e2Creadores.getSelectedItem()).split("-")[1];
		
		double meGusta,vistas;
		String mejorTipo;
		
		meGusta=analizador.promedioMe_gustaPlataforma(plataforma);
		vistas=analizador.promedioVistasPlataforma(plataforma);
		mejorTipo=analizador.mejorRendimientoTipoPorPlataforma(plataforma);
		
		vista.e2PromedioMeGusta.setText("Promedio me gustas "+creador+": "+meGusta);
		vista.e2PromedioVistas.setText("Promedio vistas "+creador+": "+vistas);
		
		vista.e2ContenidoCreador.setText("Contenido que mejor funciona a "+creador+":");
		vista.e2MejorContenidoCreador.setText(mejorTipo);
		
		vista.e2ContenidoPlataforma.setText("Contenido que mejor funciona en "+plataforma+":");
		vista.e2MejorContenidoPlataforma.setText(mejorTipo);
		
		vista.e2Logo.setIcon(new ImageIcon("recursosImg\\"+plataforma+".png"));
		
		System.out.println("Metricas Analizadas");
		
	}
	

	//EJ3(logica-falta interfaz-falta)
	public void crearColaboracion() {
		int id1=Integer.parseInt(String.valueOf(vista.e3Creador1.getSelectedItem()).split("-")[0]);
		int id2=Integer.parseInt(String.valueOf(vista.e3Creador2.getSelectedItem()).split("-")[0]);
		
		if(id1!=id2) {
			JsonNode creador=buscarCreador(id1);
			JsonNode colab=buscarCreador(id2);
		}else {
			
		}
		
		
		
	}
	
	//EJ5//EJ11
	public void crearPublicacion() {
		
	}
	
	public void eliminarPublicacion() {
		
	}
	//EJ4
	public void exportarColaboracionesCSV() {
		
	}
	//EJ6
	public void crearInformeCreadoresJson() {
		
	}
	//EJ8
	public void crearInformeColaboracionesCSV() {
	
	}
	//EJ10
	public void crearResumenRendimiento() {
		
	}
	//EJ12
	public void exportarColaboracionesJson() {
		
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
	
	public  void cargarComboBox(JComboBox<String> box ,ArrayList<String> items){
		
		DefaultComboBoxModel<String> modelo=new DefaultComboBoxModel<String>();
		
		for(String clave:items) {
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
	
	public List<Metrica> buscarMetricas(int creadorId){
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
	
	
	
}//Fin Class
