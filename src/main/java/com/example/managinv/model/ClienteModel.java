package com.example.managinv.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")

public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int id_cliente;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email_cliente")
	private String email_cliente;
	
	@Column(name="telefono_cliente")
	private String telefono_cliente;
	
	@Column(name="direccion_cliente")
	private String direccion_cliente;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OrdenVentaModel> ordenes_venta = new ArrayList<OrdenVentaModel>();
	
	public ClienteModel() {
		super();
	}
	public ClienteModel(String nombre, String email, String telefono, String direccion) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.email_cliente=email;
		this.telefono_cliente=telefono;
		this.direccion_cliente=direccion;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	

}
