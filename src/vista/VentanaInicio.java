package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import modelo.Alumno;
import modelo.Alumno;
import controlador.AlumnoDAO;


public class VentanaInicio extends JFrame implements ActionListener {

	JMenu menuPrincipalAlumnos, menuPrincipalMaterias;
	JMenuBar menuBar;
	JMenuItem altaAlumno, bajaAlumno, cambioAlumno, consultaAlumno;
	
	JInternalFrame altas, bajas, cambios, consultas;
	JPanel panel1, panel2, panel3, b1, b2, b3, b4, m1, m2, m3, m4, c1, c2, c3;
	JTextField tnumControl, tNombre, tApellidoP, tApellidoM, tnumControlB, tNombreB, tApellidoPB, tApellidoMB, tnumControlM, tNombreM, tApellidoPM, tApellidoMM, tNombreC, tApellidoPC, tApellidoMC, tSemestreC, tCarreraC;
	JButton agregar, borrar, cancelar, eliminar, borrarB, cancelarB, buscarB, modificar, borrarM, cancelarM, buscarM, borrarC, cancelarC, consultar;
	JComboBox cBSemestre, cBCarrera, cBSemestreB, cBCarreraB, cBSemestreM, cBCarreraM;
	JTable tabla1, tabla2, tabla3, tabla4;
	JRadioButton rNombre, rPrimerAp, rSegundoAp, rCarrera, rSemestre, rTodos;
	DefaultTableModel modelo;
	
	Font letra1 = new Font("Times New Roman", Font.BOLD, 12);
	Font letra2 = new Font("Segoe Script", Font.BOLD, 25);
	Font letra3 = new Font("Aial", Font.PLAIN, 12);
	AlumnoDAO aDAO = new AlumnoDAO();
	
	public VentanaInicio() {
	
		getContentPane().setLayout(new BorderLayout());
		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		menuBar = new JMenuBar();
		menuPrincipalAlumnos = new JMenu("Alumnos");
		
			altaAlumno = new JMenuItem("Altas");
			altaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
			altaAlumno.addActionListener(this);
			menuPrincipalAlumnos.add(altaAlumno);
			
			bajaAlumno = new JMenuItem("Bajas");
			bajaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
			bajaAlumno.addActionListener(this);
			menuPrincipalAlumnos.add(bajaAlumno);
			
			cambioAlumno = new JMenuItem("Modificaciones");
			cambioAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
			cambioAlumno.addActionListener(this);
			menuPrincipalAlumnos.add(cambioAlumno);
			
			consultaAlumno = new JMenuItem("Consultas");
			consultaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
			consultaAlumno.addActionListener(this);
			menuPrincipalAlumnos.add(consultaAlumno);
			
		menuBar.add(menuPrincipalAlumnos);
		setJMenuBar(menuBar);
		
		// ================================================================================================================================
				
		JDesktopPane desktopPane = new JDesktopPane();
			
			altas = new JInternalFrame("Altas Alumnos", false, true, false);
			altas.getContentPane().setLayout(null);
			altas.setSize(700, 600);
			altas.setLocation(new Point());
			altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			altas.setVisible(false);
			Dimension desktopSize = getSize();
	        Dimension FrameSize = altas.getSize();
	        int x = (desktopSize.width - FrameSize.width)/2;
	        int y = (desktopSize.height- FrameSize.height)/2;
	        altas.setLocation(x, y-25);
	        	        		
			panel1 = new JPanel();
				panel1.setLayout(null);
				panel1.setBackground(new Color(58, 228, 53));
				panel1.setBounds(0, 0, 700, 70);
				
				JLabel label1 = new JLabel("ALTAS ALUMNO");
				agregarEtiqueta(label1, 20, 20, 500, 40, panel1, letra2, Color.WHITE);
			
			altas.add(panel1);
			
			panel2 = new JPanel();
				panel2.setLayout(null);
				panel2.setBounds(0, 70, 700, 300);
				
				JLabel numControl = new JLabel("N�MERO DE CONTROL: ");
				agregarEtiqueta(numControl, 50, 40, 300, 30, panel2, letra1, null);
								
				tnumControl = new JTextField();
				//tnumControl.addActionListener(this);
				agregarComponentes(tnumControl, 210, 42, 170, 25, panel2);
				
				JLabel nombre = new JLabel("NOMBRE: ");
				agregarEtiqueta(nombre, 50, 80, 300, 30, panel2, letra1, null);
								
				tNombre = new JTextField();
				//tNombre.addActionListener(this);
				agregarComponentes(tNombre, 130, 82, 250, 25, panel2);
				
				JLabel apellidoP = new JLabel("APELLIDO PATERNO: ");
				agregarEtiqueta(apellidoP, 50, 120, 300, 30, panel2, letra1, null);
				
				tApellidoP = new JTextField();
				//tApellidoP.addActionListener(this);
				agregarComponentes(tApellidoP, 200, 122, 180, 25, panel2);
				
				JLabel apellidoM = new JLabel("APELLIDO MATERNO: ");
				agregarEtiqueta(apellidoM, 50, 160, 300, 30, panel2, letra1, null);
				
				tApellidoM = new JTextField();
				//tApellidoM.addActionListener(this);
				agregarComponentes(tApellidoM, 200, 162, 180, 25, panel2);
				
				JLabel semestre = new JLabel("SEMESTRE: ");
				agregarEtiqueta(semestre, 50, 200, 300, 30, panel2, letra1, null);
				
				cBSemestre = new JComboBox();
				cBSemestre.addItem("    Elegir Semestre...");
				cBSemestre.addItem("    1");
				cBSemestre.addItem("    2");
				cBSemestre.addItem("    3");
				cBSemestre.addItem("    4");
				cBSemestre.addItem("    5");
				cBSemestre.addItem("    6");
				cBSemestre.addItem("    7");
				cBSemestre.addItem("    8");
				cBSemestre.addItem("    9");
				cBSemestre.addItem("    10");
				cBSemestre.setBounds(230, 202, 150, 25);
				//cBSemestre.addActionListener(this);
				panel2.add(cBSemestre);
				
				JLabel carrera = new JLabel("CARRERA: ");
				agregarEtiqueta(carrera, 50, 240, 300, 30, panel2, letra1, null);
				
				cBCarrera = new JComboBox();
				cBCarrera.addItem("    Elegir Carrera... ");
				cBCarrera.addItem("    L.A.");
				cBCarrera.addItem("    C.P.");
				cBCarrera.addItem("    I.I.A.");
				cBCarrera.addItem("    I.M.");
				cBCarrera.addItem("    I.S.C.");
				cBCarrera.setBounds(230, 242, 150, 25);
				panel2.add(cBCarrera);
				
				agregar = new JButton("Agregar");
				agregar.addActionListener(this);
				agregarComponentes(agregar, 470, 60, 100, 25, panel2);
				
				borrar = new JButton("Borrar");
				borrar.addActionListener(this);
				agregarComponentes(borrar, 470, 140, 100, 25, panel2);
								
				cancelar = new JButton("Cancelar");
				cancelar.addActionListener(this);
				agregarComponentes(cancelar, 470, 220, 100, 25, panel2);				
			altas.add(panel2);
			
			panel3 = new JPanel();
				panel3.setLayout(new BorderLayout());
				//panel3.setBackground(new Color(143, 54, 210));
				panel3.setBounds(20, 400, 650, 120);
				
				tabla1 = new JTable(6, 6);
				crearTabla(panel3, tabla1);			
			altas.add(panel3);
			
			desktopPane.add(altas);
			
			//-----------------------------------------------------------------------------------------
			
			bajas = new JInternalFrame("Bajas Alumnos", false, true, false);
			bajas.getContentPane().setLayout(null);
			bajas.setSize(700, 600);
			bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			bajas.setVisible(false);
			bajas.setLocation(x, y-25);
			
			b1 = new JPanel();
				b1.setLayout(null);
				b1.setBackground(new Color(249, 22, 22));
				b1.setBounds(0, 0, 700, 70);
				
				JLabel labelBajas1 = new JLabel("BAJAS ALUMNO");
				agregarEtiqueta(labelBajas1, 20, 20, 500, 40, b1, letra2, Color.WHITE);								
			bajas.add(b1);
			
			b4 = new JPanel();
				b4.setLayout(null);
				b4.setBounds(50, 80, 600, 70);
				b4.setBorder(new EtchedBorder());
								
				numControl = new JLabel("N�MERO DE CONTROL: ");
				agregarEtiqueta(numControl, 50, 25, 300, 30, b4, letra1, null);
				
				tnumControlB = new JTextField();
				agregarComponentes(tnumControlB, 210, 27, 170, 25, b4);
								
				buscarB = new JButton( "", iconos("./src/Search.png") );
				buscarB.addActionListener(this);
				agregarComponentes(buscarB, 420, 17, 40, 40, b4);
				
				borrarB = new JButton("Borrar");
				borrarB.addActionListener(this);
				agregarComponentes(borrarB, 490, 27, 100, 25, b4);
				
			bajas.add(b4);
				
			b2 = new JPanel();
				b2.setLayout(null);
				b2.setBounds(0, 150, 700, 220);
						
				nombre = new JLabel("NOMBRE: ");
				agregarEtiqueta(nombre, 50, 20, 300, 30, b2, letra1, null);
				
				tNombreB = new JTextField();
				agregarComponentes(tNombreB, 130, 22, 250, 25, b2);
								
				apellidoP = new JLabel("APELLIDO PATERNO: ");
				agregarEtiqueta(apellidoP, 50, 60, 300, 30, b2, letra1, null);
								
				tApellidoPB = new JTextField();
				agregarComponentes(tApellidoPB, 200, 62, 180, 25, b2);
				
				apellidoM = new JLabel("APELLIDO MATERNO: ");
				agregarEtiqueta(apellidoM, 50, 100, 300, 30, b2, letra1, null);
				
				tApellidoMB = new JTextField();
				agregarComponentes(tApellidoMB, 200, 102, 180, 25, b2);
				
				semestre = new JLabel("SEMESTRE: ");
				agregarEtiqueta(semestre, 50, 140, 300, 30, b2, letra1, null);
				
				cBSemestreB = new JComboBox();
				cBSemestreB.addItem("    Elegir Semestre...");
				cBSemestreB.addItem("    1");
				cBSemestreB.addItem("    2");
				cBSemestreB.addItem("    3");
				cBSemestreB.addItem("    4");
				cBSemestreB.addItem("    5");
				cBSemestreB.addItem("    6");
				cBSemestreB.addItem("    7");
				cBSemestreB.addItem("    8");
				cBSemestreB.addItem("    9");
				cBSemestreB.addItem("    10");
				agregarComponentes(cBSemestreB, 230, 142, 150, 25, b2);
				
				carrera = new JLabel("CARRERA: ");
				agregarEtiqueta(carrera, 50, 180, 300, 30, b2, letra1, null);
				
				cBCarreraB = new JComboBox();
				cBCarreraB.addItem("    Elegir Carrera... ");
				cBCarreraB.addItem("    L.A.");
				cBCarreraB.addItem("    C.P.");
				cBCarreraB.addItem("    I.I.A.");
				cBCarreraB.addItem("    I.M.");
				cBCarreraB.addItem("    I.S.C.");
				agregarComponentes(cBCarreraB, 230, 182, 150, 25, b2);
												
				eliminar = new JButton("Eliminar");
				eliminar.addActionListener(this);
				agregarComponentes(eliminar, 470, 60, 100, 25, b2);
				
				cancelarB = new JButton("Cancelar");
				cancelarB.addActionListener(this);
				agregarComponentes(cancelarB, 470, 140, 100, 25, b2);		
			bajas.add(b2);
			
			b3 = new JPanel();
				b3.setLayout(new BorderLayout());
				b3.setBounds(20, 400, 650, 120);
				
				tabla2 = new JTable(6,6);
				crearTabla(b3, tabla2);
			bajas.add(b3);
			desktopPane.add(bajas);
			
			//-----------------------------------------------------------------------------------------
			
			cambios = new JInternalFrame("Cambios Alumnos", false, true, false);
			cambios.getContentPane().setLayout(null);
			cambios.setSize(700, 600);
			cambios.setDefaultCloseOperation(HIDE_ON_CLOSE);
			cambios.setVisible(false);
			cambios.setLocation(x, y-25);
			
			m1 = new JPanel();
				m1.setLayout(null);
				m1.setBackground(new Color(255, 128, 0));
				m1.setBounds(0, 0, 700, 70);
				
				JLabel labelCambios1 = new JLabel("MODIFICACIONES ALUMNO");
				agregarEtiqueta(labelCambios1, 20, 20, 500, 40, m1, letra2, Color.WHITE);								
			cambios.add(m1);
			
			m4 = new JPanel();
				m4.setLayout(null);
				m4.setBounds(50, 80, 600, 70);
				m4.setBorder(new EtchedBorder());
				
				numControl = new JLabel("N�MERO DE CONTROL: ");
				agregarEtiqueta(numControl, 50, 25, 300, 30, m4, letra1, null);
				
				tnumControlM = new JTextField();
				agregarComponentes(tnumControlM, 210, 27, 170, 25, m4);
								
				buscarM = new JButton( "", iconos("./src/Search.png") );
				buscarM.addActionListener(this);
				agregarComponentes(buscarM, 420, 17, 40, 40, m4);
				
				borrarM = new JButton("Borrar");
				borrarM.addActionListener(this);
				agregarComponentes(borrarM, 490, 27, 100, 25, m4);
				
			cambios.add(m4);
				
			m2 = new JPanel();
				m2.setLayout(null);
				m2.setBounds(0, 150, 700, 220);
						
				nombre = new JLabel("NOMBRE: ");
				agregarEtiqueta(nombre, 50, 20, 300, 30, m2, letra1, null);
				
				tNombreM = new JTextField();
				agregarComponentes(tNombreM, 130, 22, 250, 25, m2);
								
				apellidoP = new JLabel("APELLIDO PATERNO: ");
				agregarEtiqueta(apellidoP, 50, 60, 300, 30, m2, letra1, null);
								
				tApellidoPM = new JTextField();
				agregarComponentes(tApellidoPM, 200, 62, 180, 25, m2);
				
				apellidoM = new JLabel("APELLIDO MATERNO: ");
				agregarEtiqueta(apellidoM, 50, 100, 300, 30, m2, letra1, null);
				
				tApellidoMM = new JTextField();
				agregarComponentes(tApellidoMM, 200, 102, 180, 25, m2);
				
				semestre = new JLabel("SEMESTRE: ");
				agregarEtiqueta(semestre, 50, 140, 300, 30, m2, letra1, null);
				
				cBSemestreM = new JComboBox();
				cBSemestreM.addItem("    Elegir Semestre...");
				cBSemestreM.addItem("    1");
				cBSemestreM.addItem("    2");
				cBSemestreM.addItem("    3");
				cBSemestreM.addItem("    4");
				cBSemestreM.addItem("    5");
				cBSemestreM.addItem("    6");
				cBSemestreM.addItem("    7");
				cBSemestreM.addItem("    8");
				cBSemestreM.addItem("    9");
				cBSemestreM.addItem("    10");
				agregarComponentes(cBSemestreM, 230, 142, 150, 25, m2);
				
				carrera = new JLabel("CARRERA: ");
				agregarEtiqueta(carrera, 50, 180, 300, 30, m2, letra1, null);
				
				cBCarreraM = new JComboBox();
				cBCarreraM.addItem("    Elegir Carrera... ");
				cBCarreraM.addItem("    L.A.");
				cBCarreraM.addItem("    C.P.");
				cBCarreraM.addItem("    I.I.A.");
				cBCarreraM.addItem("    I.M.");
				cBCarreraM.addItem("    I.S.C.");
				agregarComponentes(cBCarreraM, 230, 182, 150, 25, m2);
												
				modificar = new JButton("Modificar");
				modificar.addActionListener(this);
				agregarComponentes(modificar, 470, 60, 100, 25, m2);
				
				cancelarM = new JButton("Cancelar");
				cancelarM.addActionListener(this);
				agregarComponentes(cancelarM, 470, 140, 100, 25, m2);		
			cambios.add(m2);
			
			m3 = new JPanel();
				m3.setLayout(new BorderLayout());
				//panel3.setBackground(new Color(143, 54, 210));
				m3.setBounds(20, 400, 650, 120);
				
				tabla3 = new JTable(6,6);
				crearTabla(m3, tabla3);
			cambios.add(m3);
			desktopPane.add(cambios);
			
			consultas = new JInternalFrame("Consultas Alumnos", false, true, false);
			consultas.getContentPane().setLayout(null);
			consultas.setSize(700, 600);
			consultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			consultas.setVisible(false);
			consultas.setLocation(x, y-25);
			
			c1 = new JPanel();
				c1.setLayout(null);
				c1.setBackground(new Color(24, 71, 235));
				c1.setBounds(0, 0, 700, 70);
				
				JLabel labelConsultas1 = new JLabel("CONSULTAS ALUMNO");
				agregarEtiqueta(labelConsultas1, 20, 20, 500, 40, c1, letra2, Color.WHITE);								
			consultas.add(c1);
			
			c2 = new JPanel();
				c2.setLayout(null);
				c2.setBounds(10, 90, 670, 300);
				c2.setBorder(new TitledBorder(new EtchedBorder(), "Selecciona criterio de b�squeda: "));
				
				ButtonGroup bg = new ButtonGroup();
								
				rTodos = new JRadioButton("TODOS");
				rTodos.addActionListener(this);
				agregarRadioButton(rTodos, 20, 40, 70, 30, c2, letra3);
				
				rNombre = new JRadioButton("NOMBRE");
				rNombre.addActionListener(this);
				agregarRadioButton(rNombre, 120, 40, 120, 30, c2, letra3);
				
				rPrimerAp = new JRadioButton("APELLIDO PATERNO");
				rPrimerAp.addActionListener(this);
				agregarRadioButton(rPrimerAp, 120, 90, 150, 30, c2, letra3);
				
				rSegundoAp = new JRadioButton("APELLIDO MATERNO");
				rSegundoAp.addActionListener(this);
				agregarRadioButton(rSegundoAp, 120, 140, 150, 30, c2, letra3);
				
				rSemestre = new JRadioButton("SEMESTRE");
				rSemestre.addActionListener(this);
				agregarRadioButton(rSemestre, 120, 190, 120, 30, c2, letra3);
				
				rCarrera = new JRadioButton("CARRERA");
				rCarrera.addActionListener(this);
				agregarRadioButton(rCarrera, 120, 240, 120, 30, c2, letra3);
				
				bg.add(rTodos);
				bg.add(rNombre);
				bg.add(rPrimerAp);
				bg.add(rSegundoAp);
				bg.add(rSemestre);
				bg.add(rCarrera);
				
				tNombreC = new JTextField();
				tNombreC.setEnabled(false);
				agregarComponentes(tNombreC, 270, 40, 180, 30, c2);
				
				tApellidoPC = new JTextField();
				tApellidoPC.setEnabled(false);
				agregarComponentes(tApellidoPC, 270, 90, 180, 30, c2);
				
				tApellidoMC = new JTextField();
				tApellidoMC.setEnabled(false);
				agregarComponentes(tApellidoMC, 270, 140, 180, 30, c2);
				
				tSemestreC = new JTextField();
				tSemestreC.setEnabled(false);
				agregarComponentes(tSemestreC, 270, 190, 180, 30, c2);
				
				tCarreraC = new JTextField();
				tCarreraC.setEnabled(false);
				agregarComponentes(tCarreraC, 270, 240, 180, 30, c2);
				
				consultar = new JButton( "", iconos("./src/Search.png"));
				consultar.addActionListener(this);
				agregarComponentes(consultar, 500, 60, 100, 45, c2);
			
				borrarC = new JButton("Borrar");
				borrarC.addActionListener(this);
				agregarComponentes(borrarC, 500, 145, 100, 25, c2);
				
				cancelarC = new JButton("Cancelar");
				cancelarC.addActionListener(this);
				agregarComponentes(cancelarC, 500, 210, 100, 25, c2);
			consultas.add(c2);
			
			c3 = new JPanel();
				c3.setLayout(new BorderLayout());
				c3.setBounds(20, 400, 650, 120);
				
				tabla4 = new JTable(6,6);
				crearTabla(c3, tabla4);
				
			consultas.add(c3);
			
			desktopPane.add(consultas);	
		add(desktopPane, BorderLayout.CENTER);
		
	}
	
	public void agregarRadioButton(JRadioButton r, int x, int y, int width, int height, JPanel panel, Font letra ) {
		r.setFont(letra);
		agregarComponentes(r, x, y, width, height, panel);
	}
	
	public ImageIcon iconos(String ruta) {
		ImageIcon imag = new ImageIcon(ruta);
		ImageIcon img = new ImageIcon(imag.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		return img;
	}
	
	public void agregarComponentes(JComponent componente, int x, int y, int width, int height, JPanel panel) {
		componente.setBounds(x, y, width, height);
		panel.add(componente);	
	}
	
	public void agregarEtiqueta(JLabel componente, int x, int y, int width, int height, JPanel panel, Font letra, Color color) {
		agregarComponentes(componente, x, y, width, height, panel);
		componente.setFont(letra);
		componente.setForeground(color);
	}
	
	public void crearTabla(JPanel panel, JTable table) {
		
		modelo = (DefaultTableModel) table.getModel();
	
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        TableColumnModel columnModel = table.getColumnModel();

        for(int i=0; i<table.getColumnCount(); i++) {
        	columnModel.getColumn(i).setPreferredWidth(50);
        }
	    		        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
        for(int i=0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
       
        JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll, BorderLayout.CENTER);		
		
	}
	
	public void restablecerCompontes(JComponent...componentes){
		for(JComponent c : componentes){
			if(c instanceof JTextField)
				((JTextField) c).setText("");
			
			if(c instanceof JComboBox)
				((JComboBox) c).setSelectedIndex(0);
		}		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(altaAlumno)) {
		//	actualizarTablas(tabla1);
			altas.setVisible(true);
			actualizarTabla(tabla1);
		}
		if(e.getSource().equals(bajaAlumno)) {
			//actualizarTablas(tabla2);
			bajas.setVisible(true);
			actualizarTabla(tabla2);
		}
		if(e.getSource().equals(cambioAlumno)) {
		//	actualizarTablas(tabla3);
			cambios.setVisible(true);
			actualizarTabla(tabla3);
		}
		if(e.getSource().equals(consultaAlumno)) {
			actualizarTabla(tabla4);
			consultas.setVisible(true);
		} 
		if(e.getSource().equals(agregar)) {
			String semestre = cBSemestre.getSelectedItem().toString().replaceAll(" ", "");
			String carrera = cBCarrera.getSelectedItem().toString().replaceAll(" ", "");
			Alumno a1 = new Alumno(tnumControl.getText(), tNombre.getText(), tApellidoP.getText(), tApellidoM.getText(), (byte)15, (byte)Integer.parseInt(semestre), carrera);
			//System.out.println(aDAO.agregarAlumno(a1));
			if(aDAO.agregarAlumno(a1) == true) {
				//actualizarTablas(tabla1);
				JOptionPane.showMessageDialog(rootPane, "El registro se a�adi� correctamente", null, JOptionPane.INFORMATION_MESSAGE);
				restablecerCompontes(tnumControl, tNombre, tApellidoP, tApellidoM, cBSemestre, cBCarrera);
			} else {
				JOptionPane.showMessageDialog(rootPane, "El registro no pudo ser a�adido", "Error", JOptionPane.ERROR_MESSAGE);
				restablecerCompontes(tnumControl, tNombre, tApellidoP, tApellidoM, cBSemestre, cBCarrera);
			}
			actualizarTabla(tabla1);
		}
		if(e.getSource().equals(eliminar)) {
			String numControl = tnumControlB.getText();
			//System.out.println(aDAO.eliminarAlumnos(numControl));
			if(aDAO.eliminarAlumnos(numControl) == true) {
				//actualizarTablas(tabla2);
				JOptionPane.showMessageDialog(rootPane, "El registro se elimin� correctamente", null, JOptionPane.INFORMATION_MESSAGE);
				restablecerCompontes(tnumControlB, tNombreB, tApellidoPB, tApellidoMB, cBSemestreB, cBCarreraB);
			} else {
				JOptionPane.showMessageDialog(rootPane, "El registro no se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
				restablecerCompontes(tnumControlB, tNombreB, tApellidoPB, tApellidoMB, cBSemestreB, cBCarreraB);
			}	
			actualizarTabla(tabla2);
		}
		if(e.getSource().equals(modificar)) {
			String semestre = cBSemestreM.getSelectedItem().toString().replaceAll(" ", "");
			String carrera = cBCarreraM.getSelectedItem().toString().replaceAll(" ", "");
			Alumno a1 = new Alumno(tnumControlM.getText(), tNombreM.getText(), tApellidoPM.getText(), tApellidoMM.getText(), (byte)15, (byte)Integer.parseInt(semestre), carrera);
			//System.out.println(aDAO.modificarAlumno(a1));
			if(aDAO.modificarAlumno(a1) == true) {
				//actualizarTablas(tabla3);
				JOptionPane.showMessageDialog(rootPane, "El registro se modific� correctamente", null, JOptionPane.INFORMATION_MESSAGE);
				restablecerCompontes(tnumControlM, tNombreM, tApellidoPM, tApellidoMM, cBSemestreM, cBCarreraM);
			} else {
				JOptionPane.showMessageDialog(rootPane, "El registro no se pudo modificar", null, JOptionPane.ERROR_MESSAGE);
				restablecerCompontes(tnumControlM, tNombreM, tApellidoPM, tApellidoMM, cBSemestreM, cBCarreraM);
			}
			actualizarTabla(tabla3);
		}
	
		if(e.getSource().equals(consultar)) {
			if(rNombre.isSelected()) {
				String sql= "SELECT * FROM Alumnos WHERE Nombre='"+tNombreC.getText()+"'";
				actualizarTabla(tabla4,sql);
				tabla4.setVisible(true);}
		if(rPrimerAp.isSelected()) {
			String sql= "SELECT * FROM Alumnos WHERE PrimerAP='"+tApellidoPC.getText()+"'";
			actualizarTabla(tabla4,sql);
			tabla4.setVisible(true);
		}
		if(rSegundoAp.isSelected()) {
			String sql= "SELECT * FROM Alumnos WHERE SegundoAP='"+tApellidoMC.getText()+"'";
			actualizarTabla(tabla4,sql);
			tabla4.setVisible(true);}
		if(rSemestre.isSelected()) {
			String sql= "SELECT * FROM Alumnos WHERE Semeste="+tSemestreC.getText();
			actualizarTabla(tabla4,sql);
			tabla4.setVisible(true);}
		if(rCarrera.isSelected()) {
			String sql= "SELECT * FROM Alumnos WHERE Carrera='"+tCarreraC.getText()+"'";
			actualizarTabla(tabla4,sql);
			tabla4.setVisible(true);}
		if(rTodos.isSelected()) {
			String sql= "SELECT * FROM Alumnos;";
			actualizarTabla(tabla4,sql);
			tabla4.setVisible(true);
		}
		}
	
		if(rNombre.isSelected()) {
		tNombreC.setEnabled(true);
		tApellidoPC.setEnabled(false);
		tApellidoMC.setEnabled(false);
		tSemestreC.setEnabled(false);
		tCarreraC.setEnabled(false);}
	if(rPrimerAp.isSelected()) {
		tNombreC.setEnabled(false);
		tApellidoPC.setEnabled(true);
		tApellidoMC.setEnabled(false);
		tSemestreC.setEnabled(false);
		tCarreraC.setEnabled(false);
	}
	if(rSegundoAp.isSelected()) {
		tNombreC.setEnabled(false);
		tApellidoPC.setEnabled(false);
		tApellidoMC.setEnabled(true);
		tSemestreC.setEnabled(false);
		tCarreraC.setEnabled(false);}
	if(rSemestre.isSelected()) {
		tNombreC.setEnabled(false);
		tApellidoPC.setEnabled(false);
		tApellidoMC.setEnabled(false);
		tSemestreC.setEnabled(true);
		tCarreraC.setEnabled(false);}
	if(rCarrera.isSelected()) {
		
		tNombreC.setEnabled(false);
		tApellidoPC.setEnabled(false);
		tApellidoMC.setEnabled(false);
		tSemestreC.setEnabled(false);
		tCarreraC.setEnabled(true);}
		
		if(e.getSource().equals(borrar) ) {
			restablecerCompontes(tnumControl, tNombre, tApellidoP, tApellidoM, cBSemestre, cBCarrera);
		}
		if(e.getSource().equals(borrarB) ) {
			restablecerCompontes(tnumControlB, tNombreB, tApellidoPB, tApellidoMB, cBSemestreB, cBCarreraB);
		}	
		if(e.getSource().equals(borrarM) ) {
			restablecerCompontes(tnumControlM, tNombreM, tApellidoPM, tApellidoMM, cBSemestreM, cBCarreraM);
		}
		if(e.getSource().equals(borrarC) ) {
			restablecerCompontes(tNombreC, tApellidoPC, tApellidoMC, tSemestreC, tCarreraC);
		}
		if (e.getSource().equals(buscarB)) {
			buscarAlumno(tnumControlB, tNombreB, tApellidoPB, tApellidoMB, cBSemestreB, cBCarreraB);
			eliminar.setEnabled(true);
		}
	}
	

public void buscarAlumno(JTextField cajaNumControl,JTextField cajaNombres,JTextField cajaApPaterno, JTextField cajaApMaterno,JComboBox cBSemestreM2, JComboBox comboCarrera) {
		
		try{AlumnoDAO aDAO=new AlumnoDAO();
		Alumno alumno= aDAO.buscarAlumno(cajaNumControl.getText());
		byte semestre =alumno.getSemestre();
		String carrera = alumno.getCarrera().toString();
		if(alumno!=null) {
			cajaNombres.setText(alumno.getNombre());
			cajaApPaterno.setText(alumno.getPrimerAp());
			cajaApMaterno.setText(alumno.getSegundoAp());
			cBSemestreM2.setSelectedItem(semestre);
			comboCarrera.setSelectedItem(carrera);
			}else {
			JOptionPane.showMessageDialog(rootPane, "El registro no se encontr�", null, JOptionPane.INFORMATION_MESSAGE);
		}}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(rootPane, "El registro no se encontr�", null, JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public void actualizarTabla(JTable tabla) {
		String controlador="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
		String consulta ="SELECT * FROM Alumnos";
		ResultSetTableModel modeloDatos=null; 
		try {
			modeloDatos= new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	tabla.setModel(modeloDatos);
	 
	}
	
	 public void actualizarTabla(JTable tabla,String consulta) {
	    	String controlador="com.mysql.cj.jdbc.Driver";
	    	String url="jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
	    	ResultSetTableModel modeloDatos=null;
			 try {
				modeloDatos= new ResultSetTableModel(controlador, url, consulta);
			 } catch (ClassNotFoundException e) {
				  e.printStackTrace();
			    } catch (SQLException e) {
			    	e.printStackTrace();
			     }
			 tabla.setModel(modeloDatos);
			 if (modeloDatos.getRowCount()==0) {
				 actualizarTabla(tabla4);
			 }else {
			 }
			 
		  }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicio();
			}
		});
		AlumnoDAO a = new AlumnoDAO();
		//System.out.println(a.buscarAlumnos("S17070162"));
		a.eliminarAlumnos("S17070171");
	}


}
