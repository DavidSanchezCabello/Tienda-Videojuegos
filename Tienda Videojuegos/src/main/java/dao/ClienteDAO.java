package main.java.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;

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

	public static void guardar(Cliente cli) throws IOException {
		session.beginTransaction();

		System.out.print("Nombre: ");
		nombre = buf.readLine();
		System.out.print("Apellidos: ");
		apellido = buf.readLine();
		System.out.print("Fecha de Nacimiento: ");
		fechaNacimiento = buf.readLine();
		System.out.print("DNI: ");
		dni = buf.readLine();
		System.out.print("Saldo: ");
		saldo = Float.parseFloat(buf.readLine());

		cli = new Cliente(idCliente, nombre, apellido, fechaNacimiento, dni, saldo);
		session.save(cli);
		session.getTransaction().commit();
	}

	public static Cliente buscarPorID(Integer id) {
		// aquí busco el id
		Cliente cli = (Cliente) session.get(Cliente.class, id);
		return cli;
	}

	public static void modificar(Cliente cli) throws NumberFormatException, IOException {
		session.beginTransaction();
		System.out.print("ID: ");
		idCliente = Integer.parseInt(buf.readLine());
		cli = buscarPorID(idCliente);
		System.out.println("Modificamos");
		System.out.print("Nombre: ");
		nombre = buf.readLine();
		System.out.print("Apellidos: ");
		apellido = buf.readLine();
		System.out.print("Fecha de Nacimiento: ");
		fechaNacimiento = buf.readLine();
		System.out.print("DNI: ");
		dni = buf.readLine();
		System.out.print("Saldo: ");
		saldo = Float.parseFloat(buf.readLine());
		cli = new Cliente(idCliente, nombre, apellido, fechaNacimiento, dni, saldo);
		session.merge(cli);
		session.getTransaction().commit();
	}
	
	public static void borrar(Cliente cli) throws NumberFormatException, IOException {
		session.beginTransaction();
		System.out.print("ID: ");
		idCliente = Integer.parseInt(buf.readLine());
		cli = buscarPorID(idCliente);

		session.delete(cli); // esto es un delete
		session.getTransaction().commit();
	}
}
