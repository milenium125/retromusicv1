package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.ListasReproduccion;

public interface ListasReproduccionServiceInterface {
    public ResponseEntity<ListasReproduccion> saveLista(ListasReproduccion listaReproduccion);
    public List<ListasReproduccion> listarListas();
    public ResponseEntity<Optional<ListasReproduccion>> findListaById(Long idCancion);
    public ResponseEntity<ListasReproduccion> updateLista(ListasReproduccion listaReproduccion);
    public ResponseEntity<ListasReproduccion> deleteListaById(Long idCancion);
}
