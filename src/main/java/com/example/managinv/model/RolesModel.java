package com.example.managinv.model;

/*import java.util.ArrayList;
import java.util.List;*/

import org.apache.commons.net.ntp.TimeStamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*import jakarta.persistence.ManyToMany;*/
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="roles")
@Data
public class RolesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="rol")
    private String rol;

    @Column(name="fecha_creacion")
    private TimeStamp fecha_creacion;

    @Column(name="fecha_actualizacion")
    private TimeStamp fecha_actualizacion;

   /* @ManyToMany(mappedBy = "roles")
    private List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();*/
}
