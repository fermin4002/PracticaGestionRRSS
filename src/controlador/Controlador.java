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
import java.util.List;

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
	private static ObjectMapper mapa;
	private static JsonNode rootNode;
	private static ArrayNode arrayCreadores;
	private static List<Metrica> metricas;
	
	//Control de variables
	private ArrayList<String> redesSociales;
	//******************
	public Controlador() {
		
	}
	public Controlador(Vista vista) throws Exception {
		//Configuracion
		redirigirSalidas();
		//Variables-Constructores
		this.mapa=new ObjectMapper();
		
		abrirJson("ficheros/creadores.json");
		
		try {
			this.metricas=abrirCSV("ficheros/metricas_contenido.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		redesSociales=cargarRRSS();
		
		//Vista
		this.vista=vista;
		
		//Botones
		
		
	}
	
	//Pruebas
	public static void main(String[]args) throws Exception {
		Controlador lanza=new Controlador();
		lanza.redirigirSalidas();
		
		
		mapa=new ObjectMapper();
		metricas=lanza.abrirCSV("ficheros/metricas_contenido.csv");
		lanza.abrirJson("ficheros/creadores.json");
		
		lanza.buscarCreador(5);
		lanza.buscarMetricas(5);
	}
	
	
	//******************************************************
	//Control Botones
	//******************************************************
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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
	
	public void crearCSV(List<Metrica> nombreObjeto, String rutaCSV) throws Exception{
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
	
	//EJ2(logica-Fin interfaz-Falta)
	public void analizarMetricas(String nombre,String plataforma) {
		JsonNode creador=buscarCreador(nombre);
		List<Metrica> metricas=buscarMetricas(creador.get("id").asInt());
		//Creacion analizador
		AnalizadorMetricas analizador=new AnalizadorMetricas(metricas);
		double meGusta,vistas;
		String mejorTipo;
		meGusta=analizador.promedioMe_gustaPlataforma(plataforma);
		vistas=analizador.promedioVistasPlataforma(plataforma);
		mejorTipo=analizador.mejorRendimientoTipoPorPlataforma(plataforma);
		System.out.println("Metricas Analizadas");

	}
	
	//EJ3(logica-falta interfaz-falta)
	public void crearColaboracion(String nombre,String colaborador) {
		JsonNode creador=buscarCreador(nombre);
		JsonNode colab=buscarCreador(colaborador);
		
	}
	
	//EJ4(logica-falta interfaz-falta)
	public void exportarColaboraciones() {
		List<Colaboracion> colaboraciones=new ArrayList<Colaboracion>();
		
		ArrayNode temp=null;
		AnalizadorCreador analizador=new AnalizadorCreador();
		for(JsonNode clave:arrayCreadores) {
			analizador.setCreador(clave);
			
			
			
		}
		
			
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
	
	
	public JsonNode buscarCreador(int idCreador) {
		JsonNode salida=null;
		
		for(JsonNode claves:arrayCreadores) {
			if(claves.get("id").asInt()==idCreador) {
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
	
	
	
	
}//Fin Class
