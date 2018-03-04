package main.java.tabla;

import java.io.Serializable;

public class Venta implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int idVenta, idVideojuegoFK, idClienteFK;
	private String licencia;
	private boolean suscripcion;
	
	public Venta() {}
	
	public Venta(int idVenta, int idVideojuegoFK, int idClienteFK, String licencia, boolean suscripcion) {
		super();
		this.idVenta = idVenta;
		this.idVideojuegoFK = idVideojuegoFK;
		this.idClienteFK = idClienteFK;
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public Venta(String licencia, boolean suscripcion) {
		super();
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public int getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(int venta) {
		this.idVenta = venta;
	}
	
	public int getIdVideojuegoFK() {
		return idVideojuegoFK;
	}


	public void setIdVideojuegoFK(int idVideojuegoFK) {
		this.idVideojuegoFK = idVideojuegoFK;
	}
	
	public int getIdClienteFK() {
		return idClienteFK;
	}


	public void setIdClienteFK(int idClienteFK) {
		this.idClienteFK = idClienteFK;
	}

	public String getLicencia() {
		return licencia;
	}


	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}


	public boolean isSuscripcion() {
		return suscripcion;
	}


	public void setSuscripcion(boolean suscripcion) {
		this.suscripcion = suscripcion;
	}
	
	
	
	
	
}
