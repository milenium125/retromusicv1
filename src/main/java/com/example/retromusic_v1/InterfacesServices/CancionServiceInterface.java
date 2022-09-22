package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.Cancion;

public interface CancionServiceInterface {
    public ResponseEntity<Cancion> saveCanciones(Cancion cancion);
    public List<Cancion> listarCanciones();
    public ResponseEntity<Optional<Cancion>> findCancionById(Long idCancion);
    public List<Cancion> findByDisco(String Disco);
    public List<Cancion> findByFecha(String fecha);
    public List<Cancion> findByIdAutor(Long idAutor);
    public List<Cancion> findByGenero(String genero);
    public ResponseEntity<Cancion> updateCancion(Cancion cancion);
    public ResponseEntity<Cancion> deleteCancionById(Long idCancion);
}
