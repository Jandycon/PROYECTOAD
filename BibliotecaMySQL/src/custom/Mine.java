package custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import design.GradientPanel;

public class Mine {

	public static final Font HELVETICA20 = new Font("Helvetica", Font.BOLD, 20);	
	public static final Font HELVETICA15 = new Font("Helvetica", Font.BOLD, 15);	
	public static final String DIRIMG= System.getProperty("user.dir")+"/imagenes/";
	public static final String CURRENTDIR = System.getProperty("user.dir");
	public static final Color FAVCOLORROSE= new Color(255, 0, 105);
	public static final Color FAVCOLORORANGE= new Color(255, 160, 10);
	public static final Color FAVCOLORBLACK= new Color(25, 25, 25);
	public static final Color FAVCOLOR3= new Color(245, 240, 55);
	public static final Color FAVCOLOR4= new Color(105, 0, 255);
	public static final Color FAVCOLOR5= new Color(70, 255, 245);	
	public static final Color FAVCOLOR6= new Color(65, 255, 70);
	public static final Font FAVFONT = new CustomFont().Timeless(15);
	public static final Font FAVFONT18 = new CustomFont().Timeless(18);
	public static final Icon IMGLIBRO = new ImageIcon(Mine.DIRIMG+"libros.png");
	public static final Icon IMGMINUS = new ImageIcon(Mine.DIRIMG+"minus.png");
	public static final Icon IMGPLUS = new ImageIcon(Mine.DIRIMG+"plus.png");	
	public static final Icon IMGALUM = new ImageIcon(Mine.DIRIMG+"alumno.png");	
	public static final Border RAISEDBEVEL = BorderFactory.createRaisedBevelBorder();
	public static final Border LOWEREDBEVEL = BorderFactory.createLoweredBevelBorder();
	public static final Border COMPOUND = BorderFactory.createCompoundBorder(RAISEDBEVEL, LOWEREDBEVEL);
	public static final Border COMPOUNDF = BorderFactory.createCompoundBorder(RAISEDBEVEL, new EmptyBorder(10,10,10,10));
	public static final String [] ESTADOS = {"Estado","Nuevo", "Usado Nuevo", "Usado Seminuevo","Usado Estropeado","Restaurado"};
			
	public static JScrollPane scrollForPanel(JTable jtabla, int largo, int altura) {
		JScrollPane esteScroll = new JScrollPane(jtabla);
		esteScroll.setBorder(null);
		esteScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		esteScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		esteScroll.setPreferredSize(new Dimension(largo,altura));		
		return esteScroll;
	}
	
	public static JTable tablaForPanel(DefaultTableModel modeltabla) {
		JTable estaTabla = new JTable(modeltabla);
		estaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		estaTabla.setBorder(null);        
		estaTabla.setRowHeight(30);
		estaTabla.setIntercellSpacing(new Dimension(0, 0));
		estaTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		JTableHeader header = estaTabla.getTableHeader();
        header.setFont(Mine.FAVFONT);
        header.setBorder(null);
        header.setBackground(Mine.FAVCOLORBLACK);
        header.setForeground(Color.WHITE);
        
		return estaTabla;
	}
	
	public static Icon escalarIMG(Icon icontoresize, int newW, int newH) {		
		 Image img = ((ImageIcon) icontoresize).getImage() ;  
		 Image newimg = img.getScaledInstance(newW, newH, java.awt.Image.SCALE_SMOOTH);  
		 return new ImageIcon(newimg);
	}
	
	public static Border myTiltedBorder(String str, int numgap) {
		TitledBorder t = BorderFactory.createTitledBorder(str);
		t.setTitleColor(Color.WHITE);
		return  BorderFactory.createCompoundBorder(t, new EmptyBorder(numgap,numgap,numgap,numgap));
	}
	
	public static JButton myCustomButton(String str,String nombtn) {			
		JButton btn = new JButton(str);
		btn.setName(nombtn);
		btn.setContentAreaFilled(false);
		btn.setFont(new CustomFont().Timeless(22));
		btn.setForeground(Color.WHITE);
		btn.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		btn.setHorizontalAlignment(SwingConstants.CENTER);		
		return btn;
	}	
	
	public static JButton myCustomImgButton (String ruta, String nombtn) {
		
		String rutafile= System.getProperty("user.dir")+"/imagenes/"+ruta;
		Icon icon = new ImageIcon (rutafile);
		JButton btn = new JButton(icon);
		btn.setName(nombtn);
		btn.setContentAreaFilled(false);
		btn.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		btn.setHorizontalAlignment(SwingConstants.CENTER);		
		return btn;
	}
	
	public static JButton btnForPanel(String btnname) {
		JButton esteBtn = new JButton(btnname);
		esteBtn.setForeground(Color.WHITE);
		esteBtn.setFont(Mine.FAVFONT);
		esteBtn.setBackground(Color.WHITE);
		esteBtn.setOpaque(false);
		return esteBtn;
	}
	
	public static JLabel lblUser(String usuario) {
		JLabel esteLbl = new JLabel("Bienvenid@: "+usuario);
		esteLbl.setFont(HELVETICA20);
		esteLbl.setForeground(Color.WHITE);
		esteLbl.setBorder(new EmptyBorder(5,0,5,5));
		return esteLbl;
	}
		
	public static JLabel lblForPanel(String lblname) {
		JLabel esteLbl = new JLabel(lblname);	
		esteLbl.setForeground(Color.WHITE);
		esteLbl.setBorder(new EmptyBorder(5,0,5,5));
		return esteLbl;
	}
	
	public static JTextField jtForPanel(int numW) {
		JTextField esteJT = new JTextField();
		esteJT.setPreferredSize(new Dimension(numW,20));
		esteJT.setMaximumSize( esteJT.getPreferredSize() );
		esteJT.setAlignmentX( Component.LEFT_ALIGNMENT);
		esteJT.setFont(Mine.HELVETICA15);
		return esteJT;
	}	
	
	public static JPanel jpForPanel(String str, JTextField jt) {
		JPanel esteJP = new JPanel();
		esteJP.add(jt);
		esteJP.setOpaque(false);
		esteJP.setBorder(Mine.myTiltedBorder(str,5));
		return esteJP;
	}
	
	public static JPanel panelPrestamo(){		
		JPanel estePanel = new GradientPanel(Mine.FAVCOLORROSE, Mine.FAVCOLORBLACK);
		return estePanel;		
	}	
	
	public static JPanel panelDevolucion(){		
		JPanel estePanel = new GradientPanel(Mine.FAVCOLORROSE, Mine.FAVCOLORBLACK);
		return estePanel;		
	}		
}
