package modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AnalizadorMetricas {
	//***************************
	//Muestra del gicherosCSV
	// (int)creador_id,	(String)plataforma,	(¿Date?/String)fecha,	(String)contenido,	(String)tipo,	(int)vistas,	(int)me_gusta,	(int)comentarios,	(int)compartidos
	//***************************
	private List<Metrica> metricas;
	
	
	public AnalizadorMetricas(List<Metrica> metricas) {	
		this.metricas = metricas;
		
	}
	
	//Promedios
	public double promedioVistas() {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			salida=salida+clave.getVistas();
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioMe_gusta() {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			salida=salida+clave.getVistas();
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioCompartidos() {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			salida=salida+clave.getVistas();
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioComentarios() {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			salida=salida+clave.getVistas();
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	
	//promedio por plataforma
	public double promedioVistasPlataforma(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getPlataforma().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getVistas();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioMe_gustaPlataforma(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getPlataforma().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getMe_gusta();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioCompartidosPlataforma(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getPlataforma().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getCompartidos();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	
	//promedio por tipo de publicacion
	public double promedioComentariosTipo(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getTipo().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getComentarios();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	
	public double promedioVistasTipo(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getTipo().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getVistas();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioMe_gustaTipo(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getTipo().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getMe_gusta();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioCompartidosTipo(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getTipo().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getCompartidos();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	public double promedioComentariosPlataforma(String plataforma) {
		double salida=0;
		int totalPublicaciones=0;
		for(Metrica clave: metricas) {
			if(clave.getPlataforma().equalsIgnoreCase(plataforma)) {
				salida=salida+clave.getComentarios();
			}
			totalPublicaciones++;
		}
			
		return salida/totalPublicaciones;	
	}
	
	
	//*************************************************
	//*************************************************
	//*************************************************
	//Publicaciones por ID
	public List<Integer> idExistentes(){
		List<Integer> salida=new ArrayList<Integer>();
		
		for(Metrica clave:metricas) {
			if(!salida.contains(clave.getCreador_id())) {
				salida.add(clave.getCreador_id());
			}
		}
		
		return salida;
	}
	
	
	public HashMap<Integer,Integer> publicacionesPorCreador(){
		HashMap<Integer,Integer> control=new HashMap<Integer,Integer>();
		int id;
		for(Metrica clave:metricas) {
			id=clave.getCreador_id();
			if(control.containsKey(id)) {
				control.put(id, control.get(id)+1);
			}else {
				control.put(id, 1);
			}	
		}
		return control;
	}
	
	public int creadorMasPublicaciones() {
		HashMap<Integer,Integer> control=publicacionesPorCreador();
		int id=-2;
		int total=-1;
		
		for(Map.Entry<Integer, Integer> clave:control.entrySet()) {
			if(clave.getValue()>total) {
				id=clave.getKey();
				total=clave.getValue();
			}else if(clave.getValue()==total) {
				id=-1;
			}
		}
		
		return id;
	}
	
	
	//Tipo de publicacion
	public List<String> tiposExistentes(){
		List<String> salida=new ArrayList<String>();
		
		for(Metrica clave:metricas) {
			if(!salida.contains(clave.getTipo())) {
				salida.add(clave.getTipo());
			}
		}
		if(salida.size()==0) {
			salida=null;
		}
		return salida;
		
	}
	
	public HashMap<String,Integer> publicacionesPorTipo(){
		HashMap<String,Integer> control=new HashMap<String,Integer>();
		String salida="";
		for(Metrica clave:metricas) {
			salida=clave.getTipo();
			if(control.containsKey(salida)) {
				control.put(salida, control.get(salida)+1);
			}else {
				control.put(salida, 1);
			}	
		}
		
		return control;
	}
	
	
	
	public String tipoMasComun() {
		String salida="";
		HashMap<String,Integer> control=publicacionesPorTipo();
		int total=-1;
		
		
		for(Map.Entry<String, Integer> clave: control.entrySet()) {
			if(clave.getValue()>total) {
				total=clave.getValue();
				salida=clave.getKey();
			}else if(clave.getValue()==total) {
				salida=salida+"*"+clave.getKey();
			}
		}
		
		return salida;
	}
	
	
	
	
	
	public String mejorRendimientoTipoPorPlataforma(String plataforma) {
		String salida=null;
		double rendimiento=-1;
		List<String> tipos=tiposExistentes();
		List<Metrica> metricas=filtrarPorplataforma(plataforma);
		double temp;
		for(String clave:tipos) {
			temp=promedioVistasTipo(clave);
			if(temp>rendimiento) {
				salida=clave;
				rendimiento=temp;
			}if(temp==rendimiento) {
				salida=salida+"*"+clave;
			}
		}
		return salida;
	}
	
	//Control de plataformas
	public List<String> plataformasExistentes(){
		List<String> salida=new ArrayList<String>();
		
		for(Metrica clave:metricas) {
			if(!salida.contains(clave.getPlataforma())) {
				salida.add(clave.getPlataforma());
			}
		}
		
		return salida;
	}
	
	
	
	public HashMap<String,Integer> publicacionesPorPlataforma(){
		HashMap<String,Integer> control=new HashMap<String,Integer>();
		String salida="";
		for(Metrica clave:metricas) {
			salida=clave.getTipo();
			if(control.containsKey(salida)) {
				control.put(salida, control.get(salida)+1);
			}else {
				control.put(salida, 1);
			}	
		}
		
		return control;
	}
	
	
	public String PlataformaMasComun() {
		String salida="";
		HashMap<String,Integer> control=publicacionesPorPlataforma();
		int total=-1;
		
		
		for(Map.Entry<String, Integer> clave: control.entrySet()) {
			if(clave.getValue()>total) {
				total=clave.getValue();
				salida=clave.getKey();
			}else if(clave.getValue()==total) {
				salida=salida+"*"+clave.getKey();
			}
		}
		
		return salida;
	}
		
	
	//filtros
	public List<Metrica> filtrarPorTipo(String tipo){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getTipo().equalsIgnoreCase(tipo)) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorplataforma(String plataforma){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getPlataforma().equalsIgnoreCase(plataforma)) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorId(int id){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getCreador_id()==id) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorVisitas(int min,int max){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getVistas()>=min&&clave.getVistas()<=max) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorMe_gusta(int min,int max){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getMe_gusta()>=min&&clave.getMe_gusta()<=max) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorCompartidos(int min,int max){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getCompartidos()>=min&&clave.getCompartidos()<=max) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
	
	public List<Metrica> filtrarPorCOmentarios(int min,int max){
		List<Metrica> salida=new ArrayList<Metrica>();
		
		for(Metrica clave:metricas) {
			if(clave.getComentarios()>=min&&clave.getComentarios()<=max) {
				salida.add(clave);
			}
		}
		
		return salida;
	}
}//fin class