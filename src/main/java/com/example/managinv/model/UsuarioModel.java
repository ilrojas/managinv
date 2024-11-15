package com.example.managinv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @Column(name="usuario", unique = true)
    private String usuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="pass")
    private String pass;

    @Column(name="is_Enabled")
    private boolean isEnabled;
    @Column(name="account_No_Expired")
    private boolean accountNoExpired;
    @Column(name="account_No_Locked")
    private boolean accountNoLocked;
    @Column(name="credential_No_Expired")
    private boolean credentialNoExpired;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="fecha_actualizacion")
    private Date fecha_actualizacion;

    @Column(name="imagen_perfil")
    private String imagen_perfil;

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
               joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"))
    private List<RolesModel> roles = new ArrayList<RolesModel>();

}
