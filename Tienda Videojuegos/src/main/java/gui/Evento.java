package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.java.Main;
import main.java.tabla.Cliente;
import main.java.tabla.Venta;
import main.java.tabla.Videojuego;

public class Evento {

	protected static ActionListener getEventoWindow() {
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] campos = null, datos = null;
				String nombreClase = null;
				if (!e.getSource().equals(Main.ventanaPrincipal.btnBorrar)){
					if(Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Cliente")) {
						nombreClase = "Cliente";
						campos = new String[6];
						campos[0] = "Identificación: ";
						campos[1]= "Nombre: ";
						campos[2]= "Apellidos: ";
						campos[3]= "Fecha de nacimiento: ";
						campos[4]= "DNI: ";
						campos[5]= "Saldo: ";
						if(!e.getSource().equals(Main.ventanaPrincipal.btnNuevo)) {
							datos = new String[6];
							datos[0] = Integer.toString(((Cliente)Main.ventanaPrincipal.tabla).getIdCliente());
							datos[1] = ((Cliente)Main.ventanaPrincipal.tabla).getNombre();
							datos[2] = ((Cliente)Main.ventanaPrincipal.tabla).getApellido();
							datos[3] = ((Cliente)Main.ventanaPrincipal.tabla).getFechaNacimiento();
							datos[4] = ((Cliente)Main.ventanaPrincipal.tabla).getDni();
							datos[5] = Float.toString(((Cliente)Main.ventanaPrincipal.tabla).getSaldo());
						} else {
							datos = new String[0];
						}
					} else if (Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Videojuego")) {
						nombreClase = "Videojuego";
						campos = new String[6];
						campos[0] = "Identificación: ";
						campos[1]= "Titulo: ";
						campos[2]= "Versión: ";
						campos[3]= "Género: ";
						campos[4]= "Tipo de licencia: ";
						campos[5]= "Cantidad en stock: ";
						if(!e.getSource().equals(Main.ventanaPrincipal.btnNuevo)) {
							datos = new String[6];
							datos[0] = Integer.toString(((Videojuego)Main.ventanaPrincipal.tabla).getIdVideojuego());
							datos[1] = ((Videojuego)Main.ventanaPrincipal.tabla).getTitulo();
							datos[2] = ((Videojuego)Main.ventanaPrincipal.tabla).getVersion();
							datos[3] = ((Videojuego)Main.ventanaPrincipal.tabla).getGenero();
							datos[4] = ((Videojuego)Main.ventanaPrincipal.tabla).getTipoLicencia();
							datos[5] = Integer.toString(((Videojuego)Main.ventanaPrincipal.tabla).getCantidadStock());
						} else {
							datos = new String[0];
						}
					} else {
						nombreClase = "Venta";
						campos = new String[5];
						campos[0] = "Id de venta ";
						campos[1]= "Id de videojuego: ";
						campos[2]= "Id de cliente: ";
						campos[3]= "Licencia: ";
						campos[4]= "Suscripción: ";
						if(!e.getSource().equals(Main.ventanaPrincipal.btnNuevo)) {
							datos = new String[5];
							datos[0] = Integer.toString(((Venta)Main.ventanaPrincipal.tabla).getIdVenta());
							datos[1] = Integer.toString(((Venta)Main.ventanaPrincipal.tabla).getIdVideojuegoFK());
							datos[2] = Integer.toString(((Venta)Main.ventanaPrincipal.tabla).getIdClienteFK());
							datos[3] = ((Venta)Main.ventanaPrincipal.tabla).getLicencia();
							if (((Venta)Main.ventanaPrincipal.tabla).isSuscripcion()) {
								datos[4] = "Verdadero";
							} else {
								datos[4] = "Falso";
							}
						} else {
							datos = new String[0];
						}
					}	
				}
				if (e.getSource().equals(Main.ventanaPrincipal.btnNuevo)) {
					new Registro(2, campos, datos, nombreClase);
				} else if (e.getSource().equals(Main.ventanaPrincipal.btnBorrar)) {
					if(Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Cliente")) {
						int eleccion = JOptionPane.showConfirmDialog(null,
								"Estas a punto de borrar el registro con nombre "
								+ ((Cliente)Main.ventanaPrincipal.tabla).getNombre()
								+ ". ¿Deseas continuar?", "¡Borrar cliente!", JOptionPane.YES_NO_OPTION);
						if(eleccion == 1) {
							//TODO Intrucciones con clases dao para borrar el registro de la tabla cliente con sus relaciones
						}
					} else if (Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Videojuego")) {
						int eleccion = JOptionPane.showConfirmDialog(null,
								"Estas a punto de borrar el registro con nombre "
								+ ((Videojuego)Main.ventanaPrincipal.tabla).getTitulo()
								+ ". ¿Deseas continuar?", "¡Borrar videojuego!", JOptionPane.YES_NO_OPTION);
						if(eleccion == 1) {
							//TODO Intrucciones con clases dao para borrar el registro de la tabla videojuegos con sus relaciones
						}
					} else {
						int eleccion = JOptionPane.showConfirmDialog(null,
								"Estas a punto de borrar el registro con nombre "
								+ ((Videojuego)Main.ventanaPrincipal.tabla).getTitulo()
								+ ". ¿Deseas continuar?", "¡Borrar venta!", JOptionPane.YES_NO_OPTION);
						if(eleccion == 1) {
							//TODO Intrucciones con clases dao para borrar el registro de la tabla venta
						}
					}
				} else if (e.getSource().equals(Main.ventanaPrincipal.btnModi)) {
					new Registro(3, campos, datos, nombreClase);
				} else if (e.getSource().equals(Main.ventanaPrincipal.btnVer)) {
					new Registro(1, campos, datos, nombreClase);
				}
			}
		};
		return evento;
	}

	protected static ActionListener getEventoRegistro() {
		// TODO Listener de la clase Registro
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		return evento;
	}
}
