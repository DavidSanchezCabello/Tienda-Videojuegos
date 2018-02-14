package main.java.tabla;

public class Venta
{
	private static final long serialVersionUID = 1L;
	private int idVenta;
	private String licencia;
	private boolean suscripcion;
	
	public Venta() {
	}
	
	public Venta(int idVenta, String licencia, boolean suscripcion) {
		super();
		this.idVenta = idVenta;
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public Venta(String licencia, boolean suscripcion) {
		super();
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public int getVenta() {
		return idVenta;
	}


	public void setVenta(int venta) {
		this.idVenta = venta;
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
