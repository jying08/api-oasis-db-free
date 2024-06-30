package com.oasis.backend.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservasServicioAdicionalPK implements Serializable {


    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "id_servicio_adicional")
    private Integer idServicioAdicional;


    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdServicioAdicional() {
        return idServicioAdicional;
    }

    public void setIdServicioAdicional(Integer idServicioAdicional) {
        this.idServicioAdicional = idServicioAdicional;
    }
}
