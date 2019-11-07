package proyecto;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import custom.CustomPanelAlumno;
import custom.CustomPanelDevol;
import custom.CustomPanelLibro;
import custom.CustomPanelPrestamo;
import custom.Mine;
import design.GradientPanel;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private String usuario;
	private String pass;
	private CardLayout cardlayout;	
	private JSplitPane contentPane;
	private CustomPanelLibro myCustomPL;
	private CustomPanelAlumno myCustomPA;
	private CustomPanelPrestamo myCustomPP;
	private CustomPanelDevol myCustomPD;
	private JPanel jpmenu, jpcontenido, jpalum, jplibro, jppres, jpdevol;
	private JButton indexlibro, indexalum, indexpres, indexdevol, indexsalir;

	//PREPARA LA INTERFAZ	 	
	public void prepararGUI() {		
				
		contentPane = new JSplitPane();		
		contentPane.setDividerLocation(700);
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		((BasicSplitPaneUI)contentPane.getUI()).getDivider().setBorder(null);		
				
		setTitle("Biblioteca");
		setSize(1000, 800);		
		setUndecorated(true);
		setBackground(Color.BLACK);
		setContentPane(contentPane);
		setBackground(Color.WHITE);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
	}		
	
	//AGREGA LOS ELEMENTOS A LA INTERFAZ
	public void agregarElementos() {
		
		myCustomPL = new CustomPanelLibro(this.usuario, this.pass);
		myCustomPA = new CustomPanelAlumno(this.usuario, this.pass);
		myCustomPP = new CustomPanelPrestamo(this.usuario, this.pass);
		myCustomPD = new CustomPanelDevol(this.usuario, this.pass);
		
		//Panel MENU(LEFT)	
		jpmenu = new GradientPanel(Mine.FAVCOLORROSE, Mine.FAVCOLORBLACK);
		jpmenu.setLayout(new GridLayout(5,1));
		jpmenu.setBackground(new Color(255, 8, 98));
		
		indexlibro=Mine.myCustomButton("Gestión de Libros","indexlibro");		
		indexalum=Mine.myCustomButton("Gestión de Alumnos","indexalum");		
		indexpres=Mine.myCustomButton("Gestión de Prestamos","indexpres");		
		indexdevol=Mine.myCustomButton("Gestión de Devoluciones","indexdevol");		
		indexsalir=Mine.myCustomImgButton("exit2.png","indexsalir");
				
		jpmenu.add(indexlibro);
		jpmenu.add(indexalum);
		jpmenu.add(indexpres);
		jpmenu.add(indexdevol);
		jpmenu.add(indexsalir);
		
		//PANEL CONTENIDO(RIGHT)
		cardlayout = new CardLayout();
		jpcontenido = new JPanel(cardlayout);
		cardlayout = (CardLayout) jpcontenido.getLayout();
				
		jplibro = myCustomPL.getPanel();	
		jpalum = myCustomPA.getPanel();
		jppres = myCustomPP.getPanel();
		jpdevol = myCustomPD.getPanel();
				
		jpcontenido.add("jplibro",jplibro);
		jpcontenido.add("jpalum",jpalum);
		jpcontenido.add("jppres",jppres);
		jpcontenido.add("jpdevol",jpdevol);
				
		//PANEL PRINCIPAL		
		contentPane.setLeftComponent(jpcontenido);
		contentPane.setRightComponent(jpmenu);		
	}
	
	public void controlEventos() {		
		indexsalir.addActionListener(controlCards());
		indexalum.addActionListener(controlCards());
		indexlibro.addActionListener(controlCards());
		indexpres.addActionListener(controlCards());
		indexdevol.addActionListener(controlCards());
	}
	
	public ActionListener controlCards() {
		ActionListener esteMetodo = new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String nombtn = btn.getName();	
				switch (nombtn) {
				case "indexlibro":
					cardlayout.show(jpcontenido, "jplibro");
					myCustomPL.setTableLibroFromBD();
					contentPane.setDividerLocation(700);					
					setSize(1000,800);
					break;
				case "indexalum":
					cardlayout.show(jpcontenido, "jpalum");
					contentPane.setDividerLocation(700);
					setSize(1000,800);
					break;
				case "indexpres":
					cardlayout.show(jpcontenido, "jppres");
					myCustomPP.setTablesPreFromBD();
					contentPane.setDividerLocation(900);
					setSize(1200,800);
					break;
				case "indexdevol":
					cardlayout.show(jpcontenido, "jpdevol");
					contentPane.setDividerLocation(700);
					myCustomPD.setTableDevFromBD();
					setSize(1000,800);
					break;
				case "indexsalir":
					dispose();
					break;
				}	
			}
		};
		return esteMetodo;
	}
	
	/**
	 * CONSTRUCTOR
	 */
	public Principal(String user, String pass) {
		this.usuario=user;
		this.pass=pass;
		prepararGUI();
		agregarElementos();		
		controlEventos();		
	}
}
