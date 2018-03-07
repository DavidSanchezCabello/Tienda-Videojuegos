package main.java.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.help.HelpBroker;
import javax.help.HelpSet;
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

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	JTabbedPane pesta�as = new JTabbedPane();

	JPanel pnVid = new JPanel();
	JPanel pnCli = new JPanel();
	JPanel pnVent = new JPanel();
	protected JButton btnNuevo = new JButton("");
	protected JButton btnBorrar = new JButton("");
	protected JButton btnVer = new JButton("");
	protected JButton btnModi = new JButton("");
	protected Object tabla;
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
		setTitle("Men�");
		
		pesta�as.setBounds(60, 0, 500, 250);
		pesta�as.addTab("Videojuego", pnVid);
		pesta�as.addTab("Cliente", pnCli);
		pesta�as.addTab("Venta", pnVent);
		add(pesta�as);

		// Para no editarlo con doble clic
		tablaVideojuego.setDefaultEditor(Object.class, null);
		tablaCliente.setDefaultEditor(Object.class, null);
		tablaVenta.setDefaultEditor(Object.class, null);

		tablaVideojuego.getTableHeader().setReorderingAllowed(false);
		tablaCliente.getTableHeader().setReorderingAllowed(false);
		tablaVenta.getTableHeader().setReorderingAllowed(false);

		tablaVideojuego.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tablaVideojuego.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"T�tulo", "G�nero", "Cantidad en Stock"}));
		tablaCliente.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"Nombre", "DNI", "Saldo"}));
		tablaVenta.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"Videojuego", "Cliente", "Licencia"}));

		btnNuevo.setBounds(5, 20, 50, 50);
		// icono al bot�n
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

		pnVid.setLayout(new BorderLayout());
		pnCli.setLayout(new BorderLayout());
		pnVent.setLayout(new BorderLayout());
		pnVid.add(tablaVideojuego.getTableHeader(), BorderLayout.PAGE_START);
		pnVid.add(scrollVideojuego, BorderLayout.CENTER);
		pnCli.add(tablaCliente.getTableHeader(), BorderLayout.PAGE_START);
		pnCli.add(scrollCliente, BorderLayout.CENTER);
		pnVent.add(tablaVenta.getTableHeader(), BorderLayout.PAGE_START);
		pnVent.add(scrollVenta, BorderLayout.CENTER);

		add(btnNuevo);
		add(btnBorrar);
		add(btnVer);
		add(btnModi);

		btnNuevo.addActionListener(Evento.getEventoWindow());
		btnBorrar.addActionListener(Evento.getEventoWindow());
		btnVer.addActionListener(Evento.getEventoWindow());
		btnModi.addActionListener(Evento.getEventoWindow());

		pesta�as.addMouseListener(Evento.getEventoWindowMouse());
		tablaVideojuego.addMouseListener(Evento.getEventoWindowMouse());
		tablaCliente.addMouseListener(Evento.getEventoWindowMouse());
		tablaVenta.addMouseListener(Evento.getEventoWindowMouse());

		setIconImage(new ImageIcon("Icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(580, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		generarTablas();
		
		try{
			// Carga el fichero de ayuda
			File fichero = new File("C:/Users/Luisao/git/Tienda-Videojuegos/help/help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			// Ayuda al pulsar F1 sobre la ventana principal 
			hb.enableHelpKey(getContentPane(), "ventana_principal", helpset);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void generarTablas() {

		arrIdVideojuego.clear();
		arrIdCliente.clear();
		arrIdVenta.clear();

		// Tabla Videojuegos
		arrIdVideojuego = (ArrayList<Videojuego>) Main.videojuegoDao
				.buscarTodos();
		DefaultTableModel modVideojuego = (DefaultTableModel) Window.tablaVideojuego
				.getModel();
		int contador = Window.tablaVideojuego.getRowCount();
		for (int i = 0; contador > i; i++) {
			modVideojuego.removeRow(0);
		}

		for (Videojuego vid : arrIdVideojuego) {
			modVideojuego.addRow(new Object[]{vid.getTitulo(), vid.getGenero(),
					vid.getCantidadStock()});
		}

		// Tabla Cliente
		arrIdCliente = (ArrayList<Cliente>) Main.clienteDao.buscarTodos();
		DefaultTableModel modCliente = (DefaultTableModel) Window.tablaCliente
				.getModel();
		int contador2 = Window.tablaCliente.getRowCount();
		for (int i = 0; contador2 > i; i++) {
			modCliente.removeRow(0);
		}
		for (Cliente cli : arrIdCliente) {
			modCliente.addRow(new Object[]{cli.getNombre(), cli.getDni(),
					cli.getSaldo()});
		}
		// Tabla Venta
		arrIdVenta = (ArrayList<Venta>) Main.ventaDao.buscarTodos();
		DefaultTableModel modVenta = (DefaultTableModel) Window.tablaVenta
				.getModel();
		int contador3 = Window.tablaVenta.getRowCount();
		for (int i = 0; contador3 > i; i++) {
			modVenta.removeRow(0);
		}
		for (Venta vent : arrIdVenta) {
			Videojuego videojuegoFK = Main.videojuegoDao
					.buscarPorID(vent.getIdVideojuegoFK());
			Cliente clienteFK = Main.clienteDao
					.buscarPorID(vent.getIdClienteFK());
			modVenta.addRow(new Object[]{videojuegoFK.getTitulo(),
					clienteFK.getNombre(), vent.getLicencia()});
		}
	}
}