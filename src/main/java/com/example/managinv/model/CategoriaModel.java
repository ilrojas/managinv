package com.example.managinv.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="categoria")
@Data

public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int id_categoria;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="fecha_creacion")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha_creacion;

	@PrePersist
    protected void onCreate() {
        if (this.fecha_creacion == null) {
            this.fecha_creacion = LocalDateTime.now();
        }
    }
		
	@OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL,  fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ProductoModel> productos = new ArrayList<ProductoModel>();

	
}
