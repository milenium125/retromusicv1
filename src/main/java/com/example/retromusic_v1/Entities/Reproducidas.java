package com.example.retromusic_v1.Entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reproducidas")
public class Reproducidas {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReproducidas;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "hora", nullable = false)
    private LocalTime hora;
    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;
    @Column(name = "idCancion", nullable = false)
    private Long idCancion;

    //constructores

    public Reproducidas() {
    }

    public Reproducidas(Long idReproducidas, LocalDate fecha, LocalTime hora, Long idUsuario, Long idCancion) {
        this.idReproducidas = idReproducidas;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idCancion = idCancion;
    }

    //getter & setter

    public Long getIdReproducidas() {
        return idReproducidas;
    }

    public void setIdReproducidas(Long idReproducidas) {
        this.idReproducidas = idReproducidas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    //toString

    @Override
    public String toString() {
        return "Reproducidas{" +
                "idReproducidas=" + idReproducidas +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", idUsuario=" + idUsuario +
                ", idCancion=" + idCancion +
                '}';
    }
}
