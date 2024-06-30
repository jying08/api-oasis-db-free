package com.oasis.backend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicio_adicional")
public class ServicioAdicionales {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    private String descripcion;
    private Integer precio;

    @OneToMany(mappedBy = "servicioAdicionales")
    private List<ReservasServicioAdicional> reservasConServicioAdicional;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<ReservasServicioAdicional> getReservasConServicioAdicional() {
        return reservasConServicioAdicional;
    }

    public void setReservasConServicioAdicional(List<ReservasServicioAdicional> reservasConServicioAdicional) {
        this.reservasConServicioAdicional = reservasConServicioAdicional;
    }
}
