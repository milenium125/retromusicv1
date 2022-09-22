package com.example.retromusic_v1.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancion;
    @Column(name = "nombrecancion", nullable = true)
    private String nombre;
    @Column(name = "idautor", nullable = true)
    private Long idAutor;
    @Column(name = "disco", nullable = true)
    private String disco;
    @Column(name = "genero", nullable = true)
    private String genero;
    @Column(name = "categoria", nullable = true)
    private String categoria;
    @Column(name = "audio", nullable = true)
    private String audio;
    @Column(name = "imagen", nullable = true)
    private String imagen;
    @Column(name = "fecha", nullable = true)
    private String fecha = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.now()).toString();

    //constructores

    public Cancion() {
    }

    public Cancion(Long idCancion, String nombre, Long idAutor, String disco, String genero, String categoria, String audio, String imagen, String fecha) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.idAutor = idAutor;
        this.disco = disco;
        this.genero = genero;
        this.categoria = categoria;
        this.audio = audio;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    //getters & setters

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //toString

    @Override
    public String toString() {
        return "Cancion{" +
                "idCancion=" + idCancion +
                ", nombre='" + nombre + '\'' +
                ", idAutor=" + idAutor +
                ", disco='" + disco + '\'' +
                ", genero='" + genero + '\'' +
                ", categoria='" + categoria + '\'' +
                ", audio=" + audio +
                ", imagen=" + imagen +
                '}';
    }
}
