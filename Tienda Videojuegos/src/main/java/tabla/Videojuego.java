package main.java.tabla;

public class Videojuego
{
	private static final long serialVersionUID = 1L;
	private int idVideojuego;
	private String titulo;
	private String version;
	private String genero;
	private String tipoLicencia;
	private int cantidadStock;
	
	public Videojuego(){}
	
	public Videojuego(int idVideojuego, String titulo, String version, String genero, String tipoLicencia,
			int cantidadStock) {
		super();
		this.idVideojuego = idVideojuego;
		this.titulo = titulo;
		this.version = version;
		this.genero = genero;
		this.tipoLicencia = tipoLicencia;
		this.cantidadStock = cantidadStock;
	}

	public Videojuego(String titulo, String version, String genero, String tipoLicencia, int cantidadStock) {
		super();
		this.titulo = titulo;
		this.version = version;
		this.genero = genero;
		this.tipoLicencia = tipoLicencia;
		this.cantidadStock = cantidadStock;
	}

	public int getIdVideojuego() {
		return idVideojuego;
	}

	public void setIdVideojuego(int idVideojuego) {
		this.idVideojuego = idVideojuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	
	
	
	
}
