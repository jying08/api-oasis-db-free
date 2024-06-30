package com.oasis.backend.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas_servicio_adicional")
public class ReservasServicioAdicional {

    @EmbeddedId
    private ReservasServicioAdicionalPK id;

    private LocalDateTime fecha;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "id_reserva", insertable = false, updatable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_servicio_adicional", insertable = false, updatable = false)
    private ServicioAdicionales servicioAdicionales;

    public ReservasServicioAdicionalPK getId() {
        return id;
    }

    public void setId(ReservasServicioAdicionalPK id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ServicioAdicionales getServicioAdicionales() {
        return servicioAdicionales;
    }

    public void setServicioAdicionales(ServicioAdicionales servicioAdicionales) {
        this.servicioAdicionales = servicioAdicionales;
    }
}
