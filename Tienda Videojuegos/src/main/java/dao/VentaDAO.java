package main.java.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Venta;
import main.java.util.HibernateUtil;

public class VentaDAO {
	public static Session session = HibernateUtil.getSession();
	static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	static int idVenta, idVideojuegoFK, idClienteFK;
	static String licencia;
	static boolean suscripcion;
	
	public static void guardar(Venta ven) {
		session.save(ven);
	}
	
	public static Venta buscarPorID(Integer id) {
		// aquí busco el id
		Venta ven = session.get(Venta.class, id);
		return ven;
	}
	
	public static void modificar(Venta ven) {
		ven = buscarPorID(idVenta);
		ven = new Venta(idVenta, idVideojuegoFK, idClienteFK, licencia, suscripcion);
		session.update(ven);
	}
	
	public static void borrarByID(Venta ven) throws NumberFormatException, IOException {
		ven = buscarPorID(idVenta);
		session.delete(ven); // esto es un delete
	}
	
	@SuppressWarnings("unchecked")
	public List<Venta> buscarTodos() {
		List<Venta> venta = new ArrayList<Venta>();
		Query<Venta> consulta = session.createQuery("from Venta");
		venta = consulta.list();
		return venta;
	}
	
	@SuppressWarnings("unchecked")
	// unique result(); esta consulta solo me debe dar una consulta, si da mas no
	// vale este método, seria list();
	public Venta buscarPorLicencia(String licencia) {
		Venta ven;
		Query<Venta> consulta = session.createQuery("from Venta where licencia='" + licencia + "'");
		ven = consulta.uniqueResult();
		return ven;
	}
}
