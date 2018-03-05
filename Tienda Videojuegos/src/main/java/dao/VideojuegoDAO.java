package main.java.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Videojuego;
import main.java.util.HibernateUtil;

public class VideojuegoDAO {
	private Session session = HibernateUtil.getSession();
	
	public void guardar(Videojuego vid) {
		session.save(vid);
	}
	
	public Videojuego buscarPorID(Integer id) {
		// aquí busco el id
		Videojuego vid = session.get(Videojuego.class, id);
		return vid;
	}
	
	public void modificar(Videojuego vid) {
		session.update(vid);
	}
	
	public void borrar(Videojuego vid) throws NumberFormatException, IOException {
		session.delete(vid);
	}
	
	@SuppressWarnings("unchecked")
	public List<Videojuego> buscarTodos() {
		List<Videojuego> videojuego = new ArrayList<Videojuego>();
		Query<Videojuego> consulta = session.createQuery("from Videojuego");
		videojuego = consulta.list();
		return videojuego;
	}
	
	@SuppressWarnings("unchecked")
	public Videojuego buscarPorTitulo(String titulo) {
		Videojuego vid;
		Query<Videojuego> consulta = session.createQuery("from Videojuego where titulo='" + titulo + "'");
		vid = consulta.uniqueResult();
		return vid;
	}
}
