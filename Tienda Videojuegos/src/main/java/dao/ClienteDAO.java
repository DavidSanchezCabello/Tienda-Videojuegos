package main.java.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Cliente;
import main.java.util.HibernateUtil;

public class ClienteDAO {
	public static Session session = HibernateUtil.getSession();
	static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	static int idCliente;
	static String nombre;
	static String apellido;
	static String fechaNacimiento;
	static String dni;
	static Float saldo;

	public static void guardar(Cliente cli) {
		session.save(cli);
	}

	public static Cliente buscarPorID(Integer id) {
		// aquí busco el id
		Cliente cli = session.get(Cliente.class, id);
		return cli;
	}

	public static void modificar(Cliente cli) {
		cli = buscarPorID(idCliente);
		cli = new Cliente(idCliente, nombre, apellido, fechaNacimiento, dni, saldo);
		session.update(cli);
	}

//	public static void ver(Cliente cli) throws NumberFormatException, IOException {
//		session.beginTransaction();
//		System.out.print("ID: ");
//		idCliente = Integer.parseInt(buf.readLine());
//		cli = buscarPorID(idCliente);
//		System.out.println("Modificamos");
//		System.out.print("Nombre: ");
//		nombre = buf.readLine();
//		System.out.print("Apellidos: ");
//		apellido = buf.readLine();
//		System.out.print("Fecha de Nacimiento: ");
//		fechaNacimiento = buf.readLine();
//		System.out.print("DNI: ");
//		dni = buf.readLine();
//		System.out.print("Saldo: ");
//		saldo = Float.parseFloat(buf.readLine());
//		cli = new Cliente(idCliente, nombre, apellido, fechaNacimiento, dni, saldo);
//
//	}

	public static void borrarByID(Cliente cli) throws NumberFormatException, IOException {
		cli = buscarPorID(idCliente);
		session.delete(cli); // esto es un delete
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		List<Cliente> cliente = new ArrayList<Cliente>();
		Query<Cliente> consulta = session.createQuery("from Cliente");
		cliente = consulta.list();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	// unique result(); esta consulta solo me debe dar una consulta, si da mas no
	// vale este método, seria list();
	public Cliente buscarPorNombre(String nombre) {
		Cliente cli;
		Query<Cliente> consulta = session.createQuery("from Cliente where nombreCliente='" + nombre + "'");
		cli = consulta.uniqueResult();
		return cli;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarDel1Al5() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		Query<Cliente> consulta = session.createQuery("from Cliente s where idCliente >= 1 and idCliente<=5");
		listaCliente = consulta.list();
		return listaCliente;
	}

}
