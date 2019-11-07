package custom;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import design.GradientPanel;
import objeto.Alumno;
import objetoImp.AtacanteBDLiteImp;

@SuppressWarnings("serial")
public class CustomDialogAlumno extends JDialog{

	private int nrow;
	private Alumno alumnoMod;
	private JPanel contentPane;
	private Alumno alumnoSelec;
	private AtacanteBDLiteImp atacanteLiteImp;
	private JButton btnmod, btncancel;
	private DefaultTableModel modeltabla;
	private JTextField jtdni,jtnombre, jtape1, jtape2;
	
	public void prepararGUI() {				
		contentPane= new GradientPanel(Mine.FAVCOLORORANGE,Mine.FAVCOLORBLACK);
		contentPane.setLayout(new GridLayout(5,5,15,15));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
				
		setSize(400, 300);		
		setUndecorated(true);		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void agregarElementos() {
		JLabel lbldni = Mine.lblForPanel("DNI");		
		JLabel lblnombre = Mine.lblForPanel("Nombre");
		JLabel lblape1 = Mine.lblForPanel("Apellido 1");
		JLabel lblape2 = Mine.lblForPanel("Apellido 2");
		
		jtdni = Mine.jtForPanel(300);	
		jtnombre = Mine.jtForPanel(300);	
		jtape1 = Mine.jtForPanel(300);	
		jtape2 = Mine.jtForPanel(300);	
					
		jtdni.setEditable(false);
		jtdni.setText(this.alumnoSelec.getDni());
		jtnombre.setText(this.alumnoSelec.getNombre());
		jtape1.setText(this.alumnoSelec.getApe1());
		jtape2.setText(this.alumnoSelec.getApe2());		
		
		btnmod= Mine.btnForPanel("Modificar");
		btncancel= Mine.btnForPanel("Cancelar");
		
		contentPane.add(lbldni);
		contentPane.add(jtdni);	
		contentPane.add(lblnombre);
		contentPane.add(jtnombre);
		contentPane.add(lblape1);
		contentPane.add(jtape1);
		contentPane.add(lblape2);
		contentPane.add(jtape2);
		contentPane.add(btnmod);
		contentPane.add(btncancel);		
	}	
	
	public void controlEvents() {
		btnmod.addActionListener(modificar());
		btncancel.addActionListener(cancelar());
	}
	
	public ActionListener modificar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jt1 = jtdni.getText();
				String jt2 = jtnombre.getText();
				String jt3 = jtape1.getText();
				String jt4 = jtape2.getText();
				alumnoMod = new Alumno(jt1, jt2, jt3, jt4);	
				
				//Actualizamos en la base de datos
				atacanteLiteImp.actualizarAlumno(alumnoMod);			
				
				//Actualizamos en la tabla
				modeltabla.setValueAt(alumnoMod.getDni(), nrow, 0);
				modeltabla.setValueAt(alumnoMod.getNombre(), nrow, 1);
				modeltabla.setValueAt(alumnoMod.getApe1(), nrow, 2);
				modeltabla.setValueAt(alumnoMod.getApe2(), nrow, 3);
				
				dispose();
			}
		};
		return esteMetodo;
	}
	
	public ActionListener cancelar() {
		ActionListener esteMetodo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		};
		return esteMetodo;
	}
		
	public CustomDialogAlumno(Alumno alumnoSelec, AtacanteBDLiteImp atacanteLiteImp, DefaultTableModel modeltabla, int nrow) {	
		this.alumnoSelec=alumnoSelec;
		this.atacanteLiteImp=atacanteLiteImp;
		this.modeltabla=modeltabla;
		this.nrow=nrow;
		prepararGUI();
		agregarElementos();		
		controlEvents();
	}	
}
