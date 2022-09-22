package com.example.retromusic_v1.Entities;




import javax.persistence.*;



@Entity
@Table(name = "autores")
public class Autor {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fans", nullable = true)
    private Long fans = 0L;
    @Column(name = "imagen", nullable = false)
    private String imagen;
    

    //constructores

    public Autor() {
    }

    public Autor(Long idAutor, String nombre, Long fans, String imagen) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fans = fans;
        this.imagen = imagen;
    }

    //getters & setters

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
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
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", fans=" + fans +
                ", imagen=" + imagen +
                '}';
    }

    /**
     * 
     
    public MultipartFile getImg_autor() {
        return img_autor;
    }

    /**

    public void setImg_autor(MultipartFile img_autor) {
        this.img_autor = img_autor;
    }
    */
}
