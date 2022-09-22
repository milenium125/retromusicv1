package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.CancionesListaReproduccion;
import com.example.retromusic_v1.InterfacesServices.CancionesListaReproduccionServiceInterface;
import com.example.retromusic_v1.Repositories.CancionesListaReproduccionRepository;

@Service
public class CancionesListaReproduccionService implements CancionesListaReproduccionServiceInterface {
    private CancionesListaReproduccionRepository cReproduccionRepository;
    private final Logger log = LoggerFactory.getLogger(CancionesListaReproduccionService.class);

    public CancionesListaReproduccionService(CancionesListaReproduccionRepository cReproduccionRepository){
        this.cReproduccionRepository = cReproduccionRepository;
    }

    @Override
    public ResponseEntity<CancionesListaReproduccion> saveCanciones(CancionesListaReproduccion cancion) {
        if(cancion.getIdCancionesListaReproduccion() == null){
            CancionesListaReproduccion result = cReproduccionRepository.save(cancion);
            return ResponseEntity.ok(result);
        }
        else{
            log.warn("creating a user with id");
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<CancionesListaReproduccion> listarCanciones() {
        return cReproduccionRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<CancionesListaReproduccion>> findCancionById(Long idCancion) {
        if(cReproduccionRepository.existsById(idCancion)){
            Optional<CancionesListaReproduccion> result = cReproduccionRepository.findById(idCancion);
            return ResponseEntity.ok(result);
        }
        else{
            log.warn("id cancion non existing");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<CancionesListaReproduccion> updateCancion(CancionesListaReproduccion cancion) {
        if(cancion.getIdCancionesListaReproduccion() != null){
            CancionesListaReproduccion result = cReproduccionRepository.save(cancion);
            return ResponseEntity.ok(result);
        }
        else{
            log.warn("updating cancion without id");
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<CancionesListaReproduccion> deleteCancionById(Long idCancion) {
        if(cReproduccionRepository.existsById(idCancion)){
            cReproduccionRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }
        else{
            log.warn("id cancion not found");
            return ResponseEntity.notFound().build();
        }
    }
    
}