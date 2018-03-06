package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import main.java.Main;
import main.java.tabla.Cliente;
import main.java.tabla.Venta;
import main.java.tabla.Videojuego;

public class Evento {
	
	private static final String FECHA = "\\d{4}-\\d{2}-\\d{2}";
	private static final String DNI = "\\d{8}[A-Z]";
	private static final String FLOAT = "\\d+\\.\\d+";
	private static final String INT = "\\d+";
	private static Registro registro;
	
	protected static MouseListener getEventoWindowMouse() {
		MouseListener evento = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource().equals(Main.ventanaPrincipal.pestañas)) {
					if(Main.ventanaPrincipal.pestañas.getSelectedIndex() == 0) {
						Main.ventanaPrincipal.tablaCliente.clearSelection();
						Main.ventanaPrincipal.tablaVenta.clearSelection();
						/*Main.ventanaPrincipal.tablaVideojuego.setRowSelectionInterval(0, 0);
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdVideojuego.get(Main.ventanaPrincipal.tablaVideojuego.getSelectedRow());*/
					} else if(Main.ventanaPrincipal.pestañas.getSelectedIndex() == 1) {
						Main.ventanaPrincipal.tablaVideojuego.clearSelection();
						Main.ventanaPrincipal.tablaVenta.clearSelection();
						/*Main.ventanaPrincipal.tablaCliente.setRowSelectionInterval(0, 0);
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdCliente.get(Main.ventanaPrincipal.tablaCliente.getSelectedRow());*/
					} else {
						Main.ventanaPrincipal.tablaVideojuego.clearSelection();
						Main.ventanaPrincipal.tablaCliente.clearSelection();
						/*Main.ventanaPrincipal.tablaVenta.setRowSelectionInterval(0, 0);
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdVenta.get(Main.ventanaPrincipal.tablaVenta.getSelectedRow());*/
					}
					Main.ventanaPrincipal.tabla = null;
				} else if (e.getSource().equals(Main.ventanaPrincipal.tablaVideojuego)) {
					if (Main.ventanaPrincipal.tablaVideojuego.getSelectedRow() != -1) {
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdVideojuego.get(Main.ventanaPrincipal.tablaVideojuego.getSelectedRow());
					}
				} else if (e.getSource().equals(Main.ventanaPrincipal.tablaCliente)) {
					if (Main.ventanaPrincipal.tablaCliente.getSelectedRow() != -1) {
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdCliente.get(Main.ventanaPrincipal.tablaCliente.getSelectedRow());
					}
				} else {
					if (Main.ventanaPrincipal.tablaVenta.getSelectedRow() != -1) {
						Main.ventanaPrincipal.tabla = Main.ventanaPrincipal.arrIdVenta.get(Main.ventanaPrincipal.tablaVenta.getSelectedRow());
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		return evento;
	}
	
	protected static ActionListener getEventoWindow() {
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] campos = null, datos = null;
				String nombreClase = null;
				try {
					if (!e.getSource().equals(Main.ventanaPrincipal.btnBorrar)){
						if(Main.ventanaPrincipal.pestañas.getTitleAt(Main.ventanaPrincipal.pestañas.getSelectedIndex()).equals("Cliente")) {
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
						} else if (Main.ventanaPrincipal.pestañas.getTitleAt(Main.ventanaPrincipal.pestañas.getSelectedIndex()).equals("Videojuego")) {
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
							campos[1]= "Videojuego: ";
							campos[2]= "Cliente: ";
							campos[3]= "Licencia: ";
							campos[4]= "Suscripción: ";
							if(!e.getSource().equals(Main.ventanaPrincipal.btnNuevo)) {
								datos = new String[5];
								datos[0] = Integer.toString(((Venta)Main.ventanaPrincipal.tabla).getIdVenta());
								Videojuego videojuegoFK = Main.videojuegoDao
										.buscarPorID(((Venta)Main.ventanaPrincipal.tabla).getIdVideojuegoFK());
								datos[1] = videojuegoFK.getTitulo();
								Cliente clienteFK = Main.clienteDao
										.buscarPorID(((Venta)Main.ventanaPrincipal.tabla).getIdClienteFK());
								datos[2] = clienteFK.getNombre();
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
						registro = new Registro(2, campos, datos, nombreClase);
					} else if (e.getSource().equals(Main.ventanaPrincipal.btnBorrar)) {
						List<Venta> registrosFK;
						if(Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Cliente")) {
							int eleccion = JOptionPane.showConfirmDialog(null,
									"Estas a punto de borrar el registro con nombre "
									+ ((Cliente)Main.ventanaPrincipal.tabla).getNombre()
									+ ". ¿Deseas continuar?", "¡Borrar cliente!", JOptionPane.YES_NO_OPTION);
							if(eleccion == 0) {
								registrosFK = Main.ventaDao.buscarPorClienteFK((Cliente)Main.ventanaPrincipal.tabla);
								borrado(registrosFK);
								try {
									Main.clienteDao.borrar((Cliente)Main.ventanaPrincipal.tabla);
									Main.ventanaPrincipal.generarTablas();
								} catch (NumberFormatException | IOException e1) {
									e1.printStackTrace();
								}
							}
						} else if (Main.ventanaPrincipal.tabla.getClass().getSimpleName().equals("Videojuego")) {
							int eleccion = JOptionPane.showConfirmDialog(null,
									"Estas a punto de borrar el registro de titulo "
									+ ((Videojuego)Main.ventanaPrincipal.tabla).getTitulo()
									+ ". ¿Deseas continuar?", "¡Borrar videojuego!", JOptionPane.YES_NO_OPTION);
							if(eleccion == 0) {
								registrosFK = Main.ventaDao.buscarPorVideojuegoFK((Videojuego)Main.ventanaPrincipal.tabla);
								borrado(registrosFK);
								try {
									Main.videojuegoDao.borrar((Videojuego)Main.ventanaPrincipal.tabla);
									Main.ventanaPrincipal.generarTablas();
								} catch (NumberFormatException | IOException e1) {
									e1.printStackTrace();
								}
							}
						} else {
							Videojuego videojuegoFK = Main.videojuegoDao
									.buscarPorID(((Venta)Main.ventanaPrincipal.tabla).getIdVideojuegoFK());
							Cliente clienteFK = Main.clienteDao
									.buscarPorID(((Venta)Main.ventanaPrincipal.tabla).getIdClienteFK());
							int eleccion = JOptionPane.showConfirmDialog(null,
									"Estas a punto de borrar el registro de relación del videojuego "
											+ videojuegoFK.getTitulo() + " con el cliente " + clienteFK.getNombre()
											+ ". ¿Deseas continuar?", "¡Borrar venta!", JOptionPane.YES_NO_OPTION);
							if(eleccion == 0) {
								try {
									Main.ventaDao.borrar((Venta)Main.ventanaPrincipal.tabla);
									Main.ventanaPrincipal.generarTablas();
								} catch (NumberFormatException | IOException e1) {
									e1.printStackTrace();
								}
							}
						}
					} else if (e.getSource().equals(Main.ventanaPrincipal.btnModi)) {
						registro = new Registro(3, campos, datos, nombreClase);
					} else if (e.getSource().equals(Main.ventanaPrincipal.btnVer)) {
						registro = new Registro(1, campos, datos, nombreClase);
					}
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "¡Seleccione una fila (un registro) para realizar la acción!", "¡Registro no seleccionado!", JOptionPane.WARNING_MESSAGE);
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
				if (e.getSource().equals(registro.btnConfirmar)) {
					if (registro.nombreClase.equals("Cliente")) {
						if (registro.datos.get(1).getText().length() <= 45) {
							if (registro.datos.get(2).getText().length() <= 45) {
								if (Pattern.matches(Evento.FECHA, registro.datos.get(3).getText())) {
									if (Pattern.matches(Evento.DNI, registro.datos.get(4).getText())) {
										if (Pattern.matches(Evento.FLOAT, registro.datos.get(5).getText())) {
											if (registro.btnConfirmar.getText().equals("Guardar")) {
												Main.clienteDao.guardar(new Cliente(registro.datos.get(1).getText(),
														registro.datos.get(2).getText(),
														registro.datos.get(3).getText(),
														registro.datos.get(4).getText(),
														Float.parseFloat(registro.datos.get(5).getText())));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											} else {
												Main.clienteDao.modificar(new Cliente(Integer.parseInt(registro.datos.get(0).getText()),
														registro.datos.get(1).getText(),
														registro.datos.get(2).getText(),
														registro.datos.get(3).getText(),
														registro.datos.get(4).getText(),
														Float.parseFloat(registro.datos.get(5).getText())));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											}
										} else {
											dialogoError("El saldo no es correcto. Por favor introduzcalo como número decimal con \".\"");
										}
									} else {
										dialogoError("El DNI es incorrecto. Introduzca los 8 números y su letra.");
									}
								} else {
									dialogoError("La fecha no es correcta. Introduzca una fecha con el formato aaaa-mm-dd.");
								}
							} else {
								dialogoError("El apellido no puede tener más de 45 carácteres.");
							}
						} else {
							dialogoError("El nombre no puede tener más de 45 carácteres.");
						}
					} else if (registro.nombreClase.equals("Videojuego")) {
						if (registro.datos.get(1).getText().length() <= 80) {
							if (registro.datos.get(2).getText().length() <= 20) {
								if (registro.datos.get(3).getText().length() <= 45) {
									if (registro.datos.get(4).getText().length() <= 45) {
										if (Pattern.matches(Evento.INT, registro.datos.get(5).getText())) {
											if (registro.btnConfirmar.getText().equals("Guardar")) {
												Main.videojuegoDao.guardar(new Videojuego(registro.datos.get(1).getText(),
														registro.datos.get(2).getText(),
														registro.datos.get(3).getText(),
														registro.datos.get(4).getText(),
														Integer.parseInt(registro.datos.get(5).getText())));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											} else {
												Main.videojuegoDao.modificar(new Videojuego(Integer.parseInt(registro.datos.get(0).getText()),
														registro.datos.get(1).getText(),
														registro.datos.get(2).getText(),
														registro.datos.get(3).getText(),
														registro.datos.get(4).getText(),
														Integer.parseInt(registro.datos.get(5).getText())));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											}
										} else {
											dialogoError("La cantidad de stock no es correcto. Por favor introduzcalo con un número");
										}
									} else {
										dialogoError("El tipo de licencia no puede tener más de 45 carácteres.");
									}
								} else {
									dialogoError("El género no puede tener más de 45 carácteres.");
								}
							} else {
								dialogoError("La versión no puede tener más de 20 carácteres.");
							}
						} else {
							dialogoError("El titulo no puede tener más de 80 carácteres.");
						}
					} else {
						//TODO Listener boton confimar cuando estar cargado la tabla venta
						if (registro.datos.get(1).getText().length() <= 80) {
							if (registro.datos.get(1).getText().length() <= 45) {
								if (registro.datos.get(3).getText().length() <= 45) {
									if (registro.datos.get(4).getText().equals("Verdadero") ||
											registro.datos.get(4).getText().equals("Falso")) {
										boolean suscripcion = false;
										if(registro.datos.get(4).getText().equals("Verdadero")) {
											suscripcion = true;
										}
										try {
											Videojuego videojuegoFK = Main.videojuegoDao
													.buscarPorTitulo(registro.datos.get(1).getText());
											Cliente clienteFK = Main.clienteDao
													.buscarPorNombre(registro.datos.get(2).getText());
											if (registro.btnConfirmar.getText().equals("Guardar")) {
												Main.ventaDao.guardar(new Venta(0, videojuegoFK.getIdVideojuego(),
														clienteFK.getIdCliente(),
														registro.datos.get(3).getText(),
														suscripcion));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											} else {
												Main.ventaDao.modificar(new Venta(Integer.parseInt(registro.datos.get(0).getText()),
														videojuegoFK.getIdVideojuego(),
														clienteFK.getIdCliente(),
														registro.datos.get(3).getText(),
														suscripcion));
												Main.ventanaPrincipal.generarTablas();
												registro.cerrarVentana();
											}
										} catch (NullPointerException npe) {
											JOptionPane.showMessageDialog(null, "No se puede relacionar el videojuego y/o el cliente indicado." 
													+ " Comprueba que esta introducido correctamente con uno existente.",
													"¡Imposible relacionar!", JOptionPane.WARNING_MESSAGE);
										}
									} else {
										dialogoError("Valor incorrecto en suscripción. Introduzca verdadero o falso.");
									}
								} else {
									dialogoError("El tipo de licencia no puede tener más de 45 carácteres.");
								}
							} else {
								dialogoError("El nombre del cliente no puede tener más de 45 carácteres. Ademas tiene que coincidir con algun registro de videojuego existente.");
							}
						} else {
							dialogoError("El titulo del videojuego no puede tener más de 80 carácteres. Ademas tiene que coincidir con algun registro de videojuego existente.");
						}
					}
				} else {
					registro.cerrarVentana();
				}
			}
		};
		return evento;
	}
	
	private static void borrado(List<Venta> registrosFK) {
		for (int x = 0; x < registrosFK.size(); x++) {
			try {
				Main.ventaDao.borrar((registrosFK.get(x)));
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void dialogoError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "¡Modificación no aceptada!", JOptionPane.ERROR_MESSAGE);
	}
}
