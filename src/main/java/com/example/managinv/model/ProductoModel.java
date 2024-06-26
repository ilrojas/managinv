package com.example.managinv.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="producto")
public class ProductoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")	
	private String descripcion;
	
	@Column(name="precio")	
	private BigDecimal precio;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleOrdenVentaModel> ordenes_venta =new ArrayList<DetalleOrdenVentaModel>();
	
	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL,  fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleOrdenCompraModel> ordenes_compra= new ArrayList<DetalleOrdenCompraModel>();
	
	@ManyToOne
	@JoinColumn(name="Categoria_id_categoria", nullable = false)
	private CategoriaModel categoria;
	
	@ManyToOne
	@JoinColumn(name="Proveedor_id_proveedor", nullable = false)
	private ProveedorModel proveedor;
}
