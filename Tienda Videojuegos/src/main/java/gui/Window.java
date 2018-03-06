package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import main.java.Main;
import main.java.tabla.Cliente;
import main.java.tabla.Venta;
import main.java.tabla.Videojuego;

public class Window extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	JTabbedPane pestañas = new JTabbedPane();
	
	JPanel pnVid = new JPanel();
	JPanel pnCli = new JPanel();
	JPanel pnVent = new JPanel();
	protected JButton btnNuevo = new JButton("");
	protected JButton btnBorrar = new JButton("");
	protected JButton btnVer = new JButton("");
	protected JButton btnModi = new JButton("");
	protected Object tabla;
	
	
	
//	TableModel dataModel = new AbstractTableModel() {
//        public int getColumnCount() { return 10; }
//        public int getRowCount() { return 10;}        public Object getValueAt(int row, int col) { return new Integer(row*col); }
//    };
//    JTable table = new JTable(dataModel);
//    JScrollPane scrollpane = new JScrollPane(table);
	
	
	static ArrayList<Videojuego> arrIdVideojuego = new ArrayList<Videojuego>();
	static ArrayList<Cliente> arrIdCliente = new ArrayList<Cliente>();
	static ArrayList<Venta> arrIdVenta = new ArrayList<Venta>();
	
	public static JTable tablaVideojuego = new JTable();
	static JScrollPane scrollVideojuego = new JScrollPane(tablaVideojuego);

	public static JTable tablaCliente = new JTable();
	JScrollPane scrollCliente = new JScrollPane(tablaCliente);

	public static JTable tablaVenta = new JTable();
	JScrollPane scrollVenta = new JScrollPane(tablaVenta);
	
	public Window() {
		setLayout(null);
		setTitle("Menú");
		
		
		//add(scroll);
		//pack();
		pestañas.setBounds(60, 0, 500, 500);
		pestañas.addTab("Videojuegos", pnVid);
		pestañas.addTab("Clientes", pnCli);
		pestañas.addTab("Ventas", pnVent);
		add(pestañas);
		
		//Para no editarlo con doble clic
		tablaVideojuego.setDefaultEditor(Object.class, null);
		tablaCliente.setDefaultEditor(Object.class, null);
		tablaVenta.setDefaultEditor(Object.class, null);
		
		tablaVideojuego.getTableHeader().setReorderingAllowed(false);
		tablaCliente.getTableHeader().setReorderingAllowed(false);
		tablaVenta.getTableHeader().setReorderingAllowed(false);
		
		tablaVideojuego.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tablaVideojuego.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Título", "Género", "Cantidad en Stock" }));
		tablaCliente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "DNI", "Saldo" }));
		tablaVenta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IdVideojuegoFK", "fechaAdquirido", "Licencia" }));
		
		btnNuevo.setBounds(5, 20, 50, 50);
		//icono al botón
		ImageIcon img = new ImageIcon("nuevo.png");
		btnNuevo.setIcon(img);
		
		btnBorrar.setBounds(5, 80, 50, 50);
		ImageIcon img2 = new ImageIcon("borrar.png");
		btnBorrar.setIcon(img2);
		
		btnVer.setBounds(5, 140, 50, 50);
		ImageIcon img3 = new ImageIcon("ver.png");
		btnVer.setIcon(img3);
		
		btnModi.setBounds(5, 200, 50, 50);
		ImageIcon img4 = new ImageIcon("modi.png");
		btnModi.setIcon(img4);
		
		
		pnVid.setLayout(null);
		pnCli.setLayout(null);
		pnVent.setLayout(null);
		
		tablaVideojuego.setBounds(3, 15, 300, 200);
		tablaCliente.setBounds(3, 15, 300, 200);
		tablaVenta.setBounds(3, 15, 300, 200);
	//	pnVid.setBounds(5, 10, 20, 20);
//		scrollVideojuego.setPreferredSize(new Dimension(400, 100));
//		scrollCliente.setPreferredSize(new Dimension(400, 100));
//		scrollVenta.setPreferredSize(new Dimension(400, 100));
		
		add(btnNuevo);
		add(btnBorrar);
		add(btnVer);
		add(btnModi);

		
		pnVid.add(tablaVideojuego);
		pnCli.add(tablaCliente);
		pnVent.add(tablaVenta);
	
		
		btnNuevo.addActionListener(Evento.getEventoWindow());
		btnBorrar.addActionListener(Evento.getEventoWindow());
		btnVer.addActionListener(Evento.getEventoWindow());
		btnModi.addActionListener(Evento.getEventoWindow());
		
		pestañas.addMouseListener(Evento.getEventoWindowMouse());
		tablaVideojuego.addMouseListener(Evento.getEventoWindowMouse());
		tablaCliente.addMouseListener(Evento.getEventoWindowMouse());
		tablaVenta.addMouseListener(Evento.getEventoWindowMouse());
		
		
		
		setIconImage(new ImageIcon("Icon.png").getImage());
		//add(scroll, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 300);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		//setResizable(false);
		generarTablas();
	}

	public void generarTablas(){
		
		
		arrIdVideojuego.clear();
		arrIdCliente.clear();
		arrIdVenta.clear();
		
		//Tabla Videojuegos
		arrIdVideojuego = (ArrayList<Videojuego>) Main.videojuegoDao.buscarTodos();
		DefaultTableModel modVideojuego = (DefaultTableModel) Window.tablaVideojuego.getModel();
		int contador = Window.tablaVideojuego.getRowCount();
		for (int i = 0; contador > i; i++) {
			modVideojuego.removeRow(0);
		}
		for (Videojuego vid : arrIdVideojuego) {
			modVideojuego.addRow(new Object[] { vid.getTitulo(), vid.getGenero(), vid.getCantidadStock() });
		}
		
		// Tabla Cliente
				arrIdCliente = (ArrayList<Cliente>) Main.clienteDao.buscarTodos();
				DefaultTableModel modCliente = (DefaultTableModel) Window.tablaCliente.getModel();
				int contador2 = Window.tablaCliente.getRowCount();
				for (int i = 0; contador2 > i; i++)
					modCliente.removeRow(0);
				for (Cliente cli : arrIdCliente) {
					modCliente.addRow(new Object[] { cli.getNombre(), cli.getDni(), cli.getSaldo() });
				}
				// Tabla Venta
				arrIdVenta = (ArrayList<Venta>) Main.ventaDao.buscarTodos();
				DefaultTableModel modVenta = (DefaultTableModel) Window.tablaVenta.getModel();
				int contador3 = Window.tablaVenta.getRowCount();
				for (int i = 0; contador3 > i; i++)
					modVenta.removeRow(0);
				for (Venta vent : arrIdVenta) {
					Videojuego videojuegoFK = Main.videojuegoDao.buscarPorID(vent.getIdVideojuegoFK());
					Cliente clienteFK = Main.clienteDao.buscarPorID(vent.getIdClienteFK());
					modVenta.addRow(new Object[] { videojuegoFK.getTitulo(), clienteFK.getNombre(), vent.getLicencia() });
				}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}