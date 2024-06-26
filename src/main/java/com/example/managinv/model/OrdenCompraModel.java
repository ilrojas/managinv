package com.example.managinv.model;

import java.math.BigDecimal;
import java.sql.Date;
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

@Data
@Entity
@Table(name="ordencompra")
public class OrdenCompraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_orden_compra")
	private int id_orden_compra;
	
	@Column(name="fecha_orden")
	private Date fecha_orden;
	
	@Column(name="total")
	private BigDecimal total;	
	
	@ManyToOne
	@JoinColumn(name = "Proveedor_id_proveedor",nullable = false)
	private ProveedorModel proveedor;
	
	@OneToMany(mappedBy = "orden_compra",cascade = CascadeType.ALL,  fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleOrdenCompraModel> detallesOrdenCompra= new ArrayList<DetalleOrdenCompraModel>();
}
