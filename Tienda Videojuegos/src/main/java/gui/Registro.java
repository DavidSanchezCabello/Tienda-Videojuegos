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
	private ArrayList<JTextField> datos;
	protected JButton confirmar, cancelar;
	protected String nombreClase;
	
	public Registro(int tipoAccion, String[] campos, String[] datos, String nombreClase) {
		this.nombreClase = nombreClase;
		switch (tipoAccion) {
			case 1: {
				Container contenedor = añadirCampos(campos, datos, true);
				confirmar = new JButton("Aceptar");
				confirmar.setBounds(75, 165, 85, 25);
				contenedor.add(confirmar);
				confirmar.addActionListener(Evento.getEventoRegistro());
				setContentPane(contenedor);
				setTitle("Consulta");
				break;
			}
			case 2: {
				Container contenedor = añadirCampos(campos, datos, false);
				confirmar = new JButton("Guardar");
				confirmar.setBounds(30, 165, 85, 25);
				cancelar = new JButton("Cancelar");
				cancelar.setBounds(125, 165, 85, 25);
				contenedor.add(confirmar);
				contenedor.add(cancelar);
				confirmar.addActionListener(Evento.getEventoRegistro());
				setContentPane(contenedor);
				setTitle("Nuevo");
				break;
			}
			case 3: {
				Container contenedor = añadirCampos(campos, datos, true);
				confirmar = new JButton("Actualizar");
				confirmar.setBounds(25, 165, 95, 25);
				cancelar = new JButton("Cancelar");
				cancelar.setBounds(135, 165, 85, 25);
				contenedor.add(confirmar);
				contenedor.add(cancelar);
				confirmar.addActionListener(Evento.getEventoRegistro());
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
				setVisible(false);
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
				this.datos.add(new JTextField());
			}
		}
		for (int x = 0; x < this.campos.size(); x++) {
			tabla.setRows(tabla.getRows() + 1);
			panelCampos.add(this.campos.get(x));
			panelCampos.add(this.datos.get(x));
		}
		return contenedor;
	}
}
