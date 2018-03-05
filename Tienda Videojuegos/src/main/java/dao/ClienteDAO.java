package main.java.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.tabla.Cliente;
import main.java.util.HibernateUtil;

public class ClienteDAO {
	private Session session = HibernateUtil.getSession();


	public void guardar(Cliente cli) {
		session.save(cli);
	}

	public Cliente buscarPorID(Integer id) {
		Cliente cli = session.get(Cliente.class, id);
		return cli;
	}

	public void modificar(Cliente cli) {
		session.update(cli);
	}

	public void borrarByID(Cliente cli) throws NumberFormatException, IOException {
		session.delete(cli);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		List<Cliente> cliente = new ArrayList<Cliente>();
		Query<Cliente> consulta = session.createQuery("from Cliente");
		cliente = consulta.list();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	public Cliente buscarPorNombre(String nombre) {
		Cliente cli;
		Query<Cliente> consulta = session.createQuery("from Cliente where nombreCliente='" + nombre + "'");
		cli = consulta.uniqueResult();
		return cli;
	}
}
