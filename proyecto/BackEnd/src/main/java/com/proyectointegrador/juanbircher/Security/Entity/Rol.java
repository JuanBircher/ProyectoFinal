package com.proyectointegrador.juanbircher.Security.Entity;

import com.proyectointegrador.juanbircher.Security.Enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    //constructores

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    //getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
