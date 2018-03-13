package main.java.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.Main;
import main.java.tabla.Cliente;
import main.java.tabla.Videojuego;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> campos;
	protected ArrayList<JTextField> datos;
	protected JComboBox<String> titulos, nombres;
	protected JButton btnConfirmar, btnCancelar;
	protected String nombreClase;
	private int caso;

	public Registro(int tipoAccion, String[] campos, String[] datos, String nombreClase) {
		this.nombreClase = nombreClase;
		caso = tipoAccion;
		switch (tipoAccion) {
		case 1: {
			btnCancelar = new JButton("Aceptar");
			Container contenedor = añadirCampos(this, campos, datos, true);
			btnCancelar.setBounds(75, 165, 85, 25);
			contenedor.add(btnCancelar);
			btnCancelar.addActionListener(Evento.getEventoRegistro());
			setTitle("Consulta");
			break;
		}
		case 2: {
			Container contenedor = añadirCampos(this, campos, datos, false);
			btnConfirmar = new JButton("Guardar");
			btnConfirmar.setBounds(30, 165, 85, 25);
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(125, 165, 85, 25);
			contenedor.add(btnConfirmar);
			contenedor.add(btnCancelar);
			btnConfirmar.addActionListener(Evento.getEventoRegistro());
			btnCancelar.addActionListener(Evento.getEventoRegistro());
			setTitle("Nuevo");
			break;
		}
		case 3: {
			Container contenedor = añadirCampos(this, campos, datos, true);
			btnConfirmar = new JButton("Actualizar");
			btnConfirmar.setBounds(25, 165, 95, 25);
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(135, 165, 85, 25);
			contenedor.add(btnConfirmar);
			contenedor.add(btnCancelar);
			btnConfirmar.addActionListener(Evento.getEventoRegistro());
			btnCancelar.addActionListener(Evento.getEventoRegistro());
			setTitle("Modificar");
			break;
		}
		default: {
			System.out.println("¡Accion invalida!");
		}
		}
		setSize(250, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon("Icon.png").getImage());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		setVisible(true);
		try {

			// Carga el fichero de ayuda
			File fichero = new File("help/help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			// Ayuda al pulsar F1 sobre la ventana principal
			hb.enableHelpKey(getContentPane(), "aplicacion", helpset);

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	private Container añadirCampos(Container contenedor, String[] campos, String[] datos, boolean noEsNuevo) {
		Container contenedorDevuelto = contenedor;
		contenedorDevuelto.setLayout(null);
		GridLayout tabla = new GridLayout(0, 2);
		JPanel panelCampos = new JPanel(tabla);
		panelCampos.setBounds(25, 0, 175, 150);
		contenedorDevuelto.add(panelCampos);
		this.campos = new ArrayList<JLabel>();
		this.datos = new ArrayList<JTextField>();
		for (int x = 0; x < campos.length; x++) {
			JLabel etiqueta = new JLabel(campos[x]);
			etiqueta.setHorizontalAlignment(JLabel.RIGHT);
			this.campos.add(etiqueta);
			if(nombreClase.equals("Venta") && (x == 1 || x == 2)) {
				if (noEsNuevo) {
					if(x == 1) {
						titulos = listaTabla(x, datos[x]);
					} else {
						nombres = listaTabla(x, datos[x]);
					}
				} else {
					if(x == 1) {
						titulos = listaTabla(x, "");
					} else {
						nombres = listaTabla(x, "");
					}
				}
			} else {
				if (noEsNuevo) {
					this.datos.add(new JTextField(datos[x]));
				} else {
					if (x == 0) {
						this.datos.add(new JTextField("0"));
					} else {
						this.datos.add(new JTextField());
					}
				}
			}
		}
		for (int x = 1; x < this.campos.size(); x++) {
			tabla.setRows(tabla.getRows() + 1);
			if(nombreClase.equals("Venta") && (x == 1 || x == 2)) {
				if (caso == 1 && x == 1) {
					titulos.setEnabled(false);
				} else if (caso == 1 && x == 2) {
					nombres.setEnabled(false);
				}
				if(x == 1) {
					panelCampos.add(this.campos.get(x));
					panelCampos.add(titulos);
				} else {
					panelCampos.add(this.campos.get(x));
					panelCampos.add(nombres);
				}
			} else {
				if (caso == 1) {
					if(nombreClase.equals("Venta")) {
						this.datos.get(x-2).setEditable(false);
					} else {
						this.datos.get(x).setEditable(false);
					}	
				}
				panelCampos.add(this.campos.get(x));
				if(nombreClase.equals("Venta")) {
					panelCampos.add(this.datos.get(x-2));
				} else {
					panelCampos.add(this.datos.get(x));
				}	
			}
		}
		return contenedorDevuelto;
	}

	protected void cerrarVentana() {
		setVisible(false);
		dispose();
	}
	private JComboBox<String> listaTabla(int opcion, String seleccionado) {
		JComboBox<String> listaDesplegable = new JComboBox<String>();
		switch (opcion)
		{
			case 1: {
				List<Videojuego> registros = Main.videojuegoDao.buscarTodos();
				for (int x = 0; x < registros.size(); x++)
				{
					listaDesplegable.addItem(registros.get(x).getTitulo());
				}
				break;
			}			
			case 2: {
				List<Cliente> registros = Main.clienteDao.buscarTodos();
				for (int x = 0; x < registros.size(); x++)
				{
					listaDesplegable.addItem(registros.get(x).getNombre());
				}
				break;
			}
			default:{
				//Se ha indicado un caso incorrecto
			}
		}
		if (caso != 2) {
			listaDesplegable.setSelectedItem(seleccionado);
		}
		return listaDesplegable;
	}
}
