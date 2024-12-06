package controlador;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import modelo.Colaboracion;
import modelo.Metrica;

public class prueba {
	
	private static  ObjectMapper mapa;
	private  JsonNode rootNode;
	private  ArrayNode arrayCreadores;
	private static  List<Metrica> metricas;
	
	public static void main(String[]args) throws Exception {
		//Configuracion
		prueba prueba=new prueba();
				prueba.redirigirSalidas();
				//Variables-Constructores
				
				mapa=new ObjectMapper();
				
				prueba.abrirJson("ficheros/creadores.json");
				
				try {
					metricas=prueba.abrirCSV("ficheros/metricas_contenido.csv");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	
				
				
	//e1
	public void mostrarCreador() {
		
	}
				
	//*************************
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
	public  List<Metrica> abrirCSV(String rutaCSV) throws Exception{
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
}
