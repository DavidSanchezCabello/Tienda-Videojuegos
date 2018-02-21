package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import main.java.dao.ClienteDAO;
import main.java.tabla.Cliente;

public class Evento implements ActionListener {
	Cliente cli;

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(Window.btnNuevo)) {
			try {
				ClienteDAO.guardar(cli);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else if (ae.getSource().equals(Window.btnBorrar)) {
			try {
				ClienteDAO.borrar(cli);
			} catch (NumberFormatException | IOException e) {

				e.printStackTrace();
			}
		} else if (ae.getSource().equals(Window.btnModi)) {
			try {
				ClienteDAO.modificar(cli);
			} catch (NumberFormatException | IOException e) {

				e.printStackTrace();
			}
		} else if (ae.getSource().equals(Window.btnVer)) {
			try {
				ClienteDAO.ver(cli);
			} catch (NumberFormatException | IOException e) {

				e.printStackTrace();
			}
		}
	}

}
