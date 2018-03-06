package main.java.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Cliente;
import main.java.tabla.Venta;
import main.java.tabla.Videojuego;
import main.java.util.HibernateUtil;

public class VentaDAO {
	private Session session = HibernateUtil.getSession();
	
	public void guardar(Venta ven) {
		session.beginTransaction();
		session.save(ven);
		session.getTransaction().commit();
	}
	
	public Venta buscarPorID(Integer id) {
		Venta ven = session.get(Venta.class, id);
		return ven;
	}
	
	public void modificar(Venta ven) {
		session.beginTransaction();
		session.merge(ven);
		session.getTransaction().commit();
	}
	
	public void borrar(Venta ven) throws NumberFormatException, IOException {
		session.beginTransaction();
		session.delete(ven);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Venta> buscarTodos() {
		List<Venta> venta = new ArrayList<Venta>();
		Query<Venta> consulta = session.createQuery("from Venta");
		venta = consulta.list();
		return venta;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venta> buscarPorVideojuegoFK(Videojuego vid) {
		List<Venta> ven = new ArrayList<Venta>();
		Query<Venta> consulta = session.createQuery("from Venta where idVideojuegoFK='" + vid.getIdVideojuego() + "'");
		ven = consulta.list();
		return ven;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venta> buscarPorClienteFK(Cliente cli) {
		List<Venta> ven = new ArrayList<Venta>();
		Query<Venta> consulta = session.createQuery("from Venta where idClienteFK='" + cli.getIdCliente() + "'");
		ven = consulta.list();
		return ven;
	}
}
