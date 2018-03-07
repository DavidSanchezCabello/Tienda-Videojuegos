package main.java;

import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;

import main.java.dao.ClienteDAO;
import main.java.dao.VentaDAO;
import main.java.dao.VideojuegoDAO;
import main.java.gui.Window;

public class Main
{
	public static ClienteDAO clienteDao;
	public static VideojuegoDAO videojuegoDao;
	public static VentaDAO ventaDao;
	public static Window ventanaPrincipal;
	public static void main(String[] args)
	{
		clienteDao = new ClienteDAO();
		videojuegoDao = new VideojuegoDAO();
		ventaDao = new VentaDAO();
		ventanaPrincipal = new Window();
		
		
		
	}
	
}
