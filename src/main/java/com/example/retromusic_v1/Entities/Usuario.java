package com.example.retromusic_v1.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "correoelectronico", nullable = true)
    private String correoElectronico;
    @Column(name = "nombreusuario", nullable = true)
    private String nombreUsuario;
    @Column(name = "contrasena", nullable = true)
    private String contrasena;
    @Column(name = "fecharegistro", nullable = true)
    private String fechaRegistro;
    @Column(name = "tipoUsuario", nullable = true)
    private String tipoUsuario;


    //constructores

    public Usuario() {
    }

    public Usuario(Long idUsuario, String correoElectronico, String nombreUsuario, String contrasena, String fechaRegistro, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }
    //getters & setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    //toString

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaRegistro=" + fechaRegistro +'\'' +
                ", tipoUsuario=" + fechaRegistro +
                '}';
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return String return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
