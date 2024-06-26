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

@Entity
@Table(name="proveedor")
@Data
public class ProveedorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	private int id_proveedor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nombre_contacto")
	private String nombre_contacto;
	
	@Column(name="email_contacto")
	private String email_contacto;
	
	@Column(name="telefono_contacto")
	private String telefono_contacto;
	
	@Column(name="direccion")
	private String direccion;
	
	
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ProductoModel> productos=new ArrayList<ProductoModel>();
	
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OrdenCompraModel> oredenes_compra=new ArrayList<OrdenCompraModel>();
}
