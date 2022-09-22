package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.CancionesListaReproduccion;


public interface CancionesListaReproduccionServiceInterface {
    public ResponseEntity<CancionesListaReproduccion> saveCanciones(CancionesListaReproduccion cancion);
    public List<CancionesListaReproduccion> listarCanciones();
    public ResponseEntity<Optional<CancionesListaReproduccion>> findCancionById(Long idCancion);
    public ResponseEntity<CancionesListaReproduccion> updateCancion(CancionesListaReproduccion cancion);
    public ResponseEntity<CancionesListaReproduccion> deleteCancionById(Long idCancion);
}
