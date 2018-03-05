package main.java.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Videojuego;
import main.java.util.HibernateUtil;

public class VideojuegoDAO {
	public static Session session = HibernateUtil.getSession();
	
	public static void guardar(Videojuego vid) {
		session.save(vid);
	}
	
	public static Videojuego buscarPorID(Integer id) {
		// aqu� busco el id
		Videojuego vid = session.get(Videojuego.class, id);
		return vid;
	}
	
	public static void modificar(Videojuego vid) {
		session.update(vid);
	}
	
	public static void borrarByID(Videojuego vid) throws NumberFormatException, IOException {
		session.delete(vid); // esto es un delete
	}
	
	@SuppressWarnings("unchecked")
	public List<Videojuego> buscarTodos() {
		List<Videojuego> videojuego = new ArrayList<Videojuego>();
		Query<Videojuego> consulta = session.createQuery("from Videojuego");
		videojuego = consulta.list();
		return videojuego;
	}
	
	@SuppressWarnings("unchecked")
	// unique result(); esta consulta solo me debe dar una consulta, si da mas no
	// vale este m�todo, seria list();
	public Videojuego buscarPorTitulo(String titulo) {
		Videojuego vid;
		Query<Videojuego> consulta = session.createQuery("from Videojuego where titulo='" + titulo + "'");
		vid = consulta.uniqueResult();
		return vid;
	}
}
