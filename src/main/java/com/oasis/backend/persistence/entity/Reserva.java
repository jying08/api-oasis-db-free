package com.oasis.backend.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservas")
    private Integer idReservas;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "precio_total")
    private Integer precioTotal;

    private String estado;
    private Boolean confirmacion;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "habitacion_id")
    private Integer habitacionId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "habitacion_id", insertable = false, updatable = false)
    private Habitacion habitacion;

    @OneToMany(mappedBy = "reserva")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "reserva")
    private List<ReservasServicioAdicional> reservasConServiciosAdicionals;

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Integer habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<ReservasServicioAdicional> getReservasConServiciosAdicionals() {
        return reservasConServiciosAdicionals;
    }

    public void setReservasConServiciosAdicionals(List<ReservasServicioAdicional> reservasConServiciosAdicionals) {
        this.reservasConServiciosAdicionals = reservasConServiciosAdicionals;
    }
}
