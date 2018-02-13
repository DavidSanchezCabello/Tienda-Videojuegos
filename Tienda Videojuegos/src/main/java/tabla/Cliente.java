package main.java.tabla;

import java.io.Serializable;

public class Cliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String dni;
	private float saldo;
	
	public Cliente() {}

	public Cliente(Integer idUsuario, String nombre, String apellido, String fechaNacimiento, String dni, float saldo) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.saldo = saldo;
	}

	public Cliente(String nombre, String apellido, String fechaNacimiento, String dni, float saldo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.saldo = saldo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
