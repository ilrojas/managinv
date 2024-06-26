package com.example.managinv.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="detalleordencompra")

public class DetalleOrdenCompraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_unitario")
	private BigDecimal precio_unitario;	
	
	@ManyToOne
	@JoinColumn(name = "OrdenCompra_id_ordencompra",nullable = false)
	private OrdenCompraModel orden_compra;
	
	@ManyToOne
	@JoinColumn(name = "Producto_id_producto",nullable = false)
	private ProductoModel producto;
}
