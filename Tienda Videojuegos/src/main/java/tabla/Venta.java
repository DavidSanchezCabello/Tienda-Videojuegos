package main.java.tabla;

public class Venta
{
	private static final long serialVersionUID = 1L;
	private int venta;
	private String licencia;
	private boolean suscripcion;
	
	
	public Venta(int venta, String licencia, boolean suscripcion) {
		super();
		this.venta = venta;
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public Venta(String licencia, boolean suscripcion) {
		super();
		this.licencia = licencia;
		this.suscripcion = suscripcion;
	}


	public int getVenta() {
		return venta;
	}


	public void setVenta(int venta) {
		this.venta = venta;
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
