package com.example.retromusic_v1.Entities;


import javax.persistence.*;

@Entity
@Table(name="listasreproduccion")
public class ListasReproduccion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaReproduccion;
    @Column(name = "nombrelista", nullable = false)
    private String nombreLista;
    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    //Constructores

    public ListasReproduccion() {
    }

    public ListasReproduccion(Long idListaReproduccion, String nombreLista, Long idUsuario) {
        this.idListaReproduccion = idListaReproduccion;
        this.nombreLista = nombreLista;
        this.idUsuario = idUsuario;
    }

    //getter & setter

    public Long getIdListaReproduccion() {
        return idListaReproduccion;
    }

    public void setIdListaReproduccion(Long idListaReproduccion) {
        this.idListaReproduccion = idListaReproduccion;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    //toString

    @Override
    public String toString() {
        return "ListasReproduccion{" +
                "idListaReproduccion=" + idListaReproduccion +
                ", nombreLista='" + nombreLista + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
