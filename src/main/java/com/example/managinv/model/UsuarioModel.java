package com.example.managinv.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ntp.TimeStamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "usuario"))
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="usuario")
    private String usuario;

    @Column(name="pass")
    private String pass;

    @Column(name="fecha_creacion")
    private TimeStamp fecha_creacion;

    @Column(name="fecha_actualizacion")
    private TimeStamp fecha_actualizacion;

    @Column(name="imagen_perfil")
    private String imagen_perfil;

   /*  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
               joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"))
    private List<RolesModel> roles = new ArrayList<RolesModel>();*/

}
