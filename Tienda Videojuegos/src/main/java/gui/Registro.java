package main.java.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro extends JFrame{

	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> campos;
	protected ArrayList<JTextField> datos;
	protected JButton btnConfirmar, btnCancelar;
	protected String nombreClase;
	
	public Registro(int tipoAccion, String[] campos, String[] datos, String nombreClase) {
		this.nombreClase = nombreClase;
		switch (tipoAccion) {
			case 1: {
				Container contenedor = añadirCampos(campos, datos, true);
				btnCancelar = new JButton("Aceptar");
				btnCancelar.setBounds(75, 165, 85, 25);
				contenedor.add(btnCancelar);
				btnCancelar.addActionListener(Evento.getEventoRegistro());
				setContentPane(contenedor);
				setTitle("Consulta");
				break;
			}
			case 2: {
				Container contenedor = añadirCampos(campos, datos, false);
				btnConfirmar = new JButton("Guardar");
				btnConfirmar.setBounds(30, 165, 85, 25);
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(125, 165, 85, 25);
				contenedor.add(btnConfirmar);
				contenedor.add(btnCancelar);
				btnConfirmar.addActionListener(Evento.getEventoRegistro());
				btnCancelar.addActionListener(Evento.getEventoRegistro());
				setContentPane(contenedor);
				setTitle("Nuevo");
				break;
			}
			case 3: {
				Container contenedor = añadirCampos(campos, datos, true);
				btnConfirmar = new JButton("Actualizar");
				btnConfirmar.setBounds(25, 165, 95, 25);
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(135, 165, 85, 25);
				contenedor.add(btnConfirmar);
				contenedor.add(btnCancelar);
				btnConfirmar.addActionListener(Evento.getEventoRegistro());
				btnCancelar.addActionListener(Evento.getEventoRegistro());
				setContentPane(contenedor);
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
		addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
				cerrarVentana();
		    }
		});
		setVisible(true);
	}
	private Container añadirCampos( String[] campos, String[] datos, boolean noEsNuevo) {
		Container contenedor = new Container();
		contenedor.setLayout(null);
		GridLayout tabla = new GridLayout(0, 2);
		JPanel panelCampos = new JPanel(tabla);
		panelCampos.setBounds(25, 0, 175, 150);
		contenedor.add(panelCampos);
		this.campos = new ArrayList<JLabel>();
		this.datos = new ArrayList<JTextField>();
		for (int x = 0; x < campos.length; x++) {
			JLabel etiqueta = new JLabel(campos[x]);
			etiqueta.setHorizontalAlignment(JLabel.RIGHT);
			this.campos.add(etiqueta);
			if(noEsNuevo) {
				this.datos.add(new JTextField(datos[x]));
			}
			else {
				if(x == 0) {
					this.datos.add(new JTextField("0"));
				} else {
					this.datos.add(new JTextField());
				}
			}
		}
		for (int x = 0; x < this.campos.size(); x++) {
			tabla.setRows(tabla.getRows() + 1);
			if (x == 0 || (x <= 2 && nombreClase.equals("Venta"))) {
				this.datos.get(x).setEditable(false);
			}
			panelCampos.add(this.campos.get(x));
			panelCampos.add(this.datos.get(x));
		}
		return contenedor;
	}
	protected void cerrarVentana() {
		setVisible(false);
		dispose();
	}
}
