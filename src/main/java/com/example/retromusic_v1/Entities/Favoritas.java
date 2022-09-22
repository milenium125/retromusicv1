package com.example.retromusic_v1.Entities;


import javax.persistence.*;

@Entity
@Table(name = "favoritas")
public class Favoritas {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFavorita;
    @Column(name = "idcancion", nullable = false)
    private Long idCancion;
    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    //Constructores

    public Favoritas() {
    }

    public Favoritas(Long idFavorita, Long idCancion, Long idUsuario) {
        this.idFavorita = idFavorita;
        this.idCancion = idCancion;
        this.idUsuario = idUsuario;
    }

    //getter & setter

    public Long getIdFavorita() {
        return idFavorita;
    }

    public void setIdFavorita(Long idFavorita) {
        this.idFavorita = idFavorita;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
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
        return "Favoritas{" +
                "idFavorita=" + idFavorita +
                ", idCancion=" + idCancion +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
