package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField; 

public class Vista extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel pE2E7;
	public JPanel pE3;
	public JComboBox<String> e2Creadores;
	public JComboBox<String> e2RedSocial;
	public JPanel panel;
	public JLabel e2PromedioMeGusta;
	public JPanel panel_1;
	public JLabel e2ContenidoCreador;
	public JPanel panel_2;
	public JLabel e2PromedioVistas;
	public JPanel pE1;
	public JComboBox<String> e1Creadores;
	public JPanel panel_3;
	public JComboBox<String> e1RedSocial;
	public JTable e1TablaColaboraciones;
	public JScrollPane scrollPane;
	public JPanel panel_10;
	public JLabel e1FechaCreacion_1;
	public JLabel e1Pais;
	public JLabel e1Tematica;
	public JLabel e1SeguidoresTotales;
	public JPanel panel_4;
	public JLabel e1InteracionesTotales;
	public JLabel e1PromedioVisitas;
	public JLabel e1TasaCrecimiento;
	public JPanel panel_5;
	public JLabel e1Usuario;
	public JLabel e1Seguidores;
	public JLabel e1FechaCreacion;
	public JPanel panel_6;
	public JLabel e1Interacciones;
	public JLabel e1SeguidoresNuevos;
	public JPanel panel_7;
	public JPanel panel_8;
	public JComboBox<String> e1Historico;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JPanel pExportar;
	public JPanel panel_9;
	public JLabel lblExportar;
	public JButton btnE4;
	public JButton btnE6;
	public JButton btnE8;
	public JButton btnE10;
	public JButton btnE12;
	public JPanel panel_11;
	public JLabel exportando;
	public JLabel e2MejorContenidoCreador;
	public JPanel panel_12;
	public JLabel e2TasaCrecimiento;
	public JPanel panel_13;
	public JLabel e2ContenidoPlataforma;
	public JLabel e2MejorContenidoPlataforma;
	public JLabel e2Logo;
	public JPanel pBarraNavegacion;
	public JMenuBar menuBar;
	public JMenu btnAnalisis;
	public JMenu btnExportar;
	public JMenu btnAnadirEliminar;
	public JComboBox <String> e3Creador2;
	public JPanel panel_14;
	public JLabel e2PromedioMeGusta_2;
	public JPanel panel_15;
	public JLabel e2PromedioMeGusta_5;
	public JPanel panel_16;
	public JLabel e2PromedioMeGusta_7;
	public JPanel panel_17;
	public JLabel e2PromedioMeGusta_9;
	public JPanel panel_18;
	public JLabel e2PromedioMeGusta_11;
	public JComboBox <String> e3Creador1;
	public JPanel panel_20;
	public JButton btnE3CrearColaboracion;
	public JLabel lblNewLabel_3;
	public JTextField e3Tematica;
	public JTextField e3Tipo;
	public JRadioButton e3Activa;
	public JRadioButton e3Finalizada;
	public JTable e3Tabla;
	public JScrollPane scrollPane_1;
	public JPanel pE5E11;
	public JMenuItem e3;
	public JMenuItem e5E11;
	public JMenuItem e1;
	public JMenuItem e2E7E9;
	public JMenuItem exportar;
	public JLabel e3Error;
	public JTable e9Tabla;
	public JScrollPane scrollPane_2;
	public JFormattedTextField e3FechaInicio;
	public JFormattedTextField e3FechaFin;
	SimpleDateFormat formatoFecha;
	public JTable e5Tabla;
	public JScrollPane scrollPane_3;
	public JComboBox<String> e5Creadores;
	public JComboBox<String> e5Plataforma;
	public JPanel panel_19;
	public JButton btnE5FiltroCreador;
	public JButton btnE5FiltroPlataforma;
	public JButton btnE5MostrarTodas;
	public JComboBox<String> e5Contenido;
	public JLabel lblNewLabel_2;
	public JLabel e5Tipo;
	public JLabel e5Fecha;
	public JTextField e5TipoRellenar;
	public JPanel panel_21;
	public JButton btnE5MostrarMetrica;
	public JFormattedTextField e5FechaRellenar;
	public JTextField e5MeGustaRellenar;
	public JTextField e5CompartidosRellenar;
	public JTextField e5VistasRellenar;
	public JTextField e5ComentariosRellenar;
	public JLabel e5MeGusta;
	public JLabel e5Vistas;
	public JLabel e5Compartidos;
	public JLabel e5Comentarios;
	public JPanel panel_22;
	public JPanel panel_23;
	public JButton btnE5CrearPublicacion;
	public JButton btnE5EditarPublicacion;
	public JComboBox <String>e5Parametro;
	public JLabel lblNewLabel_4;
	public JTextField e5Cantidad;
	public JLabel lblNewLabel_5;
	public JButton btnE5EliminarTodas;
	public JButton btnE5EliminarActual;
	public JMenu menuGuardar;
	public JMenuItem intemCreadores;
	public JMenuItem itemMetricas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista vista = new Vista();
					
					@SuppressWarnings("unused")
					Controlador controlador=new Controlador(vista);
					
					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 900, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pE2E7 = new JPanel();
		pE2E7.setLayout(null);
		pE2E7.setBounds(0, 30, 880, 660);
		pE2E7.setVisible(false);
		
		pExportar = new JPanel();
		pExportar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pExportar.setLayout(null);
		pExportar.setBounds(220, 30, 440, 660);
		pExportar.setVisible(false);
		contentPane.add(pExportar);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(110, 30, 220, 38);
		pExportar.add(panel_9);
		
		lblExportar = new JLabel("Exportar");
		lblExportar.setHorizontalAlignment(SwingConstants.CENTER);
		lblExportar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExportar.setBounds(10, 0, 200, 38);
		panel_9.add(lblExportar);
		
		btnE4 = new JButton("Exportar colaboraciones CSV");
		btnE4.setBounds(80, 100, 280, 30);
		pExportar.add(btnE4);
		
		btnE6 = new JButton("Informe de creadores Json");
		btnE6.setBounds(80, 151, 280, 30);
		pExportar.add(btnE6);
		
		btnE8 = new JButton("Reporte de colaboraciones CSV");
		btnE8.setBounds(80, 206, 280, 30);
		pExportar.add(btnE8);
		
		btnE10 = new JButton("Actualizar plataformas creadores.json");
		btnE10.setBounds(80, 256, 280, 30);
		pExportar.add(btnE10);
		
		btnE12 = new JButton("Exportar colaboraciones Json");
		btnE12.setBounds(80, 308, 280, 30);
		pExportar.add(btnE12);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(80, 389, 280, 137);
		pExportar.add(panel_11);
		panel_11.setLayout(null);
		
		exportando = new JLabel("");
		exportando.setForeground(new Color(0, 255, 0));
		exportando.setHorizontalAlignment(SwingConstants.CENTER);
		exportando.setBounds(30, 11, 220, 115);
		panel_11.add(exportando);
		
		pE1 = new JPanel();
		pE1.setLayout(null);
		pE1.setBounds(0, 30, 880, 660);
		contentPane.add(pE1);
		
		e1Creadores = new JComboBox<String>();
		e1Creadores.setBounds(116, 11, 170, 50);
		pE1.add(e1Creadores);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 83, 383, 109);
		pE1.add(panel_3);
		
		e1Pais = new JLabel("Pais:");
		e1Pais.setBounds(10, 11, 363, 23);
		panel_3.add(e1Pais);
		
		e1Tematica = new JLabel("Tematica:");
		e1Tematica.setBounds(10, 45, 363, 23);
		panel_3.add(e1Tematica);
		
		e1SeguidoresTotales = new JLabel("Seguidores totales:");
		e1SeguidoresTotales.setBounds(10, 75, 363, 23);
		panel_3.add(e1SeguidoresTotales);
		
		e1RedSocial = new JComboBox<String>();
		e1RedSocial.setBounds(563, 11, 170, 50);
		pE1.add(e1RedSocial);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 437, 860, 212);
		pE1.add(scrollPane);
		
		e1TablaColaboraciones = new JTable();
		scrollPane.setViewportView(e1TablaColaboraciones);
		
		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(240, 388, 383, 38);
		pE1.add(panel_10);
		
		e1FechaCreacion_1 = new JLabel("Colaboraciones");
		e1FechaCreacion_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		e1FechaCreacion_1.setHorizontalAlignment(SwingConstants.CENTER);
		e1FechaCreacion_1.setAlignmentX(0.5f);
		e1FechaCreacion_1.setBounds(0, 0, 383, 38);
		panel_10.add(e1FechaCreacion_1);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 268, 383, 109);
		pE1.add(panel_4);
		
		e1InteracionesTotales = new JLabel("Interacciones totales:");
		e1InteracionesTotales.setBounds(10, 11, 363, 23);
		panel_4.add(e1InteracionesTotales);
		
		e1PromedioVisitas = new JLabel("Promedio visistas mensuales:");
		e1PromedioVisitas.setBounds(10, 45, 363, 23);
		panel_4.add(e1PromedioVisitas);
		
		e1TasaCrecimiento = new JLabel("Tasa de crecimiento de seguidores:");
		e1TasaCrecimiento.setBounds(10, 75, 363, 23);
		panel_4.add(e1TasaCrecimiento);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(457, 83, 383, 109);
		pE1.add(panel_5);
		
		e1Usuario = new JLabel("Usuario:");
		e1Usuario.setBounds(10, 11, 363, 23);
		panel_5.add(e1Usuario);
		
		e1Seguidores = new JLabel("Seguidores:");
		e1Seguidores.setBounds(10, 45, 363, 23);
		panel_5.add(e1Seguidores);
		
		e1FechaCreacion = new JLabel("Fecha de creacion:");
		e1FechaCreacion.setBounds(10, 75, 363, 23);
		panel_5.add(e1FechaCreacion);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(457, 305, 383, 72);
		pE1.add(panel_6);
		
		e1Interacciones = new JLabel("Interacciones:");
		e1Interacciones.setBounds(10, 11, 363, 23);
		panel_6.add(e1Interacciones);
		
		e1SeguidoresNuevos = new JLabel("Nuevos seguidores:");
		e1SeguidoresNuevos.setBounds(10, 38, 363, 23);
		panel_6.add(e1SeguidoresNuevos);
		
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 213, 383, 38);
		pE1.add(panel_7);
		
		lblNewLabel = new JLabel("Estadisticas Generales");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 363, 38);
		panel_7.add(lblNewLabel);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(457, 213, 383, 38);
		pE1.add(panel_8);
		
		lblNewLabel_1 = new JLabel("Historico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 363, 16);
		panel_8.add(lblNewLabel_1);
		
		e1Historico = new JComboBox<String>();
		e1Historico.setBounds(565, 259, 173, 38);
		pE1.add(e1Historico);
		
		pE5E11 = new JPanel();
		pE5E11.setBounds(0, 30, 880, 660);
		contentPane.add(pE5E11);
		pE5E11.setLayout(null);
		pE5E11.setVisible(false);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 408, 704, 241);
		pE5E11.add(scrollPane_3);
		
		e5Tabla = new JTable();
		scrollPane_3.setViewportView(e5Tabla);
		
		panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_19.setBackground(new Color(255, 255, 255));
		panel_19.setBounds(10, 11, 533, 386);
		pE5E11.add(panel_19);
		panel_19.setLayout(null);
		
		e5Creadores = new JComboBox<String>();
		e5Creadores.setBounds(10, 11, 170, 50);
		panel_19.add(e5Creadores);
		
		e5Plataforma = new JComboBox<String>();
		e5Plataforma.setBounds(353, 11, 170, 50);
		panel_19.add(e5Plataforma);
		
		e5Contenido = new JComboBox<String>();
		e5Contenido.setBounds(181, 78, 170, 50);
		panel_19.add(e5Contenido);
		
		lblNewLabel_2 = new JLabel("Contenido");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(190, 47, 153, 20);
		panel_19.add(lblNewLabel_2);
		
		e5Tipo = new JLabel("Tipo:");
		e5Tipo.setHorizontalAlignment(SwingConstants.CENTER);
		e5Tipo.setBounds(10, 108, 170, 20);
		panel_19.add(e5Tipo);
		
		e5Fecha = new JLabel("Fecha:");
		e5Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		e5Fecha.setBounds(353, 88, 170, 40);
		panel_19.add(e5Fecha);
		
		e5TipoRellenar = new JTextField();
		e5TipoRellenar.setColumns(10);
		e5TipoRellenar.setBounds(10, 139, 170, 31);
		panel_19.add(e5TipoRellenar);
		
		e5FechaRellenar = new JFormattedTextField(formatoFecha);
		e5FechaRellenar.setColumns(10);
		e5FechaRellenar.setBounds(353, 139, 170, 31);
		panel_19.add(e5FechaRellenar);
		
		e5MeGustaRellenar = new JTextField();
		e5MeGustaRellenar.setColumns(10);
		e5MeGustaRellenar.setBounds(10, 228, 170, 31);
		panel_19.add(e5MeGustaRellenar);
		
		e5CompartidosRellenar = new JTextField();
		e5CompartidosRellenar.setColumns(10);
		e5CompartidosRellenar.setBounds(10, 321, 170, 31);
		panel_19.add(e5CompartidosRellenar);
		
		e5VistasRellenar = new JTextField();
		e5VistasRellenar.setColumns(10);
		e5VistasRellenar.setBounds(353, 233, 170, 31);
		panel_19.add(e5VistasRellenar);
		
		e5ComentariosRellenar = new JTextField();
		e5ComentariosRellenar.setColumns(10);
		e5ComentariosRellenar.setBounds(353, 321, 170, 31);
		panel_19.add(e5ComentariosRellenar);
		
		e5MeGusta = new JLabel("Me gustas:");
		e5MeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		e5MeGusta.setBounds(10, 197, 170, 20);
		panel_19.add(e5MeGusta);
		
		e5Vistas = new JLabel("Vistas:");
		e5Vistas.setHorizontalAlignment(SwingConstants.CENTER);
		e5Vistas.setBounds(353, 202, 170, 20);
		panel_19.add(e5Vistas);
		
		e5Compartidos = new JLabel("Compratidos:");
		e5Compartidos.setHorizontalAlignment(SwingConstants.CENTER);
		e5Compartidos.setBounds(10, 290, 170, 20);
		panel_19.add(e5Compartidos);
		
		e5Comentarios = new JLabel("Comentarios");
		e5Comentarios.setHorizontalAlignment(SwingConstants.CENTER);
		e5Comentarios.setBounds(353, 290, 170, 20);
		panel_19.add(e5Comentarios);
		
		panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_21.setBackground(new Color(255, 255, 255));
		panel_21.setBounds(724, 408, 146, 241);
		pE5E11.add(panel_21);
		panel_21.setLayout(null);
		
		btnE5MostrarTodas = new JButton("Mostrar todas");
		btnE5MostrarTodas.setBounds(10, 11, 126, 43);
		panel_21.add(btnE5MostrarTodas);
		
		btnE5FiltroCreador = new JButton("FIltrar creador");
		btnE5FiltroCreador.setBounds(10, 65, 126, 43);
		panel_21.add(btnE5FiltroCreador);
		
		btnE5FiltroPlataforma = new JButton("Filtrar plataforma");
		btnE5FiltroPlataforma.setBounds(10, 119, 126, 43);
		panel_21.add(btnE5FiltroPlataforma);
		
		btnE5MostrarMetrica = new JButton("Mostrar metrica");
		btnE5MostrarMetrica.setBounds(10, 173, 126, 43);
		panel_21.add(btnE5MostrarMetrica);
		
		panel_22 = new JPanel();
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_22.setBackground(new Color(255, 255, 255));
		panel_22.setBounds(551, 102, 319, 295);
		pE5E11.add(panel_22);
		panel_22.setLayout(null);
		
		e5Parametro = new JComboBox<String>();
		e5Parametro.setBounds(96, 56, 130, 41);
		panel_22.add(e5Parametro);
		
		lblNewLabel_4 = new JLabel("Eliminar publicaciones por:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 11, 299, 34);
		panel_22.add(lblNewLabel_4);
		
		e5Cantidad = new JTextField();
		e5Cantidad.setText("0");
		e5Cantidad.setBounds(251, 108, 58, 20);
		panel_22.add(e5Cantidad);
		e5Cantidad.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Minimo de interaciones para no ser eliminado:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 108, 241, 20);
		panel_22.add(lblNewLabel_5);
		
		btnE5EliminarTodas = new JButton("Eliminar Publicaciones");
		btnE5EliminarTodas.setBounds(10, 139, 299, 34);
		panel_22.add(btnE5EliminarTodas);
		
		btnE5EliminarActual = new JButton("Eliminar publicacion actual");
		btnE5EliminarActual.setBounds(10, 205, 299, 34);
		panel_22.add(btnE5EliminarActual);
		
		panel_23 = new JPanel();
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_23.setBackground(new Color(255, 255, 255));
		panel_23.setBounds(553, 11, 317, 80);
		pE5E11.add(panel_23);
		panel_23.setLayout(null);
		
		btnE5CrearPublicacion = new JButton("Crear publicacion");
		btnE5CrearPublicacion.setBounds(10, 11, 297, 23);
		panel_23.add(btnE5CrearPublicacion);
		
		btnE5EditarPublicacion = new JButton("Editar publicacion");
		btnE5EditarPublicacion.setBounds(10, 45, 297, 23);
		panel_23.add(btnE5EditarPublicacion);
		contentPane.add(pE2E7);
		
		e2Creadores = new JComboBox<String>();
		e2Creadores.setBounds(80, 11, 170, 50);
		pE2E7.add(e2Creadores);
		
		e2RedSocial = new JComboBox<String>();
		e2RedSocial.setBounds(480, 11, 170, 50);
		pE2E7.add(e2RedSocial);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(454, 94, 383, 56);
		pE2E7.add(panel);
		panel.setLayout(null);
		
		e2PromedioMeGusta = new JLabel("Promedio me gusta:");
		e2PromedioMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta.setBounds(0, 0, 383, 56);
		e2PromedioMeGusta.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(e2PromedioMeGusta);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(29, 94, 383, 123);
		pE2E7.add(panel_1);
		
		e2ContenidoCreador = new JLabel("Contenido que mejor le funciona:");
		e2ContenidoCreador.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2ContenidoCreador.setHorizontalAlignment(SwingConstants.CENTER);
		e2ContenidoCreador.setAlignmentX(0.5f);
		e2ContenidoCreador.setBounds(10, 0, 363, 56);
		panel_1.add(e2ContenidoCreador);
		
		e2MejorContenidoCreador = new JLabel("New label");
		e2MejorContenidoCreador.setVerticalAlignment(SwingConstants.TOP);
		e2MejorContenidoCreador.setHorizontalAlignment(SwingConstants.CENTER);
		e2MejorContenidoCreador.setAlignmentX(0.5f);
		e2MejorContenidoCreador.setBounds(10, 67, 363, 56);
		panel_1.add(e2MejorContenidoCreador);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(454, 161, 383, 56);
		pE2E7.add(panel_2);
		
		e2PromedioVistas = new JLabel("Promedio vistas:");
		e2PromedioVistas.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioVistas.setAlignmentX(0.5f);
		e2PromedioVistas.setBounds(0, 0, 383, 56);
		panel_2.add(e2PromedioVistas);
		
		panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(454, 228, 383, 56);
		pE2E7.add(panel_12);
		
		e2TasaCrecimiento = new JLabel("Tasa de crecimiento 1º trimestre:");
		e2TasaCrecimiento.setHorizontalAlignment(SwingConstants.CENTER);
		e2TasaCrecimiento.setAlignmentX(0.5f);
		e2TasaCrecimiento.setBounds(0, 0, 383, 56);
		panel_12.add(e2TasaCrecimiento);
		
		panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(29, 228, 383, 276);
		pE2E7.add(panel_13);
		
		e2ContenidoPlataforma = new JLabel("Contenido que mejor funciona en la plataforma:");
		e2ContenidoPlataforma.setVerticalAlignment(SwingConstants.BOTTOM);
		e2ContenidoPlataforma.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2ContenidoPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		e2ContenidoPlataforma.setAlignmentX(0.5f);
		e2ContenidoPlataforma.setBounds(10, 0, 363, 56);
		panel_13.add(e2ContenidoPlataforma);
		
		e2MejorContenidoPlataforma = new JLabel("New label");
		e2MejorContenidoPlataforma.setFont(new Font("Tahoma", Font.BOLD, 13));
		e2MejorContenidoPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		e2MejorContenidoPlataforma.setAlignmentX(0.5f);
		e2MejorContenidoPlataforma.setBounds(10, 67, 363, 37);
		panel_13.add(e2MejorContenidoPlataforma);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 115, 363, 146);
		panel_13.add(scrollPane_2);
		
		e9Tabla = new JTable();
		scrollPane_2.setViewportView(e9Tabla);
		
		e2Logo = new JLabel("");
		e2Logo.setIcon(new ImageIcon("recursosImg\\Instagram.png"));
		e2Logo.setHorizontalAlignment(SwingConstants.CENTER);
		e2Logo.setBounds(474, 308, 341, 341);
		pE2E7.add(e2Logo);
		
		pE3 = new JPanel();
		pE3.setBounds(0, 30, 880, 660);
		contentPane.add(pE3);
		pE3.setLayout(null);
		pE3.setVisible(false);
		
		e3Creador2 = new JComboBox<String>();
		e3Creador2.setBounds(472, 80, 220, 40);
		pE3.add(e3Creador2);
		
		panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(30, 134, 250, 123);
		pE3.add(panel_14);
		
		e2PromedioMeGusta_2 = new JLabel("*Tematica");
		e2PromedioMeGusta_2.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2PromedioMeGusta_2.setAlignmentX(0.5f);
		e2PromedioMeGusta_2.setBounds(10, 11, 230, 40);
		panel_14.add(e2PromedioMeGusta_2);
		
		e3Tematica = new JTextField();
		e3Tematica.setBounds(10, 62, 230, 40);
		panel_14.add(e3Tematica);
		e3Tematica.setColumns(10);
		
		panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(315, 134, 250, 123);
		pE3.add(panel_15);
		
		e2PromedioMeGusta_5 = new JLabel("*Tipo");
		e2PromedioMeGusta_5.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2PromedioMeGusta_5.setAlignmentX(0.5f);
		e2PromedioMeGusta_5.setBounds(10, 0, 230, 45);
		panel_15.add(e2PromedioMeGusta_5);
		
		e3Tipo = new JTextField();
		e3Tipo.setColumns(10);
		e3Tipo.setBounds(10, 56, 230, 45);
		panel_15.add(e3Tipo);
		
		panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(30, 268, 250, 123);
		pE3.add(panel_16);
		
		e2PromedioMeGusta_7 = new JLabel("*Fecha inicio(aaaa-MM-dd)");
		e2PromedioMeGusta_7.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2PromedioMeGusta_7.setAlignmentX(0.5f);
		e2PromedioMeGusta_7.setBounds(10, 0, 230, 45);
		panel_16.add(e2PromedioMeGusta_7);
		
		e3FechaInicio = new JFormattedTextField(formatoFecha);
		e3FechaInicio.setColumns(10);
		e3FechaInicio.setBounds(10, 56, 230, 45);
		panel_16.add(e3FechaInicio);
		
		panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(600, 268, 250, 123);
		pE3.add(panel_17);
		
		e2PromedioMeGusta_9 = new JLabel("*Fecha finalizacion(aaaa-MM-dd)");
		e2PromedioMeGusta_9.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2PromedioMeGusta_9.setAlignmentX(0.5f);
		e2PromedioMeGusta_9.setBounds(10, 0, 230, 45);
		panel_17.add(e2PromedioMeGusta_9);
		
		e3FechaFin = new JFormattedTextField(formatoFecha);
		e3FechaFin.setColumns(10);
		e3FechaFin.setBounds(10, 56, 230, 45);
		panel_17.add(e3FechaFin);
		
		panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_18.setBackground(Color.WHITE);
		panel_18.setBounds(600, 134, 250, 123);
		pE3.add(panel_18);
		
		e2PromedioMeGusta_11 = new JLabel("*Estado");
		e2PromedioMeGusta_11.setHorizontalAlignment(SwingConstants.CENTER);
		e2PromedioMeGusta_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		e2PromedioMeGusta_11.setAlignmentX(0.5f);
		e2PromedioMeGusta_11.setBounds(10, 0, 230, 45);
		panel_18.add(e2PromedioMeGusta_11);
		
		e3Activa = new JRadioButton("Activa");
		e3Activa.setBounds(72, 52, 109, 23);
		panel_18.add(e3Activa);
		
		e3Finalizada = new JRadioButton("Finalizada");
		e3Finalizada.setBounds(72, 78, 109, 23);
		panel_18.add(e3Finalizada);
		
		e3Creador1 = new JComboBox<String>();
		e3Creador1.setBounds(188, 80, 220, 40);
		pE3.add(e3Creador1);
		
		panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
		panel_20.setBounds(189, 32, 503, 27);
		pE3.add(panel_20);
		panel_20.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Creacion de colaboraciones");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 0, 483, 27);
		panel_20.add(lblNewLabel_3);
		
		btnE3CrearColaboracion = new JButton("Crear Colaboracion");
		btnE3CrearColaboracion.setBounds(325, 268, 220, 40);
		pE3.add(btnE3CrearColaboracion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 402, 820, 247);
		pE3.add(scrollPane_1);
		
		e3Tabla = new JTable();
		scrollPane_1.setViewportView(e3Tabla);
		
		e3Error = new JLabel("");
		e3Error.setForeground(new Color(255, 0, 0));
		e3Error.setHorizontalAlignment(SwingConstants.CENTER);
		e3Error.setBounds(315, 319, 250, 72);
		pE3.add(e3Error);
		
		pBarraNavegacion = new JPanel();
		pBarraNavegacion.setBounds(0, 0, 880, 30);
		contentPane.add(pBarraNavegacion);
		pBarraNavegacion.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 880, 30);
		pBarraNavegacion.add(menuBar);
		
		btnAnalisis = new JMenu("Analisis");
		menuBar.add(btnAnalisis);
		
		e1 = new JMenuItem("Vista general de creadores");
		btnAnalisis.add(e1);
		
		e2E7E9 = new JMenuItem("Estadisticas");
		btnAnalisis.add(e2E7E9);
		
		btnAnadirEliminar = new JMenu("Añadir/Eliminar");
		menuBar.add(btnAnadirEliminar);
		
		e3 = new JMenuItem("Crear Colaboracion");
		btnAnadirEliminar.add(e3);
		
		e5E11 = new JMenuItem("Controlar Publicaciones");
		btnAnadirEliminar.add(e5E11);
		
		btnExportar = new JMenu("");
		btnExportar.setIcon(new ImageIcon("recursosImg\\exportar.png"));
		menuBar.add(btnExportar);
		
		exportar = new JMenuItem("Ir a exportar");
		btnExportar.add(exportar);
		
		menuGuardar = new JMenu("");
		menuGuardar.setIcon(new ImageIcon("recursosImg\\guardar.png"));
		menuBar.add(menuGuardar);
		
		intemCreadores = new JMenuItem("Guardar Creadores");
		menuGuardar.add(intemCreadores);
		
		itemMetricas = new JMenuItem("Guardar metricas");
		menuGuardar.add(itemMetricas);
	}
}
