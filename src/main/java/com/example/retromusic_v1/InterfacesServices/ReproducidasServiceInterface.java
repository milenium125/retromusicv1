package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.Reproducidas;

public interface ReproducidasServiceInterface {
    public ResponseEntity<Reproducidas> saveLista(Reproducidas cancion);
    public List<Reproducidas> listarListas();
    public ResponseEntity<Optional<Reproducidas>> findListaById(Long idCancion);
    public ResponseEntity<Reproducidas> updateLista(Reproducidas cancion);
    public ResponseEntity<Reproducidas> deleteListaById(Long idCancion);
}
