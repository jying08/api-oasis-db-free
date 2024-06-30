package com.oasis.backend.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes_contactos")
public class SolicitudContactos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitudes")
    private Integer idSolicitudes;

    private String nombre;
    private String email;
    private String mensaje;
    private LocalDateTime fecha;
    private String estado;

    public Integer getIdSolicitudes() {
        return idSolicitudes;
    }

    public void setIdSolicitudes(Integer idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
