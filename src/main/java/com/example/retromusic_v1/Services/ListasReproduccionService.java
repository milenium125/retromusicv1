package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.ListasReproduccion;
import com.example.retromusic_v1.InterfacesServices.ListasReproduccionServiceInterface;
import com.example.retromusic_v1.Repositories.ListasReproduccionRepository;


@Service
public class ListasReproduccionService implements ListasReproduccionServiceInterface {
    private ListasReproduccionRepository lRepository;
    private final Logger log = LoggerFactory.getLogger(ListasReproduccionService.class);

    public ListasReproduccionService(ListasReproduccionRepository lRepository){
        this.lRepository = lRepository;
    }

    @Override
    public ResponseEntity<ListasReproduccion> saveLista(ListasReproduccion listaReproduccion) {
        if(listaReproduccion.getIdListaReproduccion() == null){
            ListasReproduccion result = lRepository.save(listaReproduccion);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<ListasReproduccion> listarListas() {
        return lRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<ListasReproduccion>> findListaById(Long idCancion) {
        if(lRepository.existsById(idCancion)){
            Optional<ListasReproduccion> result = lRepository.findById(idCancion);
            return ResponseEntity.ok(result); 
        }
        else{
            log.warn("id Lista not existing");
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ListasReproduccion> updateLista(ListasReproduccion listaReproduccion) {
        if(listaReproduccion.getIdListaReproduccion() != null){
            if(lRepository.existsById(listaReproduccion.getIdListaReproduccion())){
                ListasReproduccion result = lRepository.save(listaReproduccion);
                return ResponseEntity.ok(result);
            }
            else{
                log.warn("updating lista with id not existing");
                return ResponseEntity.notFound().build();
            }
        }
        else{
            log.warn("updating lista without id");
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<ListasReproduccion> deleteListaById(Long idCancion) {
        if(lRepository.existsById(idCancion)){
            lRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }
        else{
            log.warn("trying delete lista not found");
            return ResponseEntity.notFound().build();
        }
    }

    
}