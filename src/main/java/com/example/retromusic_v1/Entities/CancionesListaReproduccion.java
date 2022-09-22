package com.example.retromusic_v1.Entities;


import javax.persistence.*;

@Entity
@Table(name = "cancioneslistareproduccion")
public class CancionesListaReproduccion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancionesListaReproduccion;
    @Column(name = "idcancion", nullable = false)
    private Long idCancion;
    @Column(name = "idlistareproduccion", nullable = false)
    private Long idListaReproduccion;

    //constructores

    public CancionesListaReproduccion() {
    }

    public CancionesListaReproduccion(Long idCancionesListaReproduccion, Long idCancion, Long idListaReproduccion) {
        this.idCancionesListaReproduccion = idCancionesListaReproduccion;
        this.idCancion = idCancion;
        this.idListaReproduccion = idListaReproduccion;
    }

    //getters & setters

    public Long getIdCancionesListaReproduccion() {
        return idCancionesListaReproduccion;
    }

    public void setIdCancionesListaReproduccion(Long idCancionesListaReproduccion) {
        this.idCancionesListaReproduccion = idCancionesListaReproduccion;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public Long getIdListaReproduccion() {
        return idListaReproduccion;
    }

    public void setIdListaReproduccion(Long idListaReproduccion) {
        this.idListaReproduccion = idListaReproduccion;
    }

    //toString

    @Override
    public String toString() {
        return "CancionesListaReproduccion{" +
                "idCancionesListaReproduccion=" + idCancionesListaReproduccion +
                ", idCancion=" + idCancion +
                ", idListaReproduccion=" + idListaReproduccion +
                '}';
    }
}
