package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.Cancion;
import com.example.retromusic_v1.InterfacesServices.CancionServiceInterface;
import com.example.retromusic_v1.Repositories.CancionRepository;

@Service
public class CancionService implements CancionServiceInterface{
    private CancionRepository cRepository;
    private final Logger log = LoggerFactory.getLogger(CancionService.class);
    public CancionService(CancionRepository cRepository){
        this.cRepository = cRepository;
    }

    @Override
    public ResponseEntity<Cancion> saveCanciones(Cancion cancion) {
        if(cancion.getIdCancion() == null){
            cRepository.save(cancion);
        return ResponseEntity.ok(cancion);
        }
        else{
            log.warn("Creating song with id existing");
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<Cancion> listarCanciones() {
        return cRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Cancion>> findCancionById(Long idCancion) {
        if(cRepository.existsById(idCancion)){
            Optional<Cancion> result = cRepository.findById(idCancion);
            return ResponseEntity.ok(result);
        }
        else{
            log.warn("finding song non exixting");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Cancion> updateCancion(Cancion cancion) {
        if(cancion.getIdCancion() == null){
            return ResponseEntity.badRequest().build();
        }
        if(cRepository.existsById(cancion.getIdCancion())){
            Cancion result = cRepository.save(cancion);
            return ResponseEntity.ok(result);
        }
        else{
            log.warn("Update cancion non exixting");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Cancion> deleteCancionById(Long idCancion) {
        if(cRepository.existsById(idCancion)){
            cRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }
        else{
            log.warn("deleting a Id non existing");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Cancion> findByDisco(String Disco) {
        return cRepository.findByDisco(Disco); 
    }

    @Override
    public List<Cancion> findByFecha(String fecha) {
        return cRepository.findByFecha(fecha);
    }

    @Override
    public List<Cancion> findByIdAutor(Long idAutor) { 
        return cRepository.findByIdAutor(idAutor);
    }

    @Override
    public List<Cancion> findByGenero(String genero) {
        return cRepository.findByGenero(genero);
    }
    
}