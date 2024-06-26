package com.example.managinv.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="detalleordenventa")
public class DetalleOrdenVentaModel {

	@Id
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_unitario")
	private BigDecimal precio_unitario;
	
	@ManyToOne
	@JoinColumn(name="OrdenVenta_id_orden_venta", nullable = false)
	private OrdenVentaModel orden_venta;
	
	@ManyToOne
	@JoinColumn(name = "Producto_id_producto", nullable = false)
	private ProductoModel producto;
}
